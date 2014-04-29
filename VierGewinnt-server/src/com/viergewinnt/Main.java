package com.viergewinnt;

import com.viergewinnt.javaConsole.JavaConsole;
import com.viergewinnt.server.VGServer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		new JavaConsole();

		new VGServer();
		
		for (;;) {
			Thread.sleep(0);
		}
	}

}
