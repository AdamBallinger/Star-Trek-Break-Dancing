package gamejam.team_filipino.src.screens;

import gamejam.team_filipino.src.Game;
import gamejam.team_filipino.src.Images;
import gamejam.team_filipino.src.Sound;
import gamejam.team_filipino.src.entities.Picard;
import gamejam.team_filipino.src.utils.MathHelper;

import java.awt.Color;
import java.awt.Font;

public class HomeScreen extends Screen {
	
	public HomeScreen(Game game) {
		super(game);
		Sound.music_picard.stop();
		Sound.music_trekkin.stop();
		Picard.portraitIndex = 0;
		game.lives = 10;
	}
	
	int flashTimer;
	public void update() {
		flashTimer++;
		if(game.input.enter.clicked) {
			game.setScreen(new MusicSelectionScreen(game));
		}
	}
	
	public void render() {
		game.get2DGraphics().drawImage(Images.GUI_HOME, 0, 0, game.getDrawWidth(), game.getDrawHeight(), null);
		game.get2DGraphics().setColor(Color.BLACK);
		
		// Draws rectangle over Press Enter text to make it appear flashing.
		if(flashTimer >= MathHelper.getSeconds(.7)) {
			game.get2DGraphics().fillRect(300, 465, 190, 40);
			if(flashTimer >= MathHelper.getSeconds(1.2)) {
				flashTimer = 0;
			}
		} 
		
		// Draw credits
		game.get2DGraphics().setColor(Color.WHITE);
		game.get2DGraphics().setFont(new Font("Arial", Font.BOLD, 20));
		game.get2DGraphics().drawString("Created by: Team Filipino Party", 20, 60);
		game.get2DGraphics().setFont(new Font("Arial", Font.BOLD, 16));
		game.get2DGraphics().drawString("Adam Ballinger", 20, 80);
		game.get2DGraphics().drawString("Tom Cornall", 20, 100);
		game.get2DGraphics().drawString("Tayler Stapleton", 20, 120);
	}

}
