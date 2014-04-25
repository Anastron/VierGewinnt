package com.VierGewinnt.dialogs;

import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class WinLokalGameDialog extends Dialog{

	public WinLokalGameDialog(String title, Skin skin) {
		super(title, skin);
	}
	
	{
		text("Spieler Farbe gewinnt");
		button("Neues Spiel");
		button("Menü");
	}
	
	@Override
	protected void result(Object object){
		
	}

}
