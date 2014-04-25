package com.VierGewinnt.screens;

import com.VierGewinnt.models.TexturesManager;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class OnlineMenuScreen implements Screen{
	
	private Stage stage;
	private Skin skin;
	private Table table;
	private TextButton buttonFastGame, buttonNormalGame, buttonRanking, buttonAddFriends, buttonFriendsList, buttonBack;
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
		
		buttonNormalGame = new TextButton("Normales Spiel", textButtonStyle);
		buttonNormalGame.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y){
				// ToDo
			}
		});
		buttonNormalGame.pad(15);
		
		buttonFastGame = new TextButton("Schnelles Spiel", textButtonStyle);
		buttonFastGame.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y){
				// ToDo
			}
		});
		buttonFastGame.pad(15);
		
		buttonRanking = new TextButton("Rangliste", textButtonStyle);
		buttonRanking.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y){
				((Game) Gdx.app.getApplicationListener()).setScreen(new RankingScreen());
			}
		});
		buttonRanking.pad(15);
		
		buttonAddFriends = new TextButton("Freund hinzuf�gen", textButtonStyle);
		buttonAddFriends.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y){
				//ToDo
			}
		});
		buttonAddFriends.pad(15);
		
		buttonFriendsList = new TextButton("Freunde", textButtonStyle);
		buttonFriendsList.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y){
				//ToDo
			}
		});
		buttonFriendsList.pad(15);
		
		buttonBack = new TextButton("Zur�ck", textButtonStyle);
		buttonBack.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y){
				((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu());
			}
		});
		buttonBack.pad(15);
		
		// creating heading
		heading = new Label("Online Multiplayer", new LabelStyle(white, Color.BLUE));
		heading.setFontScale(3);
		
		// putting the stuff together...
		table.add(heading);
		table.getCell(heading).spaceBottom(150);
		table.row();
		table.add(buttonNormalGame).prefWidth(Gdx.graphics.getWidth()/2);
		table.getCell(buttonNormalGame).spaceBottom(15);
		table.row();
		table.add(buttonFastGame).prefWidth(Gdx.graphics.getWidth()/2);
		table.getCell(buttonFastGame).spaceBottom(15);
		table.row();
		table.add(buttonRanking).prefWidth(Gdx.graphics.getWidth()/2);
		table.getCell(buttonRanking).spaceBottom(15);
		table.row();
		table.add(buttonAddFriends).prefWidth(Gdx.graphics.getWidth()/2);
		table.getCell(buttonAddFriends).spaceBottom(15);
		table.row();
		table.add(buttonFriendsList).prefWidth(Gdx.graphics.getWidth()/2);
		table.getCell(buttonFriendsList).spaceBottom(15);
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