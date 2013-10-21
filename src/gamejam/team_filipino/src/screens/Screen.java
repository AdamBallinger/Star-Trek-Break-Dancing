package gamejam.team_filipino.src.screens;

import gamejam.team_filipino.src.Game;

import java.util.Random;

/**
 * This is the main class that all screens extend. This doesnt actually represent a screen in the game by itself.
 *
 */
public class Screen {
	
	public Random rand = new Random();
	public Game game;

	public Screen(Game game) {
		this.game = game;
	}
	
	public void update() {	
	}
	
	public void render() {
	}
}
