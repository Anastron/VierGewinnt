package com.viergewinnt.logging;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * A Global Exception Handler - thread-wide
 * 
 * originates from jClipCorn
 * 
 * @author Mike Schwörer
 *
 */
public class ExceptionHandler implements UncaughtExceptionHandler {
	private static ExceptionHandler instance = null;
	
	public static ExceptionHandler getInstance() {
		if (instance != null) {
			return instance;
		} else {
			return instance = new ExceptionHandler();
		}
	}

	@Override
	public void uncaughtException(Thread thread, Throwable throwable) {
		CCLog.addUndefinied(thread, throwable);
	}

}
