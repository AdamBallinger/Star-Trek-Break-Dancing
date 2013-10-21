package gamejam.team_filipino.src;

import java.applet.Applet;

public class WebApplet extends Applet {
	private static final long serialVersionUID = 1L;
	private Game game;
	
	public void init() {
		Sound.load();
		game = new Game(true);
		add(game);
	}
	
	public void start() {
		game.start();
	}
	
	public void stop() {
		Sound.music_picard.stop();
		Sound.music_trekkin.stop();
		game.stop();
	}
}
