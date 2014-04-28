package com.viergewinnt.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
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
		
		System.out.println("[CONNECTED]" + connection.getID());
		
		showDebugPlayerList();
	}
	
	@Override
	public void disconnected(Connection connection) {
		GameClient client = GetClient(connection);
		ActiveConnections.remove(client);
		System.out.println("[DISCONNECTED]" + client.toString());
		
		showDebugPlayerList();
	}
	
	private void showDebugPlayerList() {
		System.out.println();
		System.out.println("######## CONNECTED CLIENTS ########");
		for (GameClient client : ActiveConnections)
			System.out.println(client.toString());
		System.out.println("###################################");
		System.out.println();
	}
	
	public void send(GameClient client, ServerMessage msg) {
		server.sendToTCP(client.getConnectionID(), msg);
	}
}
