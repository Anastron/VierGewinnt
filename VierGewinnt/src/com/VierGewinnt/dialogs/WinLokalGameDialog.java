package com.VierGewinnt.dialogs;

import com.VierGewinnt.screens.LocalGameScreen;
import com.VierGewinnt.screens.MainMenuScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class WinLokalGameDialog extends Dialog{
	


	public WinLokalGameDialog(String title, Skin skin, int player) {
		super(title, skin);
		
		if(player == 0){
			text("Gelb gewinnt");
		}else{
			text("Rot gewinnt");
		}
		
		button("Neues Spiel",true);
		button("Menü",false);
	}
	
	@Override
	protected void result(Object object){
		if((Boolean) object){
			((Game) Gdx.app.getApplicationListener()).setScreen(new LocalGameScreen());
		}else
			((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenuScreen());
	}
}
