package com.pvt.main;

import java.util.Random;

public class Spawn {
	private Handler handler;
	private HUD hud;
	private int scoreKeep, healKeep = 0;
	private Random rand;
	private Game game;
	int count = 0;
	public Spawn(Handler handler, HUD hud, Game game) {
		this.handler = handler;
		this.hud = hud;
		this.game = game;
		rand = new Random();
	}

	public void tick(){
		healKeep += 1;
		scoreKeep +=1;
		if(healKeep>=50 && hud.HEALTH<100) {
			healKeep = 0;
			hud.HEALTH += 1;
		}
		if(hud.getLevel() < 20 && scoreKeep >= 200){
			scoreKeep = 0;
			hud.setLevel(hud.getLevel()+1);
			
			handler.addObject(new BasicEnemy(rand.nextInt(Game.WIDTH - 50), rand.nextInt(Game.HEIGHT - 50), ID.Enemy, handler));

			System.out.println(ObjectFactory.myHashMap.size());
			
//			BasicEnemy BasicE = (BasicEnemy) ObjectFactory.getObject("BasicE", handler);
//			
//			BasicE.setX(rand.nextInt(Game.WIDTH - 50));
//			BasicE.setY(rand.nextInt(Game.HEIGHT - 50));

						
//			for(int i = 0; i<handler.objects.size(); i++) {
//				if(handler.objects.get(i) != null /*&& handler.objects.get(i).getId() == ID.Enemy*/) {
//					count++;
//					System.out.println(count + "#### Number of Basic Enemy: "+ ObjectFactory.myHashMap.size());
//				}
//			}

//			handler.addObject(BasicE);
			
			if (game.diff == 1){
				if (hud.getLevel()% 2 == 0){
					handler.addObject(new HardEnemy(rand.nextInt(Game.WIDTH - 50), rand.nextInt(Game.HEIGHT - 50), ID.HardEnemy, handler));
				}
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
			if (hud.getLevel() == 12){
				handler.clearEnemies();
				FatalWall fw = new FatalWall(0, 22, ID.FatalEnemy, handler);
				BossEnemy boss = new BossEnemy(Game.WIDTH/2 -32, -120, ID.FatalEnemy, handler);
				handler.addObject(fw);
				handler.addObject(boss);
			}
			
		} 
	}
}
