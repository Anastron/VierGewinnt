package com.VierGewinnt.dialogs;

import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class OfflineDialog extends Dialog {



	public static boolean isOnline;

	public OfflineDialog(String title, Skin skin) {
		super(title, skin);
		text("Du bist Offline");
		text("Bitte Loge dich ein um Online zu spielne");
		button("Verbinden", "Verbinden");
		button("Zurück", "Zurück");
	}
	@Override
	protected void result(Object object) {
		if (object.toString() == "Verbinden") {
		
		} else if (object.toString() == "Zurück") {
		
		}
	}

}
