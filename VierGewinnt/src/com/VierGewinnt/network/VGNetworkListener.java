package com.VierGewinnt.network;

import com.esotericsoftware.kryonet.Connection;
import com.viergewinnt.server.tcp_messages.ServerMessage;

public interface VGNetworkListener {
	public void recieve(Connection connection, ServerMessage msg);
}
