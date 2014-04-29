package com.VierGewinnt.dialogs;

import com.VierGewinnt.screens.MainMenuScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class LoginFailDialog extends Dialog {

	public LoginFailDialog(String title, Skin skin, String failString) {
		super(title, skin);

		text("Register Failed: " + failString);
		button("OK");
	}

	protected void result(Object object) {
		((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenuScreen());
	}

}
