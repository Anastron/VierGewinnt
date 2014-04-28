package com.VierGewinnt.network;

import com.esotericsoftware.kryonet.Client;
import com.viergewinnt.server.tcp_messages.ClientMessage;
import com.viergewinnt.server.tcp_messages.TCPMessage;

public class VGNetworkAdapter {
	private Client networkClient = null;
	
	public VGNetworkAdapter() {
		
	}
	
	public void connect() {
		networkClient = new Client();
		networkClient.start();
	    TCPMessage.registerKryo(networkClient.getKryo());
	}
	
	public void send(ClientMessage msg) {
		networkClient.sendTCP(msg);
	}
	
	
}
