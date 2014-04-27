package com.VierGewinnt.screens;

import com.VierGewinnt.VierGewinnt;
import com.VierGewinnt.dialogs.NotImplementedDialog;
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
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class OptionMenuScreen implements Screen{

	private Stage stage;
	private TextureAtlas atlas;
	private Skin skin;
	private Table table;
	private TextButton buttonPush, buttonSound, buttonFeedback, buttonNoAd, buttonBack;
	private BitmapFont white, black;
	private Label heading;
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 1, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		SpriteBatch batch = new SpriteBatch();
		
		batch.begin();
		batch.draw(TexturesManager.getbG(), 0, 0,
				Gdx.graphics.getWidth()*1.3f, Gdx.graphics.getHeight());
		batch.end();
		
//		Table.drawDebug(stage);

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

		// creating Buttooons :D
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = skin.getDrawable("default-round");
		textButtonStyle.down = skin.getDrawable("default-round-down");
		textButtonStyle.pressedOffsetX = 1;
		textButtonStyle.pressedOffsetY = -1;
		textButtonStyle.font = black;
		
		// der String hinter dem + soll noch je nachdem geändert werden können (muss noch implementiert werden)
		buttonSound = new TextButton("Sound: " + "An", textButtonStyle);
		buttonSound.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y){
				// ToDo Safe sharedpreferences
				
				NotImplementedDialog nID = new NotImplementedDialog("", TexturesManager.getSkin());
				nID.show(stage);
			}
		});
		buttonSound.pad(30);
		
		buttonPush = new TextButton("Push: " + "An", textButtonStyle);
		buttonPush.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y){
				// ToDo Safe sharedpreferences
				
				NotImplementedDialog nID = new NotImplementedDialog("", TexturesManager.getSkin());
				nID.show(stage);
			}
		});
		buttonPush.pad(30);
		
		buttonFeedback = new TextButton("Feedback", textButtonStyle);
		buttonFeedback.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y){
				// ToDo Safe sharedpreferences
				
				NotImplementedDialog nID = new NotImplementedDialog("", TexturesManager.getSkin());
				nID.show(stage);
			}
		});
		buttonFeedback.pad(30);
		
		buttonNoAd = new TextButton("Werbung entfernen", textButtonStyle);
		buttonNoAd.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y){
				// ToDo Safe sharedpreferences
				
				NotImplementedDialog nID = new NotImplementedDialog("", TexturesManager.getSkin());
				nID.show(stage);
			}
		});
		buttonNoAd.pad(30);
		
		buttonBack = new TextButton("Zurück", textButtonStyle);
		buttonBack.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y){
				((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu());
			}
		});
		buttonBack.pad(30);
		
		// creating heading :)
		heading = new Label("Optionen", new LabelStyle(white, Color.ORANGE));
		heading.setFontScale(Gdx.graphics.getDensity()*3);
		
		// putting the stuff together...
		table.add(heading);
		table.getCell(heading).spaceBottom(100);
		table.row();
		table.add(buttonSound).prefWidth(Gdx.graphics.getWidth()/2);
		table.getCell(buttonSound).spaceBottom(15);
		table.row();
		table.add(buttonPush).prefWidth(Gdx.graphics.getWidth()/2);
		table.getCell(buttonPush).spaceBottom(15);
		table.row();
		table.add(buttonFeedback).prefWidth(Gdx.graphics.getWidth()/2);
		table.getCell(buttonFeedback).spaceBottom(15);
		table.row();
		table.add(buttonNoAd).prefWidth(Gdx.graphics.getWidth()/2);
		table.getCell(buttonNoAd).spaceBottom(15);
		table.row();
		table.add(buttonBack).prefWidth(Gdx.graphics.getWidth()/2);
		table.getCell(buttonBack).spaceBottom(15);
		table.debug();
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
