package com.viergewinnt.server;

import com.esotericsoftware.kryonet.Connection;

public class GameClient {

	private boolean loggedIn = false;
	private String username;
	private String userid;
	private String usersecret;
	
	private Connection connection;
	
	public GameClient(Connection conn) {
		this.connection = conn;
	}

	public int getConnectionID() {
		return connection.getID();
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}
	
	@Override
	public String toString() {
		if (isLoggedIn())
			return String.format("USER [BN: %s] {%s  :  %s}", username, userid, usersecret);
		else
			return String.format("USER[CONNID: " + getConnectionID() + "]");
	}

	public void setLoggedIn(String un, String ui, String us) {
		loggedIn = true;
		username = un;
		userid = ui;
		usersecret = us;
	}
}
