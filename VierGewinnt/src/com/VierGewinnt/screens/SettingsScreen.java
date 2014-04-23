package com.VierGewinnt.screens;

import com.VierGewinnt.models.TexturesManager;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class SettingsScreen implements Screen{
	
	private Stage stage;
	private TextureAtlas atlas;
	private Skin skin;
	private Table table;
	private TextButton buttonProfil, buttonDifficulty, buttonOption, buttonBack;
	private BitmapFont white, black;
	private Label heading;

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		SpriteBatch batch = new SpriteBatch();
		
		batch.begin();
		batch.draw(TexturesManager.getbG(), 0, 0,
				Gdx.graphics.getWidth()*1.3f, Gdx.graphics.getHeight());
		batch.end();
		
		stage.act(delta);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		stage.setViewport(width, height, true);
		table.invalidateHierarchy();
		table.setSize(width, height);		
	}

	@Override
	public void show() {
		stage = new Stage();
		
		Gdx.input.setInputProcessor(stage);
		
		skin = TexturesManager.getSkin();
		
		table = new Table(skin);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		// creating Fonts...
		white = new BitmapFont(Gdx.files.internal("font/white.fnt"), false);
		black = new BitmapFont(Gdx.files.internal("font/black.fnt"), false);
		
		// creating Buttons 
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = skin.getDrawable("btn.up");
		textButtonStyle.down = skin.getDrawable("btn.down");
		textButtonStyle.pressedOffsetX = 1;
		textButtonStyle.pressedOffsetY = -1;
		textButtonStyle.font = black;
		
		buttonProfil = new TextButton("Profil", textButtonStyle);
		buttonProfil.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y){
				((Game) Gdx.app.getApplicationListener()).setScreen(new ProfilScreen());
			}
		});
		buttonProfil.pad(15);
		
		buttonDifficulty = new TextButton("Schwierigkeit", textButtonStyle);
		buttonDifficulty.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y){
				// ToDO
			}
		});		
		buttonDifficulty.pad(15);
		
		buttonOption = new TextButton("Optionen", textButtonStyle);
		buttonOption.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y){
				// ToDO
			}
		});
		buttonOption.pad(15);
		
		buttonBack = new TextButton("Zurück", textButtonStyle);
		buttonBack.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y){
				((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu());
			}
		});
		buttonBack.pad(15);
		
		// creating heading
		heading = new Label("Einstellungen", new LabelStyle(black, Color.ORANGE));
		heading.setFontScale(3);
		
		// putting the stuff together...
		table.add(heading);
		table.getCell(heading).spaceBottom(150);
		table.row();
		table.add(buttonProfil).prefWidth(Gdx.graphics.getWidth()/2);
		table.getCell(buttonProfil).spaceBottom(15);
		table.row();
		table.add(buttonDifficulty).prefWidth(Gdx.graphics.getWidth()/2);
		table.getCell(buttonDifficulty).spaceBottom(15);
		table.row();
		table.add(buttonOption).prefWidth(Gdx.graphics.getWidth()/2);
		table.getCell(buttonOption).spaceBottom(15);
		table.row();
		table.add(buttonBack).prefWidth(Gdx.graphics.getWidth()/2);
		table.getCell(buttonBack).spaceBottom(15);
		
		stage.addActor(table);
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
