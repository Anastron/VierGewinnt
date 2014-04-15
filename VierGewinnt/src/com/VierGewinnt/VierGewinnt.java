package com.VierGewinnt;



import com.VierGewinnt.screen.SplashScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;


public class VierGewinnt extends Game {
	private FPSLogger fpsLogger;
	public static final String LOG = VierGewinnt.class.getSimpleName();
	
	public SplashScreen getSplashScreen()
	{
		return new SplashScreen( this );
	}
	
	@Override
	public void create() {	
		Gdx.app.log(VierGewinnt.LOG, "Creating Game");
		fpsLogger = new FPSLogger();
		setScreen(getSplashScreen());
	}

	@Override
	public void dispose() {
		Gdx.app.log( VierGewinnt.LOG, "Disposing Game");
	}

	@Override
	public void render() {		
		super.render();
 
        // output the current FPS
        fpsLogger.log();
	}

	@Override
	public void resize(int width, int height) {
		Gdx.app.log(VierGewinnt.LOG, "Resizing game to; " + width + " x " + height);
	}

	@Override
	public void pause() {
		Gdx.app.log( VierGewinnt.LOG,  "Pausing Game");
	}

	@Override
	public void resume() {
		Gdx.app.log( VierGewinnt.LOG, "Resuming Game");
	}
}
