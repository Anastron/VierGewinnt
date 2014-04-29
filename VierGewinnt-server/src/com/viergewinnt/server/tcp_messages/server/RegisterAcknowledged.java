package com.viergewinnt.server.tcp_messages.server;

import com.viergewinnt.server.tcp_messages.ServerMessage;

public class RegisterAcknowledged extends ServerMessage {
	public String username;
	public String userid;
	public String usersecret;
	
	public RegisterAcknowledged() { /* (Mr.) Bean */}
	
	public RegisterAcknowledged(String n, String i, String s) {
		this.username = n;
		this.userid = i;
		this.usersecret = s;
	}
}
