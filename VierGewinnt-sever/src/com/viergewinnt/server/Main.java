package com.viergewinnt.server;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.viergewinnt.javaConsole.JavaConsole;

public class Main {
	public static void main(String[] args) throws Exception {
		new JavaConsole();

		Server server = new Server();
		server.start();
		server.bind(23965);

		server.addListener(new Listener() {
			@Override
			public void received(Connection connection, Object object) {
				if (object instanceof String) {
					System.out.println((String) object);
				} else {
					System.out.println("[4-8-15]: " + object.toString());
				}
			}
		});

		for (;;) {
			Thread.sleep(0);
		}

		// System.exit(0);
	}

}
