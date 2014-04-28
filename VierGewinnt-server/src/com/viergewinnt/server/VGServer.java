package com.viergewinnt.server;

import java.io.IOException;
import java.util.UUID;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Server;
import com.viergewinnt.server.tcp_messages.ClientMessage;
import com.viergewinnt.server.tcp_messages.TCPMessage;
import com.viergewinnt.server.tcp_messages.client.RegisterRequest;
import com.viergewinnt.server.tcp_messages.server.RegisterAcknowledged;
import com.viergewinnt.server.tcp_messages.server.RegisterDenied;
import com.viergewinnt.server.tcp_messages.server.RegisterDenied.RegisterDeniedReason;

public class VGServer extends GameServer {
	public final static int PORT = 23965;
	
	public VGServer() throws IOException {
		super(new Server(), PORT);
		
		TCPMessage.registerKryo(server.getKryo());
	}
	
	@Override
	public void idle(Connection connection) {
		// NOP
	}
	
	@Override
	public void received(Connection connection, Object object) {
		System.out.println("[RECIEVED]" + object.toString());
		
		if (object instanceof String) {
			System.out.println("[DEBUGMSG]" + (String) object);
		} else if (object instanceof ClientMessage) {
			GameClient client = GetClient(connection);
			
			if (connection != null) {
				handleClientMessage(client, (ClientMessage) object);
			}
		} else {
			System.out.println("[UNKNOWN]" + object.toString());
		}
	}
	
	private void handleClientMessage(GameClient client, ClientMessage msg) {
		if (msg instanceof RegisterRequest) {
			handleRegisterRequest(client, (RegisterRequest) msg);
		}
	}
	
	private void handleRegisterRequest(GameClient client, RegisterRequest msg) {
		if (client.isLoggedIn() || msg.username.isEmpty()) {
			send(client, new RegisterDenied(RegisterDeniedReason.ALREADY_LOGGED_IN));
		} else {
			String un = msg.username;
			String ui = UUID.randomUUID().toString();
			String us = UUID.randomUUID().toString();
			
			client.setLoggedIn(un, ui, us);
			
			send(client, new RegisterAcknowledged(un, ui, us));
		}
	}
}