package com.VierGewinnt.screens;

import com.VierGewinnt.dialogs.WinLokalGameDialog;
import com.VierGewinnt.models.TexturesManager;
import com.VierGewinnt.models.VGGame;
import com.VierGewinnt.unifiedInputProcessor.UnifiedInputProcessor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;


public class LocalGameScreen implements Screen {

	private VGGame game;
	
	private OrthographicCamera cam;

	public LocalGameScreen() {
		super();

		cam = new OrthographicCamera();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		SpriteBatch batch = new SpriteBatch();
		
		batch.begin();
		batch.draw(TexturesManager.getbG(), 0, 0,
				Gdx.graphics.getWidth()*1.3f, Gdx.graphics.getHeight());		
		batch.end();

		cam.update();

		game.render(cam);
		
		if(game.getGameEnd()){
			WinLokalGameDialog winDia = new WinLokalGameDialog("Win", TexturesManager.getSkin());
			Stage stage = new Stage();
			winDia.show(stage);
		}
	}

	@Override
	public void resize(int width, int height) {
		cam.setToOrtho(false, width, height);
		game.resize(width, height);
	}

	@Override
	public void show() {
		game = new VGGame(7, 6);
		Gdx.input.setInputProcessor(new UnifiedInputProcessor(game));
	}

	@Override
	public void hide() {
		// NOP
	}

	@Override
	public void pause() {
		// NOP
	}

	@Override
	public void resume() {
		// NOP
	}

	@Override
	public void dispose() {
		game.dispose();
	}
}
