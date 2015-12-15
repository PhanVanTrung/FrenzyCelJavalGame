package com.pvt.main;

import java.util.Random;

public class Spawn {
	private Handler handler;
	private HUD hud;
	private int scoreKeep = 0;
	private Random rand;

	public Spawn(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
		rand = new Random();
	}

	public void tick(){
		scoreKeep ++;

		if(scoreKeep >= 200){
			scoreKeep = 0;
			hud.setLevel(hud.getLevel()+1);
			handler.addObject(new BasicEnemy(rand.nextInt(Game.WIDTH) - 50, rand.nextInt(Game.HEIGHT) - 50, ID.Enemy, handler));
			// add fast enemy every four level-up
//			if (hud.getLevel()%4==0){
//				handler.addObject(new FastEnemy(rand.nextInt(Game.WIDTH)-50, rand.nextInt(Game.HEIGHT)-50, ID.Enemy, handler));
//			}
		}
	}
}
