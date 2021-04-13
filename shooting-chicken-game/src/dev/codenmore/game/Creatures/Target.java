package dev.codenmore.game.Creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import dev.codenmore.game.Game;
import dev.codenmore.game.gfx.ImageLoader;

public class Target extends Creature{

	private BufferedImage target;
	public Target(float x, float y, Game game) {
		super(x, y, game);
		target = ImageLoader.loadImage("/textures/dart.png");
	}

	@Override
	public void update() {
		y-=4;
		if(Collision(game.getController().getE())) {
			game.getController().removeTarget(this);
			Game.SCORE+=5;
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(target, (int)x, (int)y,width*2,height*2, null);
		
	}
	public boolean Collision(LinkedList<Egg> Egg) {
		for(int i=0;i< Egg.size();i++) {
			if(getBounds().intersects(Egg.get(i).getBounds()))
				return true;
		}
		return false;
	}

}
