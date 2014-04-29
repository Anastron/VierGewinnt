package com.VierGewinnt.dialogs;

import com.VierGewinnt.screens.MainMenuScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class LoginGoodDialog extends Dialog{

	public LoginGoodDialog(String title, Skin skin, String userName) {
		super(title, skin);
		
		text("Willkommen " + userName);
		button("Weiter");
	}
	protected void result(Object object){
			((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenuScreen());	
	}
}
