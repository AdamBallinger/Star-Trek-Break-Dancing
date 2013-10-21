package gamejam.team_filipino.src.screens;

import gamejam.team_filipino.src.Game;
import gamejam.team_filipino.src.Images;
import gamejam.team_filipino.src.Sound;

import java.awt.Color;
import java.awt.Font;

public class MusicSelectionScreen extends Screen {

	// the music track being selected.
	private int selection = 0;
	
	/**
	 * Constructs the Music Selection Screen
	 * @param game : Game : Instance of Game being assigned too.
	 */
	public MusicSelectionScreen(Game game) {
		super(game);
	}
	
	/**
	 * Updates the screen.
	 * Checks user input changing track selection from up and down input.
	 * Sets the music to play when enter is pressed then starts the game.
	 */
	public void update() {
		if(game.input.up.clicked) {
			if(selection == 1) {
				selection--;
			} else {
				selection++;
			}
		} else if (game.input.down.clicked) {
			if(selection == 0) {
				selection++;
			} else {
				selection--;
			}
		}
		
		// If escape is pressed then the home screen is displayed.
		if(game.input.escape.clicked) {
			game.setScreen(new HomeScreen(game));
		}
		
		if(game.input.enter.clicked) {
			switch(selection) {
			case 0:
				Sound.music_picard.play();
				break;
			case 1:
				Sound.music_trekkin.play();
				break;
			}
			game.setScreen(new GameScreen(game));
		}
	}
	
	/**
	 * Renders the contents of the screen.
	 */
	public void render() {
		// Draws the background image and sets text font and color.
		game.get2DGraphics().drawImage(Images.GUI_BACKGROUND, 0, 0, game.getDrawWidth(), game.getDrawHeight(), null);
		game.get2DGraphics().setFont(new Font("Impact", Font.BOLD, 32));
		game.get2DGraphics().setColor(Color.WHITE);
		
		// Draws the collection of tracks that can be played as well as the ">" to indicate the current selection.
		game.get2DGraphics().drawString("Picard Song", 40, 50);
		game.get2DGraphics().drawString("Trekkin' Song", 40, 80);
		if(selection == 0) {
			game.get2DGraphics().drawString(" > ", 6, 50);
		} else {
			game.get2DGraphics().drawString(" > ", 6, 80);
		}
	}

}
