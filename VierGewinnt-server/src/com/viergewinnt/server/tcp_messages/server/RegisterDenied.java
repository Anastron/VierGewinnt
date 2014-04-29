package com.viergewinnt.server.tcp_messages.server;

import com.viergewinnt.server.tcp_messages.ServerMessage;

public class RegisterDenied extends ServerMessage {
	public enum RegisterDeniedReason {
		DUPLICATE_USERNAME,
		IP_BANNED,
		ALREADY_LOGGED_IN,
		INVALID_USERNAME;
		
		@Override
		public String toString() {
			switch (this) {
			case DUPLICATE_USERNAME:
				return "Username already taken";
			case IP_BANNED:
				return "Your IP was banned";
			case ALREADY_LOGGED_IN:
				return "You are already logged in";
			case INVALID_USERNAME:
				return "Your username is not valid";
			default:
				return "<?>";
			}
		}
	}

	public RegisterDeniedReason reason;
	
	public RegisterDenied() { /* (Mr.) Bean */}
	
	public RegisterDenied(RegisterDeniedReason r) {
		this.reason = r;
	}
}
