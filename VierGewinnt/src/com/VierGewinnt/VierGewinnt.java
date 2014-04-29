package com.VierGewinnt;

import com.VierGewinnt.models.TexturesManager;
import com.VierGewinnt.network.VGNetworkAdapter;
import com.VierGewinnt.screens.LoginScreen;
import com.VierGewinnt.screens.MainMenuScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class VierGewinnt extends Game {
	public static final String TITLE = "VierGewinnt", VERSION = "0.0.0.0 reallyCarly";

	public static Preferences prefs;

	private static VierGewinnt instance = null;

	private VGNetworkAdapter network = new VGNetworkAdapter();

	public static boolean isOnline;

	@Override
	public void create() {
		if (instance != null)
			System.out.println("Can't create mor than one static VG instance");

		instance = this;

		// AudioManager.loadAudio(); wait for audio
		prefs = Gdx.app.getPreferences("settings");

		try {
			network.connect();
			isOnline = true;

		} catch (Exception e) {
			System.out.println("Connection to Server failed");
			network = null;
			isOnline = false;
		}

		TexturesManager.loadTextures();

		if (isOnline) {
			((Game) Gdx.app.getApplicationListener()).setScreen(new LoginScreen());
		} else {
			((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenuScreen());
		}
	}

	public static VierGewinnt getInstance() {
		return instance;
	}

	public VGNetworkAdapter getNetworkClient() {
		return network;
	}

	public static boolean isOnline() {
		return isOnline;
	}
}
