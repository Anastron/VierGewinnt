package com.VierGewinnt.models;

import com.badlogic.gdx.graphics.Color;

public class GameStone {

	public final int Player;
	
	public GameStone(int pl) {
		this.Player = pl;
	}

	public Color getColor() {
		switch (Player) {
		case 0:
			return Color.BLUE;
		case 1:
			return Color.RED;
		default:
			return Color.BLACK;
		}
	}
}
