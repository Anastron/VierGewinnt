package com.VierGewinnt.screens;

import com.VierGewinnt.VierGewinnt;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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

public class MainMenu implements Screen {

	private Stage stage;
	private TextureAtlas atlas;
	private Skin skin;
	private Table table;
	private TextButton buttonComputer, buttonExit, buttonLokal, buttonOnline, buttonRanking, buttonSettings;
	private BitmapFont white, black;
	private Label heading;
	

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 1, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		Table.drawDebug(stage);

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

		atlas = new TextureAtlas("ui/button.pack");
		skin = new Skin(atlas);

		table = new Table(skin);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		// creating Fonts...
		white = new BitmapFont(Gdx.files.internal("font/white.fnt"), false);
		black = new BitmapFont(Gdx.files.internal("font/black.fnt"), false);

		// creating Buttooons :D
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = skin.getDrawable("button.up");
		textButtonStyle.down = skin.getDrawable("button.down");
		textButtonStyle.pressedOffsetX = 1;
		textButtonStyle.pressedOffsetY = -1;
		textButtonStyle.font = black;

		buttonExit = new TextButton("Exit", textButtonStyle);
		buttonExit.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				Gdx.app.exit();
			}

		});
		buttonExit.pad(15);
		
		buttonComputer = new TextButton("Computer Game", textButtonStyle);
		buttonComputer.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y){
				((Game) Gdx.app.getApplicationListener()).setScreen(new ComputerScreen());
			}
		});
		buttonComputer.pad(15);
		
		buttonLokal = new TextButton("Lokal Multiplayer", textButtonStyle);
		buttonLokal.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y){
				((Game) Gdx.app.getApplicationListener()).setScreen(new LokalGameScreen());
			}
		});
		buttonLokal.pad(15);
		
		buttonOnline = new TextButton("Online Multiplayer", textButtonStyle);
		buttonOnline.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y){
				((Game) Gdx.app.getApplicationListener()).setScreen(new OnlineGameScreen());
			}
		});
		buttonOnline.pad(15);
		
		buttonRanking = new TextButton("Rangliste", textButtonStyle);
		buttonRanking.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y){
				((Game) Gdx.app.getApplicationListener()).setScreen(new RankingScreen());
			}
		});
		buttonRanking.pad(15);
		
		buttonSettings = new TextButton("Einstellungen", textButtonStyle);
		buttonSettings.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y){
				((Game) Gdx.app.getApplicationListener()).setScreen(new SettingsScreen());
			}
		});
		buttonSettings.pad(15);
		
		
		// creating heading :)
		heading = new Label(VierGewinnt.TITLE, new LabelStyle(white, Color.WHITE));
		heading.setFontScale(3);

		// putting the stuff together...
		table.add(heading);
		table.getCell(heading).spaceBottom(100);
		table.row();
		table.add(buttonComputer);
		table.getCell(buttonComputer).spaceBottom(15);
		table.row();
		table.add(buttonLokal);
		table.getCell(buttonLokal).spaceBottom(15);
		table.row();
		table.add(buttonOnline);
		table.getCell(buttonOnline).spaceBottom(15);
		table.row();
		table.add(buttonRanking);
		table.getCell(buttonRanking).spaceBottom(15);
		table.row();
		table.add(buttonSettings);
		table.getCell(buttonSettings).spaceBottom(15);
		table.row();
		table.add(buttonExit);
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
		stage.dispose();
		atlas.dispose();
		skin.dispose();
		white.dispose();
		black.dispose();
	}

}
