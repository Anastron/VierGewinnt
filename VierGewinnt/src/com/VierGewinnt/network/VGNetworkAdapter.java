package com.VierGewinnt.network;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.viergewinnt.server.GameClient;
import com.viergewinnt.server.VGServer;
import com.viergewinnt.server.tcp_messages.ClientMessage;
import com.viergewinnt.server.tcp_messages.ServerMessage;
import com.viergewinnt.server.tcp_messages.TCPMessage;

public class VGNetworkAdapter {
	private final static String SERVER_IP = "127.0.0.1";
	private final static int SERVER_TIMEOUT = 5000;
	
	private Client networkClient = null;
	
	private HashMap<Class<? extends ServerMessage>, List<VGNetworkListener>> listener = new HashMap<Class<? extends ServerMessage>, List<VGNetworkListener>>();
	
	public VGNetworkAdapter() {
		
	}
	
	public void connect() throws IOException {
		networkClient = new Client();
		networkClient.start();
		networkClient.connect(SERVER_TIMEOUT, SERVER_IP, VGServer.PORT);
	    
	    TCPMessage.registerKryo(networkClient.getKryo());
	    
	    networkClient.addListener(new Listener(){
	    	@Override
	    	public void connected(Connection connection) {
	    		System.out.println("conn");
	    	}
	    	
	    	@Override
	    	public void disconnected(Connection connection) {
	    		System.out.println("disconn");
	    	}
	    	
	    	@Override
			public void received(Connection connection, java.lang.Object object) {
				for (Class<? extends ServerMessage> cls : listener.keySet()) {
					if (cls.isInstance(object)) {
						for (VGNetworkListener lst : listener.get(cls)) {
							lst.recieve(connection, (ServerMessage) object);
						}
					}
				}
	    	}
	    });
	}
	
	public void send(ClientMessage msg) {
		networkClient.sendTCP(msg);
	}
	
	public void addListener(Class<? extends ServerMessage> c, VGNetworkListener l) {
		if (listener.containsKey(c)) {
			listener.get(c).add(l);
		} else {
			List<VGNetworkListener> nal = new ArrayList<VGNetworkListener>();
			nal.add(l);
			listener.put(c, nal);
		}
	}
}
