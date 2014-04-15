package com.VierGewinnt;



import com.VierGewinnt.screens.Splash;
import com.badlogic.gdx.Game;



public class VierGewinnt extends Game {

	public static final String TITLE = "VierGewinnt", VERSION = "0.0.0.0 reallyCarly";

	@Override
	public void create() {	
		setScreen(new Splash());
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render() {		
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}



	
}
