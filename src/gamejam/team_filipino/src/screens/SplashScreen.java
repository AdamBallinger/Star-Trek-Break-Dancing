package gamejam.team_filipino.src.screens;

import gamejam.team_filipino.src.Game;
import gamejam.team_filipino.src.Images;
import gamejam.team_filipino.src.utils.MathHelper;

public class SplashScreen extends Screen {

	/**
	 * Constructs the splash screen.
	 * @param game
	 */
	public SplashScreen(Game game) {
		super(game);
	}
	
	// The time (in updates) the screen has been active for. Used for switching the screen after a few seconds automatically.
	int activeTime = 0;
	/**
	 * Updates the screen 
	 */
	public void update() {
		activeTime++;
		if(activeTime >= MathHelper.getSeconds(5.3)) {
			game.setScreen(new HomeScreen(game));
		}
	}
	
	/**
	 * Renders the screen.
	 */
	public void render() {
		if(activeTime <= MathHelper.getSeconds(5)) {
			game.get2DGraphics().drawImage(Images.GUI_SPLASH, 0, 0, game.getDrawWidth(), game.getDrawHeight(), null);
		} else {
			game.get2DGraphics().drawImage(Images.GUI_PICARD, 0, 0, game.getDrawWidth(), game.getDrawHeight(), null);
		}
	}

}
