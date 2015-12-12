package com.pvt.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	// heads up display
	
	public static int HEALTH = 100;
	public void tick(){
//		HEALTH--;
		HEALTH = Game.isWall(HEALTH, 0, 100);
	}
	public void render(Graphics g){
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 32);
		g.setColor(Color.green);
		g.fillRect(15, 15, 2*HEALTH, 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, 2*HEALTH, 32);
		g.drawString(HEALTH +"%", 15, 15);
	}
}
