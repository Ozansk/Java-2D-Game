package dev.codenmore.game.states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;

import dev.codenmore.game.Game;
import dev.codenmore.game.gfx.ImageLoader;

public class OverState extends State{

	int x=0;
	private BufferedImage GameOver;
	public OverState(Game game) {
		super(game);
		GameOver = ImageLoader.loadImage("/textures/GameOVER.png");
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, game.width, game.height);
		g.drawImage(GameOver, 650, 300,600,400, null);
		g.setColor(Color.RED);
		String str = "ABDUR";
		g.drawString(str, 0, 0);
		if(x==2) {
			JOptionPane.showMessageDialog(null, "score" + Game.SCORE,"score",JOptionPane.OK_CANCEL_OPTION);
		}
		x++;
	}

}
