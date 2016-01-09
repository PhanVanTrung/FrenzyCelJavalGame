package com.pvt.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class HardEnemy extends GameObject{
	
	private Handler handler;
	private Random r = new Random();

	public HardEnemy(ID id, Handler handler) {
		super(id);
		// velocity to X, velocity to Y
		velX = 5;
		velY = 5;
		this.handler = handler;
	}
	
	public HardEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		// velocity to X, velocity to Y
		velX = 5;
		velY = 5;
		this.handler = handler;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x += velX;
		y += velY;
		// Change the direction if enemy object hits the wall
		if (y<=14 || y >= Game.HEIGHT - 50) {
			if(velY<0) velY = -(r.nextInt(7)+1)*-1;
			else velY = (r.nextInt(7)+1)*-1;
		}
		if (x<=14 || x >= Game.WIDTH - 24) {
			if(velX<0) velX = -(r.nextInt(7)+1)*-1;
			else velX = (r.nextInt(7)+1)*-1;
		}
		// add the tails to handler with the position of the enemy (copy enemy position to trail)
//		handler.addObject(new Trail(x, y, ID.Trail, Color.green, 14, 14, 0.05f, handler));
		Trail Trail =(Trail) (ObjectFactory.getTrail(Color.green, handler));
		Trail.setX(getX());
		Trail.setY(getY());
		handler.addObject(Trail);
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
