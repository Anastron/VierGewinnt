package com.VierGewinnt.Modelle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class TexturesManager {
	
	public static void loadTextures(){
		TextureAtlas atlas = new TextureAtlas(
				Gdx.files.internal("img/textures/textures.pack"));
	}

}
