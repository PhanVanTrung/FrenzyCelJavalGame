package com.pvt.main;

import java.awt.Color;
import java.awt.Graphics;


public class HUD {
	// heads up display
	
	public static int HEALTH = 100;
	private int score = 0;
	private int level = 1;
	private int green =0;
	
	public void tick(){
		HEALTH = Game.isLimit(HEALTH, 0, 100);
		score ++;
		green = (int) (HEALTH*2.55);
	}
	public void render(Graphics g){
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 32);
		g.setColor(new Color(255-green, green, 0));
		g.fillRect(15, 15, 2*HEALTH, 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, 2*HEALTH, 32);
		g.drawString(HEALTH +"%", 15, 15);
		g.drawString("Score        " + score, 15, 65);
		g.drawString("Level     " + level, 15, 85);
	}
	
	public static int getHEALTH() {
		return HEALTH;
	}
	public static void setHEALTH(int hEALTH) {
		HEALTH = hEALTH;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public void score(int score){
		this.score = score;
	}
}
