//package com.pvt.main;
//
//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.Rectangle;
//
//public class FastEnemy extends GameObject{
//	
//	private Handler handler;
//
//	public FastEnemy(int x, int y, ID id, Handler handler) {
//		super(x, y, id);
//		// velocity to X, velocity to Y
//		velX = 3;
//		velY = 9;
//		this.handler = handler;
//	}
//
//	@Override
//	public void tick() {
//		// TODO Auto-generated method stub
//		x += velX;
//		y += velY;
//		// Change the direction if enemy object hits the wall
//		if (y<=0 || y >= Game.HEIGHT - 28) velY *= -1;
//		if (x<=0 || x >= Game.WIDTH - 14) velX *= -1;
//		// add the tails to handler with the position of the enemy (copy enemy position to trail)
//		handler.addObject(new Trail(x, y, ID.Trail, Color.cyan, 14, 14, 0.05f, handler));
//	}
//
//	@Override
//	public void render(Graphics g) {
//		g.setColor(Color.cyan);
//		g.fillRect(x, y, 14, 14);
//
//		// Boundary
////		Graphics2D g2d = (Graphics2D) g;
////		g2d.setColor(Color.white);
////		g2d.draw(getBounds());
//	}
//
//	@Override
//	public Rectangle getBounds() {
//		// TODO Auto-generated method stub
//		return new Rectangle(x, y, 14, 14);
//	}
//
//}
