package com.viergewinnt.server.tcp_messages.client;

import com.viergewinnt.server.tcp_messages.ClientMessage;

public class RegisterRequest extends ClientMessage {
	
	public String username;

	public RegisterRequest() { /* (Mr.) Bean */}
	
	public RegisterRequest(String u) {
		this.username = u;
	}
}
