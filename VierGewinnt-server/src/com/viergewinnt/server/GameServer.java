package com.viergewinnt.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.viergewinnt.logging.CCLog;
import com.viergewinnt.server.tcp_messages.ServerMessage;

public abstract class GameServer extends Listener {
	protected Server server;
	
	protected List<GameClient> ActiveConnections;
	
	public GameServer(Server s, int port) throws IOException {
		server = s;
		
		server.start();
		server.bind(port);
		server.addListener(this);
		
		ActiveConnections = new ArrayList<>();
	}
	
	protected GameClient GetClient(Connection c) {
		return GetClient(c.getID());
	}
	
	protected GameClient GetClient(int conn_id) {
		for (GameClient client : ActiveConnections) {
			if (client.getConnectionID() == conn_id) {
				return client;
			}
		}
		
		return null;
	}
	
	@Override
	public void connected(Connection connection) {
		ActiveConnections.add(new GameClient(connection));
		
		CCLog.addInformation("[CONNECTED]" + connection.getID());
		
		showDebugPlayerList();
	}
	
	@Override
	public void disconnected(Connection connection) {
		GameClient client = GetClient(connection);
		ActiveConnections.remove(client);
		CCLog.addInformation("[DISCONNECTED]" + client.toString());
		
		showDebugPlayerList();
	}
	
	private void showDebugPlayerList() {
		StringBuilder b = new StringBuilder();
		b.append("\r\n");
		b.append("######## CONNECTED CLIENTS ########\r\n");
		for (GameClient client : ActiveConnections)
			b.append(client.toString() + "\r\n");
		b.append("###################################\r\n");
		b.append("\r\n");
		
		CCLog.addInformation(b.toString());
	}
	
	public void send(GameClient client, ServerMessage msg) {
		server.sendToTCP(client.getConnectionID(), msg);
		CCLog.addInformation("[SEND] -->" + client.getUsername() + " :: " + client.toString());
	}
}
