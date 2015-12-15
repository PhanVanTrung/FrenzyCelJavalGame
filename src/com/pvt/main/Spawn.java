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

		if(scoreKeep >= 50){
			scoreKeep = 0;
			hud.setLevel(hud.getLevel()+1);
			handler.addObject(new BasicEnemy(rand.nextInt((Game.WIDTH) - 50), rand.nextInt(Game.HEIGHT) - 50, ID.Enemy, handler));
			// add fast enemy every four level-up
			if (hud.getLevel()%4==0){
				handler.addObject(new FastEnemy(rand.nextInt(Game.WIDTH)-50, rand.nextInt(Game.HEIGHT)-50, ID.Enemy, handler));
			}
			// add advanced enemy at every seven-level
			if (hud.getLevel()%3==0)
				handler.addObject(new AdvancedEnemy(rand.nextInt(Game.WIDTH)-50, rand.nextInt(Game.HEIGHT)-50, ID.FatalEnemy, handler));
			// remove the fatal enemy after the level
//			if (hud.getLevel()%5!=0){
//				for (int i = 0; i<handler.objects.size(); i++){
//					GameObject tempObj = handler.objects.get(i);
//					if (tempObj.getId()==ID.FatalEnemy)
//						handler.removeObject(tempObj);
//				}
//			}
		}
	}
}
