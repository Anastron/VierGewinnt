package com.viergewinnt.server.tcp_messages.server;

import com.viergewinnt.server.tcp_messages.ServerMessage;

public class RegisterAcknowledged extends ServerMessage {
	public String username;
	public String userid;
	public String usersecret;
}
