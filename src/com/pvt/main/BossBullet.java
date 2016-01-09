package com.pvt.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BossBullet extends GameObject{
	
	private Handler handler;
	private Random rand = new Random();
	Player player;

	public BossBullet(ID id, Handler handler) {
		super(id);
		this.handler = handler;
		// velocity to X, velocity to Y
		// random from -5 to 5;
		velX = (rand.nextInt(10) + -5);
		velY = 5;
	}
	
	public BossBullet(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		// velocity to X, velocity to Y
		// random from -5 to 5;
		velX = (rand.nextInt(10) + -5);
		velY = 5;
//		this.velX = velX;
//		this.velY = velY;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x += velX;
		y += velY;

		// Change the direction if enemy object hits the wall
		if (y<=0 || y >= Game.HEIGHT - 28) handler.removeObject(this);
		if (x<=0 || x >= Game.WIDTH - 14) handler.removeObject(this);
//		if(y >= Game.HEIGHT) handler.removeObject(this);
		// add the tails to handler with the position of the enemy (copy enemy position to trail)
		handler.addObject(new Trail(x, y, ID.Trail, Color.green, 14, 14, 0.05f, handler));
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, y, 14, 14);

		// Boundary
//		Graphics2D g2d = (Graphics2D) g;
//		g2d.setColor(Color.white);
//		g2d.draw(getBounds());
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x, y, 14, 14);
	}

}
