package dev.codenmore.game;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import dev.codenmore.game.Creatures.Cat;
import dev.codenmore.game.Creatures.Egg;
import dev.codenmore.game.Creatures.Player;
import dev.codenmore.game.Creatures.Target;
import dev.codenmore.game.input.KeyInput;
import dev.codenmore.game.states.Level1;
import dev.codenmore.game.states.State;


public class Game extends Canvas implements Runnable{

	public static int SCORE = 0;
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 1911;
	public static final int HEIGHT =1080;
	public static final int SCALE = 2;
	public final String TITLE = "Flying Chicken";
	
	//Characters
	private Player player;
	private Cat[] cats;
	private Controller controller;
	private Target[] targets;
	//States
	private State level1;
	private State level2;
	private State level3;
	private State overState;
	

	public int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private Graphics g;
	private BufferStrategy bs;
	

	
	public static void main(String[] args) {
		Game game = new Game("Title!", 1911, 1080);
		
		game.setPreferredSize(new Dimension(WIDTH * SCALE,HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		
		JFrame frame = new JFrame(game.TITLE);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	
		game.start();
	}
public Game(String title, int width, int height) {
		
	setFocusable(true);
	requestFocusInWindow();
		this.width = width;
		this.height = height;
		this.title = title;
	}
private void init() {
	
	addKeyListener(new KeyInput(this));

	
	level1 = new Level1(this);
	State.setState(level1);
}



private void update() {
	if(State.getState() != null) {
		State.getState().update();
	}
	
}
private void render() {
	bs = getBufferStrategy();
	if(bs == null) {
		createBufferStrategy(3);
		return;
	}
	g = bs.getDrawGraphics();
	g.clearRect(0, 0, width, height);
	//Draw Here
	if(State.getState() != null) {
		State.getState().render(g);
	}
	//Draw End
	bs.show();
	g.dispose();
}

	@Override
	public void run() {
		init();
		
		int fps = 60;
		double timePerUpdate = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		
		
		while(running) {
			now = System.nanoTime();
			
			delta += (now - lastTime) / timePerUpdate;
			lastTime = now;
			if(delta >= 1) {
			update();
			render();
			delta=0;
			}
		}
		stop();
	}
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_D && player.getX()<1210)
			player.setVelX(10);
		else if(key == KeyEvent.VK_A && player.getX()>620)
			player.setVelX(-10);
		else if(key == KeyEvent.VK_J)
			controller.addEgg(new Egg(player.getX(),player.getY(),-10,this));	
		else if(key == KeyEvent.VK_K)
			controller.addEgg(new Egg(player.getX(),player.getY(),10,this));
	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_D)
			player.setVelX(0);
		else if(key == KeyEvent.VK_A)
			player.setVelX(0);
	}
	
	
	//Getters and Setters
	
	public State getLevel3() {
		return level3;
	}
	public void setLevel3(State level3) {
		this.level3 = level3;
	}
	public State getLevel2() {
		return level2;
	}
	public void setLevel2(State level2) {
		this.level2 = level2;
	}
	public State getLevel1() {
		return level1;
	}
	public void setLevel1(State level1) {
		this.level1 = level1;
	}
	public void setOverState(State overState) {
		this.overState = overState;
	}
	public Player getPlayer() {
		return player;
	}
	public Player setPlayer(Player player) {
		return this.player = player;
	}
	public Cat[] getCat() {
		return cats;
	}
	public void setCat(Cat[] cats) {
		 this.cats = cats;
	}
	public Controller getController() {
		return controller;
	}
	public Controller setController(Controller controller) {
		return this.controller = controller;
	}
	public Target[] getTargets() {
		return targets;
	}
	public State getOverState() {
		return overState;
	}
}
