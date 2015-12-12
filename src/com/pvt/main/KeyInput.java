package com.pvt.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter{

	private Handler handler;

	public KeyInput(Handler handler) {
		this.handler = handler;
	}

	@Override
	public void keyPressed(KeyEvent e){
		// return ASCII code of the keyboard
		int key = e.getKeyCode();
		for (int i=0; i<handler.objects.size(); i++){
			GameObject tempObj = handler.objects.get(i);
			if(tempObj.getId()== ID.Player){
				// all key events are handled here for player 1
				if (key == KeyEvent.VK_UP) tempObj.setVelY(-4);
				if (key == KeyEvent.VK_DOWN) tempObj.setVelY(4);
				if (key == KeyEvent.VK_LEFT) tempObj.setVelX(-4);
				if (key == KeyEvent.VK_RIGHT) tempObj.setVelX(4);
			}
//			else if (tempObj.getId()== ID.Player2){
//				// all key events are handled here for player 2
//			if (key == KeyEvent.VK_W) tempObj.setVelY(-4);
//			if (key == KeyEvent.VK_S) tempObj.setVelY(4);
//			if (key == KeyEvent.VK_A) tempObj.setVelX(-4);
//			if (key == KeyEvent.VK_D) tempObj.setVelX(4);
//			}
		}
		if (key == KeyEvent.VK_ESCAPE) System.exit(0);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// return ASCII code of the keyboard
		int key = e.getKeyCode();
		for (int i=0; i<handler.objects.size(); i++){
			GameObject tempObj = handler.objects.get(i);
			if(tempObj.getId()== ID.Player){
				// all key events are handled here for player 1
				if (key == KeyEvent.VK_UP) tempObj.setVelY(0);
				if (key == KeyEvent.VK_DOWN) tempObj.setVelY(0);
				if (key == KeyEvent.VK_LEFT) tempObj.setVelX(0);
				if (key == KeyEvent.VK_RIGHT) tempObj.setVelX(0);

			}
//			else if (tempObj.getId()== ID.Player){
//				// all key events are handled here for player 2
//			if (key == KeyEvent.VK_W) tempObj.setVelY(0);
//			if (key == KeyEvent.VK_S) tempObj.setVelY(0);
//			if (key == KeyEvent.VK_A) tempObj.setVelX(0);
//			if (key == KeyEvent.VK_D) tempObj.setVelX(0);
//			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
