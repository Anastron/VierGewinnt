package com.VierGewinnt.screens;

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
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ProfilScreen implements Screen {

	private Stage stage;
	private TextureAtlas atlas;
	private Skin skin;
	private Table table;
	private TextButton buttonChangeNick, buttonLastGames, buttonBack;
	private BitmapFont white, black;
	private Label heading, playerName, rankPlace, rankPoints, rankWins, rankLoses;

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 1, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		SpriteBatch batch = new SpriteBatch();

		batch.begin();
		batch.draw(TexturesManager.getbG(), 0, 0, Gdx.graphics.getWidth() * 1.3f, Gdx.graphics.getHeight());
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

		// creating Buttooons :D
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = skin.getDrawable("default-round");
		textButtonStyle.down = skin.getDrawable("default-round-down");
		textButtonStyle.pressedOffsetX = 1;
		textButtonStyle.pressedOffsetY = -1;
		textButtonStyle.font = black;

		buttonChangeNick = new TextButton("Name ändern", textButtonStyle);
		buttonChangeNick.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				NotImplementedDialog nID = new NotImplementedDialog("", TexturesManager.getSkin());
				nID.show(stage);
			}

		});
		buttonChangeNick.pad(30);

		buttonLastGames = new TextButton("Letzte Spiele", textButtonStyle);
		buttonLastGames.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				NotImplementedDialog nID = new NotImplementedDialog("", TexturesManager.getSkin());
				nID.show(stage);
			}

		});
		buttonLastGames.pad(30);
		
		buttonBack = new TextButton("Zurück", textButtonStyle);
		buttonBack.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				((Game) Gdx.app.getApplicationListener()).setScreen(new SettingsScreen());
			}
		});
		buttonBack.pad(30);

		// creating heading :)
		heading = new Label("Profil", new LabelStyle(white, Color.ORANGE));
		heading.setFontScale(Gdx.graphics.getDensity() * 3);

		// creating other Labels
		playerName = new Label("SAM", new LabelStyle(white, Color.GREEN)); // Spieler Name soll von der einer DB aufgerufen werden
		playerName.setFontScale(Gdx.graphics.getDensity() * 3);

		rankPlace = new Label("Rank: " + "2", new LabelStyle(white, Color.GREEN)); // anstatt 2 soll der Rang geladen werden
		rankPlace.setFontScale(Gdx.graphics.getDensity() * 3);
		
		rankPoints = new Label("Punkte: " + "1245", new LabelStyle(white, Color.GREEN)); //anstatt 1245 soll die tatsächliche Punkte angezeigt werden
		rankPoints.setFontScale(Gdx.graphics.getDensity() * 3);

		// putting the stuff together...
		table.add(heading);
		table.getCell(heading).spaceBottom(50);
		table.row();
		table.add(playerName);
		table.getCell(playerName).spaceBottom(20);
		table.row();
		table.add(rankPlace);
		table.getCell(rankPlace).spaceBottom(10);
		table.row();
		table.add(rankPoints);
		table.getCell(rankPoints).spaceBottom(40);
		table.row();
		table.add(buttonChangeNick).prefWidth(Gdx.graphics.getWidth() / 2);
		table.getCell(buttonChangeNick).spaceBottom(15);
		table.row();
		table.add(buttonLastGames).prefWidth(Gdx.graphics.getWidth() / 2);
		table.getCell(buttonLastGames).spaceBottom(15);
		table.row();
		table.add(buttonBack).prefWidth(Gdx.graphics.getWidth() / 2);
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
