package com.viergewinnt;

import com.viergewinnt.javaConsole.JavaConsole;
import com.viergewinnt.logging.CCLog;
import com.viergewinnt.server.VGServer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		JavaConsole c = new JavaConsole();

		CCLog.addInformation("Starting VG Server");
		
		VGServer s = new VGServer();
		
		while (! c.quit) {
			Thread.sleep(0);
		}
		
		s.quit();
		
		System.exit(0);
	}

}
