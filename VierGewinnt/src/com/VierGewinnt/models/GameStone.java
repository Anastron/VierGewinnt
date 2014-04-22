package com.VierGewinnt.models;

import com.badlogic.gdx.graphics.Color;

public class GameStone {
	public final static int PLAYER_0 = 0x00;
	public final static int PLAYER_1 = 0x01;
	
	public final int Player;
	
	public GameStone(int pl) {
		this.Player = pl;
	}

	public Color getColor() {
		switch (Player) {
		case PLAYER_0:
			return Color.BLUE;
		case PLAYER_1:
			return Color.YELLOW;
		default:
			return Color.BLACK;
		}
	}
}
