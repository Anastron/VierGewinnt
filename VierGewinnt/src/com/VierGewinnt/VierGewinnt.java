package com.VierGewinnt;

import com.VierGewinnt.models.TexturesManager;
import com.VierGewinnt.screens.LoginScreen;
import com.VierGewinnt.screens.MainMenuScreen;
import com.VierGewinnt.screens.Splash;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class VierGewinnt extends Game {
	public static final String TITLE = "VierGewinnt", VERSION = "0.0.0.0 reallyCarly";

	@Override
	public void create() {	
		//AudioManager.loadAudio();  wait for audio
		
		TexturesManager.loadTextures();
		
		((Game) Gdx.app.getApplicationListener()).setScreen(new LoginScreen());
	}
}
