package com.VierGewinnt.dialogs;

import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class NotImplementedDialog extends Dialog{

	public NotImplementedDialog(String title, Skin skin) {
		super(title, skin);
	}
	{
		text("Leider noch nicht verf�gbar :( :( :(");
		button("ok");
	}

	@Override
	protected void result(Object object){
		
	}
}
