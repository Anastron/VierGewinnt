package com.viergewinnt.server;

import com.esotericsoftware.kryonet.Server;
import com.viergewinnt.javaConsole.JavaConsole;

public class Main {
	
	public static void main(String[] args) throws Exception {
		new JavaConsole();

		Server server = new Server();
		server.start();
		server.bind(VGServer.PORT);

		server.addListener(new VGServer(server));

		for (;;) {
			Thread.sleep(0);
		}
	}

}
