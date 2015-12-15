package com.pvt.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends GameObject {
	
	Handler handler;
	
	//------------------
	private BufferedImage player;
	private void loadPlayer(){
		BufferedImage img = null;
		try{
			img = ImageIO.read(new File("E:\\Eclipse Workspace\\FrenzyCellGame\\rsz_1rsz_player.png"));
		} catch (IOException e){
			e.printStackTrace();
		}
		player = img;
	}

	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		// initially dont set the velocity for player. But it will be when key movement is hit
		this.handler = handler;
		loadPlayer();
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		x = Game.isLimit(x, 0, Game.WIDTH - 38);
		y = Game.isLimit(y, 0, Game.HEIGHT - 61);
		
		collision();
	}

	private void collision() {
		for (GameObject tempObj : handler.objects){
			// Collision code
			if (tempObj.getId()==ID.Enemy && getBounds().intersects(tempObj.getBounds())){
				HUD.HEALTH -= 1;
			}
		}
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(player, x, y, null);
		// For 2-player mode
//		if(id == ID.Player){
//			g.setColor(Color.red);
//		}
//		else
//			g.setColor(Color.green);

//		g.fillRect(x, y, 32, 32);
		
		// Boundary
//		Graphics2D g2d = (Graphics2D) g;
//		g2d.setColor(Color.pink);
//		g2d.draw(getBounds());
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x, y, 32, 32);
	}

}
