package com.pvt.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	// Hold/store, maintain, update and render all objects in the game
	
	// Use LinkedList bcoz we dont know exact number of game objects we gonna have
	LinkedList<GameObject> objects = new LinkedList<GameObject>();
	
	// tick() and render() mission: iterate thru objects, update and render them
	// tick: update/increment/decrement/whatever it is the object position
	public void tick(){
		// iterate game objects
		for (int i=0; i< objects.size(); i++){
			// calling the tick() of the real object
			GameObject tempObject = objects.get(i);
			tempObject.tick();
		}
	}
	// render: draw the object
	public void render(Graphics g){
		// iterate game objects
		for (int i = 0; i< objects.size(); i++){
			// calling the render() of the real object
			GameObject tempObject = objects.get(i);
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject obj){
		this.objects.add(obj);
	}
	
	public void removeObject(GameObject obj){
		this.objects.remove(obj);
	}
}
