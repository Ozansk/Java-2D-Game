package dev.codenmore.game.states;

import java.awt.Color;
import java.awt.Graphics;

import dev.codenmore.game.Controller;
import dev.codenmore.game.Game;
import dev.codenmore.game.Creatures.Cat;
import dev.codenmore.game.Creatures.Player;
import dev.codenmore.game.Creatures.Target;

public class Level2 extends State{

	int world_y=0;
	int level_Timer=0;
	private Player player;
	private Controller controller;
	private Cat[] cats;
	public Level2(Game game) {
		super(game);
		player = game.setPlayer(new Player(940,100,game));
		controller = game.setController(new Controller(game));
		
		controller.addTarget(new Target(1800,650,game));
		controller.addTarget(new Target(1800,850,game));
		controller.addTarget(new Target(0,1050,game));
		controller.addTarget(new Target(1800,1250,game));
		controller.addTarget(new Target(0,1450,game));
		controller.addTarget(new Target(0,350,game));
		
		cats = game.getCat();
		cats = new Cat[32];
		
		for(int i=0,num=0;i< 2;i++) {
			cats[i] = new Cat(num*32+900,800,game);
			num++;		
		}
		for(int i=2,num=0;i< 6;i++) {
			cats[i] = new Cat(num*32+600,800,game);
			num++;		
		}
		for(int i=6,num=0;i< 8;i++) {
			cats[i] = new Cat(num*32+1200,800,game);
			num++;		
		}
		for(int i=8,num=0;i< 10;i++) {
			cats[i] = new Cat(num*32+900,1200,game);
			num++;		
		}
		for(int i=10,num=0;i< 14;i++) {
			cats[i] = new Cat(num*32+1150,1200,game);
			num++;		
		}
		for(int i=14,num=0;i< 16;i++) {
			cats[i] = new Cat(num*32+700,1200,game);
			num++;		
		}
		for(int i=16,num=0;i< 24;i++) {
			cats[i] = new Cat(num*32+900,1500,game);
			num++;		
		}
		for(int i=24,num=0;i< 32;i++) {
			cats[i] = new Cat(num*32+600,1700,game);
			num++;		
		}
		game.setCat(cats);
	}

	@Override
	public void update() {
		
		if(cat_Collision()) {
			game.setOverState(new OverState(game));
			State.setState(game.getOverState());
		}
		if(level_Timer>=450) {
			Game.SCORE+=50;
			game.setLevel3(new Level3(game));
			State.setState(game.getLevel3());
			
		}else System.out.println(level_Timer);
		
		level_Timer++;
		player.update();
		controller.update();
		update_Cats();
	}

	@Override
	public void render(Graphics g) {

		render_Map(g);
		player.render(g);
		controller.render(g);
		render_Cats(g);
	}

	private void render_Map(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, world_y, game.width, game.height*10);
		g.setColor(Color.blue);
		g.fillRect(600, 0, 10, 3000);
		g.fillRect(1280, 0, 10, 3000);
		world_y-=2;	
	}
	private void update_Cats() {
		for(int i=0;i < cats.length;i++)
			cats[i].update();
	}
	private void render_Cats(Graphics g) {
		for(int i=0;i < cats.length;i++)
			cats[i].render(g);
	}
	private boolean cat_Collision() {
		for(int i=0;i < cats.length;i++) {
			if(player.getX() >= cats[i].getX() && player.getX() <= cats[i].getX()+62||
			   player.getX() <= cats[i].getX() && player.getX()+62 >= cats[i].getX()) {
				if(player.getY() >= cats[i].getY() && player.getY() <= cats[i].getY()+62||
						   player.getY() <= cats[i].getY() && player.getY()+62 >= cats[i].getY())
					return true;
			}
		}
			
		return false;
	}
}
