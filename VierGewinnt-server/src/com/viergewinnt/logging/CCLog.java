package com.viergewinnt.logging;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.Vector;

import javax.swing.SwingUtilities;

/**
 * A little Logging Class
 * 
 * originates from jClipCorn
 * 
 * @author Mike Schw�rer
 *
 */
public class CCLog {
	private static List<CCLogElement> log = new Vector<>();
	private static List<CCLogChangedListener> listener = new Vector<>();
	
	private static boolean changed = false;

	public static void addInformation(Exception e) {
		add(e.toString(), CCLogType.LOG_ELEM_INFORMATION, e.getStackTrace());
	}
	
	public static void addInformation(String e) {
		add(e, CCLogType.LOG_ELEM_INFORMATION);
	}

	public static void addWarning(String e) {
		add(e, CCLogType.LOG_ELEM_WARNING);
	}
	
	public static void addWarning(String s, Exception e) {
		add(s + '\n' + "\tcaused by" + e.toString(), CCLogType.LOG_ELEM_WARNING, e.getStackTrace()); //$NON-NLS-1$
	}

	public static void addError(String e) {
		add(e, CCLogType.LOG_ELEM_ERROR);
	}
	
	public static void addError(String e, StackTraceElement[] trace) {
		add(e, CCLogType.LOG_ELEM_ERROR, trace);
	}

	public static void addError(Exception e) {
		add(e.toString(), CCLogType.LOG_ELEM_ERROR, e.getStackTrace());
	}
	
	public static void addError(String s, Exception e) {
		add(s + '\n' + "\tcaused by" + e.toString(), CCLogType.LOG_ELEM_ERROR, e.getStackTrace()); //$NON-NLS-1$
	}
	
	public static void addFatalError(Exception e) {
		add(e.toString(), CCLogType.LOG_ELEM_FATALERROR, e.getStackTrace());
	}
	
	public static void addFatalError(String e) {
		add(e, CCLogType.LOG_ELEM_FATALERROR);
	}
	
	public static void addFatalError(String e, StackTraceElement[] trace) {
		add(e, CCLogType.LOG_ELEM_FATALERROR, trace);
	}
	
	public static void addFatalError(String s, Exception e) {
		add(s + '\n' + "\tcaused by" + e.toString(), CCLogType.LOG_ELEM_FATALERROR, e.getStackTrace()); //$NON-NLS-1$
	}

	private static void add(String txt, CCLogType type) {
		add(txt, type, new Throwable().getStackTrace());
	}
	
	public static void addUndefinied(Thread thread, Throwable throwable) {
		add('[' + thread.toString() + ']' + ' ' + throwable.toString(), CCLogType.LOG_ELEM_UNDEFINED, throwable.getStackTrace());
	}

	private static void add(String txt, CCLogType type, StackTraceElement[] trace) {
		CCLogElement cle = new CCLogElement(txt, type, trace);
		log.add(cle);
		
//		if (type == CCLogType.LOG_ELEM_FATALERROR) {
//			System.exit(-1);
//		}
		
		System.out.println(cle.getFormatted()); // This is desired - let it be
		
		setChangedFlag();
	}
	
	public static void removeFirstNLine(File f, int toRemove) throws IOException {
	    RandomAccessFile raf = new RandomAccessFile(f, "rw"); //$NON-NLS-1$

	    long writePos = raf.getFilePointer();
	    
	    for (int i = 0; i < toRemove; i++) {
	    	raf.readLine();
	    }
	    
	    raf.readLine();
	    long readPos = raf.getFilePointer();

	    byte[] buf = new byte[2048];
	    int bufbyte;
	    while (-1 != (bufbyte = raf.read(buf))) {
	        raf.seek(writePos);
	        raf.write(buf, 0, bufbyte);
	        readPos += bufbyte;
	        writePos += bufbyte;
	        raf.seek(readPos);
	    }

	    raf.setLength(writePos);
	    raf.close();
	}
	
	public static int getCount(CCLogType type) {
		int count = 0;
		for(CCLogElement el : log) {
			if (el.isType(type)) count++;
		}
		
		return count;
	}
	
	public static CCLogElement getElement(CCLogType type, int position) {
		int count = 0;
		for(CCLogElement el : log) {
			if (el.isType(type)) {
				if (count == position) return el;
				count++;
			}
		}
		
		return null;
	}
	
	public static void addChangeListener (CCLogChangedListener lst) {
		listener.add(lst);
	}
	
	public static void setChangedFlag() {
		changed = true;
		
		if (! SwingUtilities.isEventDispatchThread()) {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					for(CCLogChangedListener ls : listener) {
						ls.onChanged();
					}
				}
			});
		} else {
			for(CCLogChangedListener ls : listener) {
				ls.onChanged();
			}
		}
	}
	
	public static boolean isChanged() {
		if (changed) {
			changed = false;
			return true;
		}
		return false;
	}
	
	public static boolean hasErrors() {
		for (CCLogElement e : log) {
			if (e.isType(CCLogType.LOG_ELEM_ERROR)) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasWarnings() {
		for (CCLogElement e : log) {
			if (e.isType(CCLogType.LOG_ELEM_WARNING)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean hasInformations() {
		for (CCLogElement e : log) {
			if (e.isType(CCLogType.LOG_ELEM_INFORMATION)) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasUndefinieds() {
		for (CCLogElement e : log) {
			if (e.isType(CCLogType.LOG_ELEM_UNDEFINED)) {
				return true;
			}
		}
		return false;
	}
	
	public static CCLogType getHighestType() {
		if (hasErrors()) {
			return CCLogType.LOG_ELEM_ERROR;
		}
		
		if (hasUndefinieds()) {
			return CCLogType.LOG_ELEM_UNDEFINED;
		}
		
		if (hasWarnings()) {
			return CCLogType.LOG_ELEM_WARNING;
		}
		
		return CCLogType.LOG_ELEM_INFORMATION;
	}
}
