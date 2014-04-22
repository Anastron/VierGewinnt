package com.VierGewinnt.unifiedInputProcessor;

import com.badlogic.gdx.InputProcessor;

public class UnifiedInputProcessor implements InputProcessor {

	private final UnifiedInputHandler target;
	
	public UnifiedInputProcessor(UnifiedInputHandler t) {
		this.target = t;
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return target.inputDown(screenX, screenY);
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return target.inputUp(screenX, screenY);
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return target.inputMove(screenX, screenY);
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return target.inputMove(screenX, screenY);
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

}
