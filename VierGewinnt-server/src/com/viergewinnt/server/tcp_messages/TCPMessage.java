package com.viergewinnt.server.tcp_messages;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.esotericsoftware.kryo.Kryo;
import com.viergewinnt.server.tcp_messages.client.LoginRequest;
import com.viergewinnt.server.tcp_messages.client.RegisterRequest;
import com.viergewinnt.server.tcp_messages.server.LoginAcknowledged;
import com.viergewinnt.server.tcp_messages.server.RegisterAcknowledged;
import com.viergewinnt.server.tcp_messages.server.RegisterDenied;

public abstract class TCPMessage {

	public TCPMessage() {
		// TODO Auto-generated constructor stub
	}

	public static void registerKryo(Kryo kryo) {
		kryo.register(LoginRequest.class);
		kryo.register(LoginAcknowledged.class);
		
		kryo.register(RegisterRequest.class);
		kryo.register(RegisterDenied.class);
		kryo.register(RegisterAcknowledged.class);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
