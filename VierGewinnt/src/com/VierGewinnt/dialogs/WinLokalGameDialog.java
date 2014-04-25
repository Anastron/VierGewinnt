package com.VierGewinnt.dialogs;

import com.badlogic.gdx.scenes.scene2d.ui.Dialog;

public class WinLokalGameDialog extends Dialog{

	public WinLokalGameDialog(String title, WindowStyle windowStyle) {
		super(title, windowStyle);
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
