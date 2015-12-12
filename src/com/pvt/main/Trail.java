package com.pvt.main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject{
	// render tails of the object enemy
	private float alpha = 1;
	Handler handler;
	Color color;
	private int width, height;
	private float life;
	// life = 0.001 - 0.1

	public Trail(int x, int y, ID id, Color color, int width, int height, float life, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		this.width = width;
		this.height = height;
		this.life = life;
		this.color = color;
	}

	@Override
	public void tick() {
		// the tails render duration (how long it gonna be displayed b4 varnishing)
		if (alpha>life){
			alpha -= life;
		} else
			handler.removeObject(this);
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));
		g.setColor(color);
		g.fillRect(x, y, width, height);
		// current obj display (solid enemy)
//		g2d.setComposite(makeTransparent(1));
	}

	@Override
	public Rectangle getBounds() {
		return null;
	}
	// method to make each part of tails transparent, value of alpha
	private AlphaComposite makeTransparent(float alpha){
		int type = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type, alpha));
	}

}
