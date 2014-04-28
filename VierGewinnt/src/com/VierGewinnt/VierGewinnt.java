package com.VierGewinnt;

import com.VierGewinnt.models.TexturesManager;
import com.VierGewinnt.screens.LoginScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.esotericsoftware.kryonet.Client;
import com.viergewinnt.server.tcp_messages.TCPMessage;

public class VierGewinnt extends Game {
	public static final String TITLE = "VierGewinnt", VERSION = "0.0.0.0 reallyCarly";

	private static VierGewinnt instance = null;
	
	private Client networkClient = null;
	
	@Override
	public void create() {	
		if (instance != null)
			System.out.println("Can't create mor than one static VG instance");
		
		instance = this;
		
		//AudioManager.loadAudio();  wait for audio
		
		networkClient = new Client();
		networkClient.start();
	    TCPMessage.registerKryo(networkClient.getKryo());
		
		TexturesManager.loadTextures();
		
		((Game) Gdx.app.getApplicationListener()).setScreen(new LoginScreen());
	}
	
	public VierGewinnt getInstance() {
		return instance;
	}

	public Client getNetworkClient() {
		return networkClient;
	}
}
