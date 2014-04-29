package com.viergewinnt.server.tcp_messages.client;

import com.viergewinnt.server.tcp_messages.ClientMessage;

public class LoginRequest extends ClientMessage {
	public String userid;
	public String usersecret;
}
