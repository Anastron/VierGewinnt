package com.viergewinnt.server;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.FrameworkMessage;
import com.esotericsoftware.kryonet.Server;
import com.viergewinnt.database.VGDatabase;
import com.viergewinnt.logging.CCLog;
import com.viergewinnt.server.tcp_messages.ClientMessage;
import com.viergewinnt.server.tcp_messages.TCPMessage;
import com.viergewinnt.server.tcp_messages.client.RegisterRequest;
import com.viergewinnt.server.tcp_messages.server.RegisterAcknowledged;
import com.viergewinnt.server.tcp_messages.server.RegisterDenied;
import com.viergewinnt.server.tcp_messages.server.RegisterDenied.RegisterDeniedReason;
import com.viergewinnt.util.CCDate;

public class VGServer extends GameServer {
	public final static int PORT = 23965;
	
	public final VGDatabase Database;
	
	public VGServer() throws IOException {
		super(new Server(), PORT);
		
		Database = new VGDatabase();
		
		if (Database.tryconnect()) {
			CCLog.addInformation("Connected to Database");
		} else {
			CCLog.addFatalError("Connection to DB failed", Database.getLastError());
		}
		
		TCPMessage.registerKryo(server.getKryo());
	}
	
	@Override
	public void idle(Connection connection) {
		// NOP
	}
	
	@Override
	public void received(Connection connection, Object object) {
		
		if (object instanceof String) {
			CCLog.addInformation("[DEBUGMSG]" + (String) object);
		} else if (object instanceof ClientMessage) {
			CCLog.addInformation("[RECIEVED]" + object.toString());
			
			GameClient client = GetClient(connection);
			
			if (connection != null) {
				handleClientMessage(client, (ClientMessage) object);
			}
		} else if (object instanceof FrameworkMessage) {
			// IGNORE
		} else {
			CCLog.addWarning("[UNKNOWN]" + object.toString());
		}
	}
	
	private void handleClientMessage(GameClient client, ClientMessage msg) {
		if (msg instanceof RegisterRequest) {
			handleRegisterRequest(client, (RegisterRequest) msg);
		}
	}
	
	private void handleRegisterRequest(GameClient client, RegisterRequest msg) {
		String un = msg.username;
		un = un.replace("\0", "");
		un = un.replace("\r", "");
		un = un.replace("\n", "");
		un = un.replace("'", "");
		un = un.replace("\\", "");
		
		if (client.isLoggedIn()) {
			send(client, new RegisterDenied(RegisterDeniedReason.ALREADY_LOGGED_IN));
		} else if (msg.username.isEmpty()) {
			send(client, new RegisterDenied(RegisterDeniedReason.INVALID_USERNAME));
		} else {
			String ui = UUID.randomUUID().toString();
			String us = UUID.randomUUID().toString();
			
			int dbuid = Database.addUser(un, ui, us, CCDate.getCurrentDate(), 0);
			
			client.setLoggedIn(this, dbuid);
			
			send(client, new RegisterAcknowledged(un, ui, us));
		}
	}

	public void quit() throws SQLException {
		Database.closeDBConnection(true);
		server.close();
	}
}