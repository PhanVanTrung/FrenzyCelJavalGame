package com.pvt.main;

import java.awt.Color;
import java.util.HashMap;
import java.util.Random;

public class ObjectFactory {
	static Random rand = new Random();
	public static final HashMap<String, GameObject> myHashMap = new HashMap<String, GameObject>();

	//	private static Handler handler = Game.handler;

	// Every other attributes of a specific object need to be set later when the client actual requesting
	// this Factory to get object
	public static GameObject getObject(String enemyType, Handler handler) {
		// retrieve object in the hashmap if exist
		GameObject concreteObject = myHashMap.get(enemyType);
		
		if (concreteObject == null) {
			if(enemyType.equals("AdvE")) {
				concreteObject = new AdvancedEnemy(ID.FatalEnemy, handler);
			}

			else if (enemyType.equals("BasicE")) {
				concreteObject = new BasicEnemy(ID.Enemy, handler);
			}

			else if (enemyType.equals("BossB")) {
				concreteObject = new BossBullet(ID.Enemy, handler);
			}

			else if (enemyType.equals("BossE")) {
				concreteObject = new BossEnemy(ID.BossEnemy, handler);
			}

			else if (enemyType.equals("FastE")) {
				concreteObject = new FastEnemy(ID.Enemy, handler);
			}

			else if (enemyType.equals("FatalW")) {
				concreteObject = new FatalWall(ID.FatalEnemy, handler);
			}

			else if (enemyType.equals("HardE")) {
				concreteObject = new HardEnemy(ID.HardEnemy, handler);
			}
			else if (enemyType.equals("Player")) {
				concreteObject = new Player(ID.Player, handler);
			}
			myHashMap.put(enemyType, concreteObject);
		}
		return concreteObject;
	}

	public static GameObject getTrail(Color color, Handler handler) {
		Trail Trail = (Trail) myHashMap.get(color);
		if (Trail==null) {
			Trail = new Trail(ID.Trail, color, handler);
			// put GameObject Models to the enemyHM hashmap
			myHashMap.put(color.toString(), Trail);
		}
		return Trail;
	}
}
