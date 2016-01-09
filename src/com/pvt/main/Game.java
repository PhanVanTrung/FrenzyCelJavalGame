package com.pvt.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;


public class Game  extends Canvas implements Runnable{

	private static final long serialVersionUID = 7356663384161444970L;

	public static final int WIDTH = 1366/ 2, HEIGHT = WIDTH/ 12 * 9;
	private Thread thread;
	private boolean running = false;
	public Handler handler;
//	private Random rand;
	private HUD hud;
	private Spawn respawn;
	private Menu menu;
	public static boolean paused = false;
	public int diff = 0; //0 - normal, 1 - hard
	
	public enum STATE{
		Menu(),
		Game(),
		Help(),
		End(),
		Select()
	};

	public static STATE gameState = STATE.Menu;
	
	public Game() {
		// initialise objects
		
		this.handler = new Handler();
		hud = new HUD();
		menu = new Menu(this, handler, hud);
		this.addKeyListener(new KeyInput(handler, this));
		this.addMouseListener(menu);
		
		new Window(WIDTH, HEIGHT, "FinzyFrenzy", this);
		
		
		respawn = new Spawn(handler, hud, this);
	
	}
	
	// the Game() creates a Window object, which starts up the start(), which calls run()
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;

	}
	public synchronized void stop() {
		try{
			thread.join();
			running = false;
		}catch(Exception e){ e.printStackTrace(); }
		for (int i = 0; i < handler.objects.size(); i++) {
			// do sth
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Game();
	}

	@Override
	public void run() {
		// point of this is every unit of time the runnable task runs
		// it gonna call the tick() and render() of the handler, which hold all objects,
		// and by that this gonna update position and render it the window
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;

		double timer = System.currentTimeMillis();
//		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if(running)
				render();
//			frames++;
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				//System.out.println("FPS: " + frames); frames = 0;
			}
		}
		stop();
	}
	private void tick() {
		if(gameState == STATE.Game){
			if (!paused) {
				hud.tick();
				respawn.tick();
				handler.tick();
				
				if(HUD.HEALTH <= 0) {
					HUD.HEALTH = 100;
					handler.clearEnemies();
					gameState = STATE.End;
				}
			}
		} else if ((gameState == STATE.Menu) || (gameState == STATE.End) || gameState == STATE.Select){
			menu.tick();
			handler.tick();
		}
	}

	private void render() {
		// Draw window properties and render objects
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) { this.createBufferStrategy(3); return;}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		// we get the handler running thru all the objects of the game, updating them and rendering them
		
		handler.render(g);
		
		if(paused) {
			g.setColor(Color.WHITE);
			g.drawString("PAUSING", 320, 250);
	}
		if(gameState == STATE.Game){
			hud.render(g);	
		} else if (gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End || gameState == STATE.Select){
			menu.render(g);
		}
				
		g.dispose();
		bs.show(); 
	}
	
	public static int isLimit(int val, int min, int max){
		if (val >= max) return val = max;
		else if (val<= min) return val = min;
		return val;
	}
	


}


// =================================================###########====================================
