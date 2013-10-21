package gamejam.team_filipino.src.screens;

import gamejam.team_filipino.src.Game;
import gamejam.team_filipino.src.Images;
import gamejam.team_filipino.src.Sound;

import java.awt.Color;
import java.awt.Font;

public class LostScreen extends Screen {

	/**
	 * Constructs the Lost Screen.
	 * @param game : Game : Instance of Game the screen is assigned too.
	 */
	public LostScreen(Game game) {
		super(game);
		Sound.music_picard.stop(); // Forces the music to stop or it continues to play :p
		Sound.music_trekkin.stop();
	}
	
	/**
	 * Updates the screen.
	 * Checks if the user presses enter to return to the home screen.
	 */
	public void update() {
		if(game.input.enter.clicked) {
			game.setScreen(new HomeScreen(game));
		}
	}
	
	/**
	 * Renders the content of Lost Screen to screen.
	 */
	public void render() {
		// Draws the background, and sets text font and color.
		game.get2DGraphics().drawImage(Images.GUI_PICARD, 0, 0, game.getDrawWidth(), game.getDrawHeight(), null);
		game.get2DGraphics().setFont(new Font("Impact", Font.BOLD, 32));
		game.get2DGraphics().setColor(Color.BLACK);
		
		//Draws the stats to the scren.
		game.get2DGraphics().drawString("You lost.", 10, 30);
		game.get2DGraphics().drawString("You scored: " + game.score, 10, 60);
		game.get2DGraphics().drawString("Press enter to return.", 10, 90);
	}

}
