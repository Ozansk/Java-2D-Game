package dev.codenmore.game.Creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.codenmore.game.Game;
import dev.codenmore.game.gfx.ImageLoader;

public class Cat extends Creature{

	private BufferedImage cat;
	public Cat(float x, float y, Game game) {
		super(x, y, game);
		cat = ImageLoader.loadImage("/textures/cat.png");
	}

	@Override
	public void update() {
		y-=4;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(cat, (int)x, (int)y,width,height, null);
	}

}
