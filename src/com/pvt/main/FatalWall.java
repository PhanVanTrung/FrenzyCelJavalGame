package com.pvt.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FatalWall extends GameObject{

	public FatalWall(ID id, Handler handler) {
		super(id);
		// velocity to X, velocity to Y
		velX = 0;
		velY = 0;
	}
	
	public FatalWall(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		// velocity to X, velocity to Y
		velX = 0;
		velY = 0;
		// browse the handler to get the player and pass it to the player object variable.
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(x, y, Game.WIDTH, 30);

		// draw boundary
//		Graphics2D g2d = (Graphics2D) g;
//		g2d.setColor(Color.white);
//		g2d.draw(getBounds());
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x, y, Game.WIDTH, 30);
	}

}
