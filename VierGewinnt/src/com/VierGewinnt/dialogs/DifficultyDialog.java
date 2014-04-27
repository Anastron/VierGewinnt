package com.VierGewinnt.dialogs;

import com.VierGewinnt.screens.LocalGameScreen;
import com.VierGewinnt.screens.MainMenu;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class DifficultyDialog extends Dialog{

	public DifficultyDialog(String title, Skin skin) {
		super(title, skin);
	}
	{
		button("Leicht", "Leicht");
		button("Mittel", "Mittel");
		button("Schwer", "Schwer");
		button("Mike", "Mike");  // :) you cant win :)
	}

	@Override
	protected void result(Object object){
	
		if(object.toString() == "Leicht"){
			// write in Settings ;)
		}
		else if(object.toString() == "Mittel")
		{
			// write in Settings ;)
		}
		else if(object.toString() == "Schwer")
		{
			// write in Settings ;)
		}
		else if(object.toString() == "Mike")
		{
			// write in Settings ;)
		}
		
		
	}
}
