package com.VierGewinnt;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.VierGewinnt.VierGewinnt;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = VierGewinnt.TITLE + " v" + VierGewinnt.VERSION;
		cfg.vSyncEnabled = true;
		cfg.useGL20 = true;
		cfg.width = 600;
		cfg.height = 800;
		
		new LwjglApplication(new VierGewinnt(), cfg);
	}
}
