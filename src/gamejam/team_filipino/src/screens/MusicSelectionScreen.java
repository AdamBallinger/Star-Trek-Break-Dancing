package gamejam.team_filipino.src.screens;

import gamejam.team_filipino.src.Game;
import gamejam.team_filipino.src.Images;
import gamejam.team_filipino.src.Sound;

import java.awt.Color;
import java.awt.Font;

public class MusicSelectionScreen extends Screen {

	private int selection = 0;
	
	public MusicSelectionScreen(Game game) {
		super(game);
	}
	
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
	
	public void render() {
		game.get2DGraphics().drawImage(Images.GUI_BACKGROUND, 0, 0, game.getDrawWidth(), game.getDrawHeight(), null);
		game.get2DGraphics().setFont(new Font("Impact", Font.BOLD, 32));
		game.get2DGraphics().setColor(Color.WHITE);
		game.get2DGraphics().drawString("Picard Song", 40, 50);
		game.get2DGraphics().drawString("Trekkin' Song", 40, 80);
		if(selection == 0) {
			game.get2DGraphics().drawString(" > ", 6, 50);
		} else {
			game.get2DGraphics().drawString(" > ", 6, 80);
		}
	}

}
