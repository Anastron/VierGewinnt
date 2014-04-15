package com.VierGewinnt;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.VierGewinnt.VierGewinnt;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "VierGewinnt";
		cfg.width = 480;
		cfg.height = 320;
		
		new LwjglApplication(new VierGewinnt(), cfg);
	}
}
