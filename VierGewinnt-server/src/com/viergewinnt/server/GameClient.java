package com.viergewinnt.server;

import com.esotericsoftware.kryonet.Connection;
import com.viergewinnt.util.CCDate;

public class GameClient {
	private int database_ID = -1;
	
	private boolean loggedIn = false;
	
	public String username;
	public String userid;
	public String usersecret;
	public int points;
	public CCDate registerDate;
	
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

	public void setLoggedIn(VGServer server, int dbuid) {
		loggedIn = true;
		
		database_ID = dbuid;

		server.Database.setUserValues(this, database_ID);
	}

	public String getUsername() {
		return username;
	}

	public String getUserID() {
		return userid;
	}

	public String getUserSecret() {
		return usersecret;
	}
}
