package com.pvt.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BossEnemy extends GameObject{

	private Handler handler;
	private int timer1 = 55;
	private Random rand = new Random();
	Player player;

	public BossEnemy(ID id, Handler handler) {
		super(id);
		// velocity to X, velocity to Y
		velX = 0;
		velY = 2;
		this.handler = handler;
	}
	
	public BossEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		// velocity to X, velocity to Y
		velX = 0;
		velY = 2;
		this.handler = handler;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x += velX;
		y += velY;
		// Change the direction if enemy object hits the wall
//		if (y<=0 || y >= Game.HEIGHT - 64) velY *= -1;
		if (x<=0 || x >= Game.WIDTH - 64) velX *= -1;

		if(timer1<=0) {
			velY = 0;
			if(velX==0) velX=6;
			int spawn = rand.nextInt(2);
			if(spawn==1){
				// get player position
				//				for (int i =0; i < handler.objects.size(); i++){
				//					if (handler.objects.get(i).getId() == ID.Player) player = (Player) handler.objects.get(i);
				//				}
				//				playerPosX = player.getX();
				//				playerPosY = player.getY();
				//assign value to velX, velY to make enemy point to player
				//				int[] r = {(playerPosX-x)/50,(playerPosY-y)/50};

				if(velX>=0) handler.addObject(new BossBullet(x+32, y+54, ID.Enemy, handler));
				else handler.addObject(new BossBullet(x+14, y+54, ID.Enemy, handler));
			}
		}
		else timer1--;
	}
	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 64, 64);

		//		g.drawString(String.valueOf(playerPosX) + "/t: "+String.valueOf(playerPosY) , Game.WIDTH/2, Game.HEIGHT/2);

		// Boundary
		//		Graphics2D g2d = (Graphics2D) g;
		//		g2d.setColor(Color.white);
		//		g2d.draw(getBounds());
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x, y, 64, 64);
	}

}
