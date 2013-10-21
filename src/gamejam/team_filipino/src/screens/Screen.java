package gamejam.team_filipino.src.screens;

import gamejam.team_filipino.src.Game;

import java.util.Random;

/**
 * This is the main class that all screens extend. This doesnt actually represent a screen in the game by itself.
 *
 */
public class Screen {
	
	// Global random object all classes extending screen can access.
	public Random rand = new Random();
	
	// Instance of game the screen is assigned too.
	public Game game;

	public Screen(Game game) {
		this.game = game;
	}
	
	// Abstract update method overridden in other screen classes.
	public void update() {	
	}
	
	// Abstract render method overridden in other screen classes.
	public void render() {
	}
}
