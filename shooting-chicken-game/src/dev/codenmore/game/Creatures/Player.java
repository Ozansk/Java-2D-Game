package dev.codenmore.game.Creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.codenmore.game.Game;
import dev.codenmore.game.gfx.ImageLoader;

public class Player extends Creature{

	private BufferedImage player;
	private float velX=0,velY=0;
	
	public Player(float x, float y, Game game) {
		super(x, y, game);
		player = ImageLoader.loadImage("/textures/chicken.png");
	}

	@Override
	public void update() {
		x+=velX;
		y+=velY;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(player, (int)x, (int)y,width,height, null);
	}

	public float getVelX() {
		return velX;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelY(float velY) {
		this.velY = velY;
	}

}
