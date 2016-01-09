package com.pvt.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.pvt.main.Game.STATE;

public class KeyInput extends KeyAdapter {

	private Handler handler;
	// 0 - up, 1 - down, 2 - right, 3 - left
	private boolean[] keyPressed = { false, false, false, false };
	Game game;
	
	public KeyInput(Handler handler, Game game) {
		this.handler = handler;
		this.game = game;
	}
	
	

	@Override
	public void keyPressed(KeyEvent e){
		// return ASCII code of the keyboard
		int key = e.getKeyCode();
		for (int i=0; i<handler.objects.size(); i++){
			GameObject tempObj = handler.objects.get(i);
			if(tempObj.getId()== ID.Player){
				// all key events are handled here for player 1
				if (key == KeyEvent.VK_UP){ tempObj.setVelY(-4); keyPressed[0] = true;}
				if (key == KeyEvent.VK_DOWN){ tempObj.setVelY(4); keyPressed[1] = true;}
				if (key == KeyEvent.VK_RIGHT){ tempObj.setVelX(4);keyPressed[2] = true;}
				if (key == KeyEvent.VK_LEFT){ tempObj.setVelX(-4);keyPressed[3] = true;}
			}
			
//			else if (tempObj.getId()== ID.Player2){
//				// all key events are handled here for player 2
//			if (key == KeyEvent.VK_W) tempObj.setVelY(-4);
//			if (key == KeyEvent.VK_S) tempObj.setVelY(4);
//			if (key == KeyEvent.VK_D) tempObj.setVelX(4);
//			if (key == KeyEvent.VK_A) tempObj.setVelX(-4);
//			}
		}
		if (key == KeyEvent.VK_P) {
			if (game.gameState == STATE.Game) {
				Game.paused = !Game.paused;
			}
		}
		if (key == KeyEvent.VK_ESCAPE) System.exit(0);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// return ASCII code of the keyboard
		int key = e.getKeyCode();
		for (int i = 0; i < handler.objects.size(); i++) {
			GameObject tempObj = handler.objects.get(i);
			if (tempObj.getId() == ID.Player) {
				// all key events are handled here for player 1
				if (key == KeyEvent.VK_UP)
					keyPressed[0] = false;
				if (key == KeyEvent.VK_DOWN)
					keyPressed[1] = false;
				if (key == KeyEvent.VK_RIGHT)
					keyPressed[2] = false;
				if (key == KeyEvent.VK_LEFT)
					keyPressed[3] = false;
				// vertical movement
				if (!keyPressed[0] && !keyPressed[1])
					tempObj.setVelY(0);
				// horizontal movement
				if (!keyPressed[2] && !keyPressed[3])
					tempObj.setVelX(0);
			}
			// else if (tempObj.getId()== ID.Player){
			// // all key events are handled here for player 2
			// if (key == KeyEvent.VK_W) tempObj.setVelY(0);
			// if (key == KeyEvent.VK_S) tempObj.setVelY(0);
			// if (key == KeyEvent.VK_A) tempObj.setVelX(0);
			// if (key == KeyEvent.VK_D) tempObj.setVelX(0);
			// }
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
