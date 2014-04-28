package com.VierGewinnt;

import com.VierGewinnt.models.TexturesManager;
import com.VierGewinnt.screens.Splash;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class VierGewinnt extends Game {
	public static final String TITLE = "VierGewinnt", VERSION = "0.0.0.0 reallyCarly";
	
	public static Preferences prefs;

	@Override
	public void create() {	
		//AudioManager.loadAudio();  wait for audio
		
		prefs = Gdx.app.getPreferences("settings");
		
		TexturesManager.loadTextures();
		
		setScreen(new Splash());
	}
}
