package com.viergewinnt.server.tcp_messages;

import com.esotericsoftware.kryo.Kryo;
import com.viergewinnt.server.tcp_messages.client.LoginRequest;
import com.viergewinnt.server.tcp_messages.server.LoginAcknowledged;

public abstract class TCPMessage {

	public TCPMessage() {
		// TODO Auto-generated constructor stub
	}

	public static void registerKryo(Kryo kryo) {
		kryo.register(LoginRequest.class);
		kryo.register(LoginAcknowledged.class);
	}
}
