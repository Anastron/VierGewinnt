package com.VierGewinnt.screens;

import com.VierGewinnt.models.VGGame;
import com.VierGewinnt.unifiedInputProcessor.UnifiedInputProcessor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class LocalGameScreen implements Screen {

	private VGGame game;

	private OrthographicCamera cam;

	public LocalGameScreen() {
		super();

		cam = new OrthographicCamera();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 1, 1, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		cam.update();

		game.render(cam);
	}

	@Override
	public void resize(int width, int height) {
		cam.setToOrtho(false, width, height);
		game.resize(width, height);
	}

	@Override
	public void show() {
		game = new VGGame(10, 8);
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
