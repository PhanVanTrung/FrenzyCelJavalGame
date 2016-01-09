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
	private HUD hud;
	private Random rand = new Random();
	public Menu(Game game, Handler handler, HUD hud){
		this.game = game;
		this.handler = handler;
		this.hud = hud;
	}
	
	@Override
	public void mousePressed(MouseEvent e){
		// get mouse position
		int mx = e.getX();
		int my = e.getY();
		if (game.gameState == STATE.Menu) {
			// Play button
			if (mouseOver(mx, my, 260, 100, 150, 64)){
				game.gameState = STATE.Select;
				return;
			}

			if (mouseOver(mx, my, 260, 200, 150, 64)) {
				game.gameState = STATE.Help;
			}
			if (mouseOver(mx, my, 260, 300, 150, 64)){
				System.exit(0);
			}
		}
		
		if (game.gameState == STATE.Select) {
			// Normal button
			if (mouseOver(mx, my, 260, 100, 150, 64)){
				game.gameState = STATE.Game;
				handler.addObject(new Player(Game.WIDTH/2 - 100, Game.HEIGHT/2 - 100, ID.Player, handler));
				
				handler.clearEnemies();
				handler.addObject(new BasicEnemy(rand.nextInt(Game.WIDTH - 50), rand.nextInt(Game.HEIGHT - 50), ID.Enemy, handler));

				game.diff = 0;
			}
			// Hard Button
			if (mouseOver(mx, my, 260, 200, 150, 64)) {
				game.gameState = STATE.Game;
				handler.addObject(new Player(Game.WIDTH/2 - 16, Game.HEIGHT/2 - 16, ID.Player, handler));
				handler.clearEnemies();
				handler.addObject(new HardEnemy(rand.nextInt(Game.WIDTH - 50), rand.nextInt(Game.HEIGHT - 50), ID.HardEnemy, handler));

				game.diff = 1;
			}
			// Back Button
			if (mouseOver(mx, my, 260, 300, 150, 64)){
				game.gameState = STATE.Menu;
				return;
			}
		}

		if (game.gameState == STATE.Help && mouseOver(mx, my, 260, 310, 150, 64)) {
			game.gameState = STATE.Menu;
			return;
		}
		// Retry button
		if (game.gameState == STATE.End && mouseOver(mx, my, 260, 310, 150, 64)) {
			game.gameState = STATE.Menu;
			hud.setLevel(1);
			hud.score(0);
			handler.clearEnemies();
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
		
		if(game.gameState == STATE.Menu) {
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
		} else if (game.gameState == STATE.Help) {
			g.setFont(fnt);
			g.drawString("Help", 270, 70);
			
			g.setFont(fnt2);
			g.drawString("Use ADSW to move the player and SURVIVE!", 100, 120);
			g.drawString("Red : Dummy - Low Damage", 100, 160);
			g.drawString("Cyan: Fast - Low Damage", 100, 200);
			g.drawString("Green: Free Move - High Damage", 100, 240);
			g.drawString("Yellow: Slow - Fatality", 100, 280);
			g.drawString("Back", 300, 350);
			g.drawRect(260, 310, 150, 64);
			
		}else if (game.gameState == STATE.End) {
			g.setFont(fnt);
			g.drawString("Game Over", 200, 70);
			
			g.setFont(fnt2);
			g.drawString("You lost with a score of " + hud.getScore(), 190, 200);
			g.drawString("Retry", 320, 350);
			g.drawRect(280, 310, 150, 64);
		} else if(game.gameState == STATE.Select) {
			g.setFont(fnt);
			g.drawString("DIFFICULTY", 200, 70);
			// draw menu options
			g.setFont(fnt2);
			g.drawString("Normal", 300, 140);
			g.drawRect(260, 100, 150, 64);

			g.setFont(fnt2);
			g.drawString("Hard", 300, 240);
			g.drawRect(260, 200, 150, 64);

			g.setFont(fnt2);
			g.drawString("Back", 300, 340);
			g.drawRect(260, 300, 150, 64);
		}
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
		if (mx > x && mx < x + width && my > y && my < y + height)
			return true;
		else
			return false;
	}
}
