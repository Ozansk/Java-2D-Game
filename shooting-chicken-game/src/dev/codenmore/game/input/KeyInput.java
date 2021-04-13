package dev.codenmore.game.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import dev.codenmore.game.Game;

public class KeyInput extends KeyAdapter{
	
	Game game;
	
	public KeyInput(Game game) {
		this.game = game;
	}
	
	public void keyPressed(KeyEvent e) {
		game.keyPressed(e);
	}
	public void keyReleased(KeyEvent e) {
		game.keyReleased(e);
	}
}
