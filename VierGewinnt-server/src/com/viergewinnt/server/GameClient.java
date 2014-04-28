package com.viergewinnt.server;

import com.esotericsoftware.kryonet.Connection;

public class GameClient {

	private Connection connection;
	
	public GameClient(Connection conn) {
		this.connection = conn;
	}

	public int getConnectionID() {
		return connection.getID();
	}

	@Override
	public String toString() {
		return "USR_"+getConnectionID();
	}
}
