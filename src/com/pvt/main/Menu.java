package com.pvt.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.pvt.main.Game.STATE;

public class Menu extends MouseAdapter{
	private Game game;
	private Handler handler;
	private Random rand = new Random();
	public Menu(Game game, Handler handler){
		this.game = game;
		this.handler = handler;
	}
	
	@Override
	public void mousePressed(MouseEvent e){
		// get mouse position
		int mx = e.getX();
		int my = e.getY();
		// Play button
		if (mouseOver(mx, my, 260, 100, 150, 64)){
			game.gameState = STATE.Game;
			handler.addObject(new Player(Game.WIDTH/2 - 16, Game.HEIGHT/2 - 16, ID.Player, handler));
			//		handler.addObject(new Player(WIDTH/2 - 64, HEIGHT/2 - 64, ID.Player2));
					handler.addObject(new BasicEnemy(rand.nextInt(Game.WIDTH - 50), rand.nextInt(Game.HEIGHT - 50), ID.Enemy, handler));
		}
		if (mouseOver(mx, my, 260, 300, 150, 64)){
			System.exit(0);
		}
	}
	@Override
	public void mouseReleased(MouseEvent e){
		
	}
	public void tick(){
		
	}
	public void render(Graphics g){
		g.setColor(Color.white);
		
		Font fnt = new Font("arial", 1, 50);
		Font fnt2 = new Font("arial", 1, 25);
		
		g.setFont(fnt);
		g.drawString("Menu", 270, 70);
		// draw menu options
		g.setFont(fnt2);
		g.drawString("Play", 310, 140);
		g.drawRect(260, 100, 150, 64);
		
		g.setFont(fnt2);
		g.drawString("Help", 310, 240);
		g.drawRect(260, 200, 150, 64);
		
		g.setFont(fnt2);
		g.drawString("Quit", 310, 340);
		g.drawRect(260, 300, 150, 64);
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
		if (mx > x && mx < x + width && my > y && my < y + height)
			return true;
		else
			return false;
	}
}
