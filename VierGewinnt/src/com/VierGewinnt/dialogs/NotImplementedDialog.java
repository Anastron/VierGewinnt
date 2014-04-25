package com.VierGewinnt.dialogs;

import com.badlogic.gdx.scenes.scene2d.ui.Dialog;

public class NotImplementedDialog extends Dialog{

	public NotImplementedDialog(String title, WindowStyle windowStyle) {
		super(title, windowStyle);
	}
	{
		text("Leider noch nicht verfügbar :( :( :(");
		button("ok");
	}

	@Override
	protected void result(Object object){
		
	}
}
