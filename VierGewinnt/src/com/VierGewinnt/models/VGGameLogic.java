package com.VierGewinnt.models;

public class VGGameLogic {
	public final int width;
	public final int height;

	private GameStone[][] field;

	private int activePlayer = GameStone.PLAYER_0;

	public VGGameLogic(int w, int h) {
		width = w;
		height = h;

		field = new GameStone[w][h];

		init();
	}

	public void setPlayer(int p) {
		activePlayer = p;
	}

	public int getActivePlayer() {
		return activePlayer;
	}

	public int switchPlayer() {
		activePlayer = (-(activePlayer * 2 - 1) + 1) / 2; // Math Magic :D

		return getActivePlayer();
	}

	public GameStone get(int x, int y) {
		return field[x][y];
	}

	public boolean empty(int x, int y) {
		return field[x][y] == null;
	}

	private void init() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				field[x][y] = null;
			}
		}
	}

	private void set(int x, int y, GameStone s) {
		field[x][y] = s;
	}

	public boolean dropStone(int col, GameStone s) {
		if (!canDropStone(col))
			return false;

		for (int y = height - 2; y >= -1; y--) {
			if (y == -1 || !empty(col, y)) {
				set(col, y + 1, s);
				return true;
			}
		}

		return false;
	}

	public boolean canDropStone(int col) {
		return empty(col, height - 1);
	}
}
