package com.viergewinnt.server;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Server;
import com.viergewinnt.server.tcp_messages.TCPMessage;
import com.viergewinnt.server.tcp_messages.client.LoginRequest;
import com.viergewinnt.server.tcp_messages.server.LoginAcknowledged;

public class VGServer extends GameServer {
	
	public VGServer(Server s) {
		super(s);
		
		TCPMessage.registerKryo(server.getKryo());
	}
	
	@Override
	public void idle(Connection connection) {
		// NOP
	}
	
	@Override
	public void received(Connection connection, java.lang.Object object) {
		if (object instanceof String) {
			System.out.println((String) object);
		} else {
			System.out.println("[4-8-15]: " + object.toString());
		}
	}
}
