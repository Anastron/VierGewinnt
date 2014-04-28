package com.viergewinnt.server.tcp_messages.server;

import com.viergewinnt.server.tcp_messages.ServerMessage;

public class RegisterDenied extends ServerMessage {
	public enum RegisterDeniedReason {
		DUPLICATE_USERNAME,
		IP_BANNED
	}
	
	public RegisterDeniedReason reason;
}
