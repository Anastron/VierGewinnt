package com.VierGewinnt.models;

import com.VierGewinnt.unifiedInputProcessor.UnifiedInputHandler;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;

public class VGGame implements UnifiedInputHandler {
	private final int width;
	private final int height;

	private GameStone[][] field;

	private int selectedColumn = -1;
	private ShapeRenderer srenderer;
	private Rectangle fieldRectangle;

	public VGGame(int w, int h) {
		width = w;
		height = h;

		field = new GameStone[w][h];

		init();
		
		srenderer = new ShapeRenderer();
	}

	private void init() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				field[x][y] = null;
			}
		}
	}
	
	public void dispose() {
		//
	}

	public Rectangle calcViewRect(float resolutionX, float resolutionY) {
		float ratio_real = (1f * resolutionX) / resolutionY;
		float ratio_game = (1f * width) / height;

		float offx;
		float offy;

		float resw;
		float resh;

		if (ratio_real > ratio_game) {
			// fit to Y

			offy = 0;
			resh = resolutionY;

			resw = resh * ratio_game;
			offx = (resolutionX - resw) / 2;
		} else {
			// fit to X

			offx = 0;
			resw = resolutionX;

			resh = resw / ratio_game;
			offy = (resolutionY - resh) / 2;
		}

		return new Rectangle(offx, offy, resw, resh);
	}

	public void resize(int w, int h) {
		fieldRectangle = calcViewRect(w, h);
	}

	private float getStoneRadius() {
		return fieldRectangle.width / (width * 2);
	}
	
	private Circle getStoneCircle(int x, int y) {
		float rad = getStoneRadius();
		return new Circle(fieldRectangle.x + rad + 2 * rad * x, fieldRectangle.y + rad + 2 * rad * y, rad);
	}
	
	public void render(Camera cam) {
		srenderer.setProjectionMatrix(cam.combined);

		// Render Background
		
		srenderer.begin(ShapeType.Filled);
		{
			srenderer.setColor(Color.WHITE);
			srenderer.rect(fieldRectangle.x, fieldRectangle.y, fieldRectangle.width, fieldRectangle.height);
		}
		srenderer.end();

		// Render Column

		srenderer.begin(ShapeType.Filled);
		{
			srenderer.setColor(Color.RED);
			for (int x = 0; x < width; x++) {
				if (x == selectedColumn) {
					Circle c = getStoneCircle(x, 0);

					srenderer.rect(c.x - c.radius, 0, 2 * c.radius, fieldRectangle.height);
				}
			}
		}
		srenderer.end();
		
		// Render Stones
		
		srenderer.begin(ShapeType.Filled);
		{
			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					Circle c = getStoneCircle(x, y);
					
					if (field[x][y] != null) {
						srenderer.setColor(field[x][y].getColor());
					} else {
						srenderer.setColor(Color.WHITE);
					}
					
					srenderer.circle(c.x, c.y, c.radius);
				}
			}
		}
		srenderer.end();
		
		// Render Stone Borders
		
		srenderer.begin(ShapeType.Line);
		{
			srenderer.setColor(Color.BLACK);

			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					Circle c = getStoneCircle(x, y);
					if (field[x][y] == null) {
						srenderer.circle(c.x, c.y, c.radius);
					}
				}
			}
		}
		srenderer.end();
	}

	@Override
	public boolean inputUp(int x, int y) {
		return false;
	}

	@Override
	public boolean inputDown(int x, int y) {
		return false;
	}

	@Override
	public boolean inputMove(int x, int y) {
		if (fieldRectangle.contains(x, y)) {
			for (int tx = 0; tx < width; tx++) {
				Circle c = getStoneCircle(tx, 0);
				if (Math.abs(x - c.x) < c.radius) {
					selectedColumn = tx;
					return true;
				}
			}
		}
		
		selectedColumn = -1;
		return false;
		
	}
}
