package dev.codenmore.game.Creatures;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.codenmore.game.Game;

public abstract class Creature {
	
	protected float x,y;
	protected Game game;
	
	protected int width,height;
	
	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}
	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public Creature(float x,float y,Game game) {
		this.x = x;
		this.y = y;
		this.game = game;
		this.width = DEFAULT_WIDTH;
		this.height = DEFAULT_HEIGHT;
	}
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,width,height);
	}
	
	
	public abstract void update();
	public abstract void render(Graphics g);
	
	public static final int DEFAULT_WIDTH = 64,DEFAULT_HEIGHT = 64;
	
}
