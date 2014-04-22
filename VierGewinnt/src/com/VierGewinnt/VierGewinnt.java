package com.VierGewinnt;

import com.VierGewinnt.screens.Splash;
import com.badlogic.gdx.Game;

public class VierGewinnt extends Game {
	public static final String TITLE = "VierGewinnt", VERSION = "0.0.0.0 reallyCarly";

	@Override
	public void create() {	
		//AudioManager.loadAudio();  wait for audio
		
		//TexturesManager.loadTextures(); wait for images
		
		setScreen(new Splash());
	}
}
