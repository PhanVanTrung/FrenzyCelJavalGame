package com.pvt.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game  extends Canvas implements Runnable{

	private static final long serialVersionUID = 7356663384161444970L;

//	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
//	public static final int WIDTH = 1366, HEIGHT = 768;
	public static final int WIDTH = 1366/ 2, HEIGHT = WIDTH/ 12 * 9;
	private Thread thread;
	private boolean running = false;
	private Handler handler;
	private Random rand;
	private HUD hud;
	private Spawn spawn;

	public Game() {
		// initialise objects
		this.handler = new Handler();
		this.addKeyListener(new KeyInput(handler));
		rand = new Random();
		new Window(WIDTH, HEIGHT, "FinzyFrenzy", this);
		hud = new HUD();
		handler.addObject(new Player(WIDTH/2 - 32, HEIGHT/2 - 32, ID.Player, handler));
//		handler.addObject(new Player(WIDTH/2 - 64, HEIGHT/2 - 64, ID.Player2));
		handler.addObject(new BasicEnemy(rand.nextInt(WIDTH) - 50, rand.nextInt(HEIGHT) - 50, ID.Enemy, handler));
		spawn = new Spawn(handler, hud);
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
	private void render() {
		// Draw window properties and render objects
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) { this.createBufferStrategy(3); return;}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		// we get the handler running thru all the objects of the game, updating them and rendering them
		handler.render(g);
		hud.render(g);
		
		g.dispose();
		bs.show(); 
	}
	
	public static int isLimit(int val, int min, int max){
		if (val >= max) return val = max;
		else if (val<= min) return val = min;
		return val;
	}
	
	private void tick() {
		handler.tick();
		hud.tick();
		spawn.tick();
	}

}
