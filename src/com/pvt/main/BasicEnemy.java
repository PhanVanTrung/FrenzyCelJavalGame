package com.pvt.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject{

	private Handler handler;

	public BasicEnemy(ID id, Handler handler) {
		super(id);
		// velocity to X, velocity to Y
		this.setVelX(5);
		this.setVelY(5);
		this.handler = handler;
	}

	public BasicEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		// velocity to X, velocity to Y
		velX = 5;
		velY = 5;
		this.handler = handler;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		//		int x = this.getX();
		//		int y = this.getY();
		setX(this.getX()+this.getVelX());
		setY(this.getY()+this.getVelY());
		// Change the direction if enemy object hits the wall
		if (this.getY()<=0 || this.getY() >= Game.HEIGHT - 28) this.setVelY(this.getVelY()*-1);
		if (this.getX()<=0 || this.getX() >= Game.WIDTH - 14) this.setVelX(this.getVelX()*-1);
		// add the tails to handler with the position of the enemy (copy enemy position to trail)
//		handler.addObject(new Trail(x, y, ID.Trail, Color.red, 14, 14, 0.05f, handler));

		Trail Trail =(Trail) (ObjectFactory.getTrail(Color.red, handler));
		Trail.setX(getX());
		Trail.setY(getY());
		handler.addObject(Trail);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(this.getX(), this.getY(), 14, 14);

		// Boundary
		//		Graphics2D g2d = (Graphics2D) g;
		//		g2d.setColor(Color.white);
		//		g2d.draw(getBounds());
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(this.getX(), this.getY(), 14, 14);
	}

}
