package com.VierGewinnt.screen;

import com.VierGewinnt.VierGewinnt;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;


public class MenuScreen extends AbstractScreen{


    OrthographicCamera camera;
	
	public MenuScreen(VierGewinnt game)
	{
		super(game);
	}
    public void render(float delta) {

//        camera.update();
//        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        font.draw(batch, "Welcome to Drop!!! ", 100, 150);
        font.draw(batch, "Tap anywhere to begin!", 100, 100);
        batch.end();

        if (Gdx.input.isTouched()) {
 //           game.setScreen(new GameScreen(game));
            dispose();
        }
    }


}
