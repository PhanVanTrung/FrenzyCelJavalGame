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

		if(hud.getLevel() < 11 && scoreKeep >= 50){
			scoreKeep = 0;
			hud.setLevel(hud.getLevel()+1);
			if (hud.getLevel()!=3 && hud.getLevel()!=4 || hud.getLevel()!=7){
				handler.addObject(new BasicEnemy(rand.nextInt(Game.WIDTH - 50), rand.nextInt(Game.HEIGHT - 50), ID.Enemy, handler));
			}
			if (hud.getLevel()==3){
				handler.addObject(new FastEnemy(rand.nextInt(Game.WIDTH-50), rand.nextInt(Game.HEIGHT-50), ID.Enemy, handler));
			}
			if (hud.getLevel()==4 || hud.getLevel()==5){
				handler.addObject(new AdvancedEnemy(rand.nextInt(Game.WIDTH-50), rand.nextInt(Game.HEIGHT-50), ID.FatalEnemy, handler));
			}
			if (hud.getLevel()==7){
				handler.addObject(new FastEnemy(rand.nextInt(Game.WIDTH-50), rand.nextInt(Game.HEIGHT-50), ID.Enemy, handler));
			}
			if (hud.getLevel() == 11){
				handler.clearEnemies();
				FatalWall fw = new FatalWall(0, 22, ID.FatalEnemy, handler);
				BossEnemy boss = new BossEnemy(Game.WIDTH/2 -32, -120, ID.FatalEnemy, handler);
				handler.addObject(fw);
				handler.addObject(boss);
			}
		}
	}
}
