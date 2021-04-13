package dev.codenmore.game.Creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.codenmore.game.Game;
import dev.codenmore.game.gfx.ImageLoader;

public class Egg extends Creature{

	private BufferedImage egg;
	float speed;
	public Egg(float x, float y,float speed, Game game) {
		super(x, y, game);
		this.speed = speed;
		egg = ImageLoader.loadImage("/textures/egg.png");
	}

	@Override
	public void update() {
		
		x += speed;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(egg, (int)x, (int)y,width,height, null);
		
	}
}
