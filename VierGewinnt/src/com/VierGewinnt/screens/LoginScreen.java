package com.VierGewinnt.screens;

import com.VierGewinnt.VierGewinnt;
import com.VierGewinnt.dialogs.NotImplementedDialog;
import com.VierGewinnt.models.TexturesManager;
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
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class LoginScreen implements Screen{
	
	private Stage stage;
	private TextureAtlas atlas;
	private Skin skin;
	private Table table;
	private TextButton buttonRegister;
	private BitmapFont white, black;
	private Label heading, loginLabel, nameLabel;
	private TextField txtUsername;
	
	private String usernameStr = "";

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
		
		buttonRegister = new TextButton("Login", textButtonStyle);
		buttonRegister.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				
				NotImplementedDialog nID = new NotImplementedDialog(usernameStr, TexturesManager.getSkin());
				nID.show(stage);
			}

		});
		buttonRegister.pad(15);
		
		// creating heading :)
		heading = new Label(VierGewinnt.TITLE, new LabelStyle(black, Color.ORANGE));
		heading.setFontScale(Gdx.graphics.getDensity()*3);
		
		// creating Labels
		loginLabel = new Label("Login", new LabelStyle(white, Color.BLUE));
		loginLabel.setFontScale(Gdx.graphics.getDensity()*3);
		nameLabel = new Label("Bitte Nickname eingeben:", new LabelStyle(white, Color.BLUE));
		nameLabel.setFontScale(Gdx.graphics.getDensity()*3);
		
		// creating TextField
		txtUsername = new TextField("", TexturesManager.getSkin());
		txtUsername.setMessageText("Username");
		txtUsername.setTextFieldListener(new TextFieldListener() {
	            @Override
	            public void keyTyped(TextField textField, char key) {
	                    usernameStr = txtUsername.getText();
	            }
	        });
		
		table.add(heading);
		table.getCell(heading).spaceBottom(100);
		table.row();
		table.add(loginLabel);
		table.getCell(loginLabel).spaceBottom(50);
		table.row();
		table.add(nameLabel);
		table.getCell(nameLabel).spaceBottom(30);
		table.row();
		table.add(txtUsername);
		table.getCell(txtUsername).spaceBottom(15);
		table.row();
		table.add(buttonRegister).prefWidth(Gdx.graphics.getWidth()/2);
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
