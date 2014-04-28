package com.VierGewinnt;

import com.VierGewinnt.models.TexturesManager;
import com.VierGewinnt.network.VGNetworkAdapter;
import com.VierGewinnt.screens.LoginScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class VierGewinnt extends Game {
	public static final String TITLE = "VierGewinnt", VERSION = "0.0.0.0 reallyCarly";

	private static VierGewinnt instance = null;
	
	private VGNetworkAdapter network = new VGNetworkAdapter();
	
	@Override
	public void create() {	
		if (instance != null)
			System.out.println("Can't create mor than one static VG instance");
		
		instance = this;
		
		//AudioManager.loadAudio();  wait for audio
		
		try {
			network.connect();			
		} catch (Exception e) {
			e.printStackTrace();
			network = null;
		}
		
		TexturesManager.loadTextures();
		
		((Game) Gdx.app.getApplicationListener()).setScreen(new LoginScreen());
	}
	
	public static VierGewinnt getInstance() {
		return instance;
	}

	public VGNetworkAdapter getNetworkClient() {
		return network;
	}
}
