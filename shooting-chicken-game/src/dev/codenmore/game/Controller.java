package dev.codenmore.game;

import java.awt.Graphics;
import java.util.LinkedList;

import dev.codenmore.game.Creatures.Egg;
import dev.codenmore.game.Creatures.Target;

public class Controller {

	private LinkedList<Egg> e = new LinkedList<Egg>();
	private LinkedList<Target> t = new LinkedList<Target>();
	Game game;
	
	Egg TempEgg;
	Target TempTarget;
	public Controller(Game game) {
		this.game = game;

	}
	public void update() {
		for(int i=0;i < t.size();i++) {
			TempTarget = t.get(i);
			TempTarget.update();
		}
		for(int i=0;i < e.size();i++) {
			TempEgg = e.get(i);
			TempEgg.update();
		}

	}
	public void render(Graphics g) {
		for(int i=0;i < t.size();i++) {
			TempTarget = t.get(i);
			TempTarget.render(g);
		}
		for(int i=0;i < e.size();i++) {
			TempEgg = e.get(i);
			TempEgg.render(g);
		}
	}
	public void addEgg(Egg egg) {
		e.add(egg);
	}
	public void removeEgg(Egg egg) {
		e.remove(egg);
	}
	public void addTarget(Target target) {
		t.add(target);
	}
	public void removeTarget(Target target) {
		t.remove(target);
	}
	public LinkedList<Egg> getE() {
		return e;
	}
	public LinkedList<Target> getT() {
		return t;
	}

}
