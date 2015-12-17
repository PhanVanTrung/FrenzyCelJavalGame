package com.pvt.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class AdvancedEnemy extends GameObject{
	
	private Handler handler;
	private GameObject player;

	public AdvancedEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		// velocity to X, velocity to Y
		velX = 1;
		velY = 1;
		this.handler = handler;
		// browse the handler to get the player and pass it to the player object variable.
		for (int i =0; i < handler.objects.size(); i++){
			if (handler.objects.get(i).getId() == ID.Player) player = (Player) handler.objects.get(i);
		}
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		int playerPosX = player.getX();
		int playerPosY = player.getY();
		if (x<playerPosX)
			x += velX;
		if (x>playerPosX)
			x -= velX;
		if (y<playerPosY)
			y += velY;
		if (y>playerPosY)
			y -= velY;
//		x = velX;
//		y = velY;
		// Change the direction if enemy object hits the wall
//		if (y<=0 || y >= Game.HEIGHT - 28) velY *= -1;
//		if (x<=0 || x >= Game.WIDTH - 14) velX *= -1;
		// add the tails to handler with the position of the enemy (copy enemy position to trail)
		handler.addObject(new Trail(x+9, y+9, ID.Trail, Color.yellow, 14, 14, 0.05f, handler));
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(x+9, y+9, 14, 14);

		// draw boundary
//		Graphics2D g2d = (Graphics2D) g;
//		g2d.setColor(Color.white);
//		g2d.draw(getBounds());
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x+9, y+9, 14, 14);
	}

}
