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


	public int testForWin()
	{
		for(int x = 0; x < 7; x++)
		{
			for(int y = 0; y < 6; y++)
			{
				
				// Überprüfen ob Spieler 1 gewonnen hat
				if((getCatchedPosition(x,y) == GameStone.PLAYER_0) && (getCatchedPosition(x + 1, y) == GameStone.PLAYER_0) && (getCatchedPosition(x + 2, y) == GameStone.PLAYER_0) && (getCatchedPosition(x + 3, y) == GameStone.PLAYER_0))
				{
					return GameStone.PLAYER_0;
				}	
				if((getCatchedPosition(x, y) == GameStone.PLAYER_0) && (getCatchedPosition(x, y + 1) == GameStone.PLAYER_0) && (getCatchedPosition(x, y + 2) == GameStone.PLAYER_0) && (getCatchedPosition(x, y + 3) == GameStone.PLAYER_0))
				{
					return GameStone.PLAYER_0;
				}
				if((getCatchedPosition(x, y) == GameStone.PLAYER_0) && (getCatchedPosition(x + 1, y + 1) == GameStone.PLAYER_0) && (getCatchedPosition(x + 2, y + 2) == GameStone.PLAYER_0) && (getCatchedPosition(x + 3, y + 3) == GameStone.PLAYER_0))
				{
					return GameStone.PLAYER_0;
				}
				if((getCatchedPosition(x, y) == GameStone.PLAYER_0) && (getCatchedPosition(x - 1, y + 1) == GameStone.PLAYER_0) && (getCatchedPosition(x - 2, y + 2) == GameStone.PLAYER_0) && (getCatchedPosition(x - 3, y + 3) == GameStone.PLAYER_0))
				{
					return GameStone.PLAYER_0;
				}
				
				// Überprüfen ob Spieler 2 gewonnen hat
				if((getCatchedPosition(x, y) == GameStone.PLAYER_1) && (getCatchedPosition(x + 1, y) == GameStone.PLAYER_1) && (getCatchedPosition(x + 2, y) == GameStone.PLAYER_1) && (getCatchedPosition(x + 3, y) == GameStone.PLAYER_1))
				{
					return GameStone.PLAYER_1;
				}	
				if((getCatchedPosition(x, y) == GameStone.PLAYER_1) && (getCatchedPosition(x, y + 1) == GameStone.PLAYER_1) && (getCatchedPosition(x, y + 2) == GameStone.PLAYER_1) && (getCatchedPosition(x, y + 3) == GameStone.PLAYER_1))
				{
					return GameStone.PLAYER_1;
				}
				if((getCatchedPosition(x, y) == GameStone.PLAYER_1) && (getCatchedPosition(x + 1, y + 1) == GameStone.PLAYER_1) && (getCatchedPosition(x + 2, y + 2) == GameStone.PLAYER_1) && (getCatchedPosition(x + 3, y + 3) == GameStone.PLAYER_1))
				{
					return GameStone.PLAYER_1;
				}
				if((getCatchedPosition(x, y) == GameStone.PLAYER_1) && (getCatchedPosition(x - 1, y + 1) == GameStone.PLAYER_1) && (getCatchedPosition(x - 2, y + 2) == GameStone.PLAYER_1) && (getCatchedPosition(x - 3, y + 3) == GameStone.PLAYER_1))
				{
					return GameStone.PLAYER_1;
				}

			}
		}
		// Falls niemand gewonnen hat wird -1 zurück gegeben
		return -1;
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
	
	private int getCatchedPosition(int x, int y)
	{
		// geschaut ob das Feld vorhanden ist oder nicht
		
		if(x < 0 || y < 0 || x > 6 || y > 5)
			return -1;
		else 
			if(get(x, y) != null)
			return get(x, y).Player;
		
		return -1;
	}
}
