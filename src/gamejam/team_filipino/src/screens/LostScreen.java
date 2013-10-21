package gamejam.team_filipino.src.screens;

import gamejam.team_filipino.src.Game;
import gamejam.team_filipino.src.Images;
import gamejam.team_filipino.src.Sound;

import java.awt.Color;
import java.awt.Font;

public class LostScreen extends Screen {

	public LostScreen(Game game) {
		super(game);
		Sound.music_picard.stop();
		Sound.music_trekkin.stop();
	}
	
	public void update() {
		if(game.input.enter.clicked) {
			game.setScreen(new HomeScreen(game));
		}
	}
	
	public void render() {
		game.get2DGraphics().drawImage(Images.GUI_PICARD, 0, 0, game.getDrawWidth(), game.getDrawHeight(), null);
		game.get2DGraphics().setFont(new Font("Impact", Font.BOLD, 32));
		game.get2DGraphics().setColor(Color.BLACK);
		game.get2DGraphics().drawString("You lost.", 10, 30);
		game.get2DGraphics().drawString("You scored: " + game.score, 10, 60);
		game.get2DGraphics().drawString("Press enter to return.", 10, 90);
	}

}
