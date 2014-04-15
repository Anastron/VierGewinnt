package com.VierGewinnt.screen;

import com.VierGewinnt.VierGewinnt;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public abstract class AbstractScreen implements Screen {
	// the fixed viewport dimensions (ratio: 1.6)
    public static final int GAME_VIEWPORT_WIDTH = 400, GAME_VIEWPORT_HEIGHT = 240;
    public static final int MENU_VIEWPORT_WIDTH = 800, MENU_VIEWPORT_HEIGHT = 480;
    
	protected final VierGewinnt game;
	protected final Stage stage;

	protected final BitmapFont font;
	protected final SpriteBatch batch;
	private Skin skin;

	public AbstractScreen(VierGewinnt game) {
		this.game = game;
		this.font = new BitmapFont();
		this.batch = new SpriteBatch();
		int width = (isGameScreen() ? GAME_VIEWPORT_WIDTH : MENU_VIEWPORT_WIDTH);
		int height = (isGameScreen() ? GAME_VIEWPORT_HEIGHT
				: MENU_VIEWPORT_HEIGHT);
		this.stage = new Stage(width, height, true);
	}

	@Override
	public void show() {
	}

	@Override
	public void resize(int width, int height) {

		Gdx.app.log(VierGewinnt.LOG, "Resizing screen: " + getName() + " to: "
				+ width + " x " + height);

	}

	@Override
	public void render(float delta) {
		// the following code clears the screen with the given RGB color (black)
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		font.dispose();
		batch.dispose();
	}

	protected Skin getSkin() {
		if (skin == null) {
			FileHandle skinFile = Gdx.files.internal("skin/uiskin.json");
			skin = new Skin(skinFile);
		}
		return skin;
	}

	protected String getName() {
		return getClass().getSimpleName();
	}
    protected boolean isGameScreen()
    {
        return false;
    }

}
