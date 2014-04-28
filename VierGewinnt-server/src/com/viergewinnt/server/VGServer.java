package com.viergewinnt.server;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Server;
import com.viergewinnt.server.tcp_messages.ClientMessage;
import com.viergewinnt.server.tcp_messages.TCPMessage;
import com.viergewinnt.server.tcp_messages.client.RegisterRequest;
import com.viergewinnt.server.tcp_messages.server.RegisterAcknowledged;

public class VGServer extends GameServer {
	public final static int PORT = 23965;
	
	public VGServer(Server s) {
		super(s);
		
		TCPMessage.registerKryo(server.getKryo());
	}
	
	@Override
	public void idle(Connection connection) {
		// NOP
	}
	
	@Override
	public void received(Connection connection, Object object) {
		System.out.println("[#RECIEVED]" + object.toString());
		
		if (object instanceof String) {
			System.out.println("[DBG]: " + (String) object);
		} else if (object instanceof ClientMessage) {
			GameClient client = GetClient(connection);
			
			if (connection != null)
				handleClientMessage(client, (ClientMessage) object);
		} else {
			System.out.println("[4-8-15]: " + object.toString());
		}
	}
	
	private void handleClientMessage(GameClient client, ClientMessage msg) {
		if (msg instanceof RegisterRequest) {
			send(client, new RegisterAcknowledged(((RegisterRequest)msg).username, "BN", "PW")); //TODO GUID
		}
	}
}