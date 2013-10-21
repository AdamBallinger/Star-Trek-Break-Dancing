package gamejam.team_filipino.src;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Images {

	public static final Image GUI_BACKGROUND = new ImageIcon(Game.class.getResource("/gui/Background.png")).getImage();
	public static final Image GUI_HOME = new ImageIcon(Game.class.getResource("/gui/Home Page.png")).getImage();
	public static final Image GUI_SPLASH = new ImageIcon(Game.class.getResource("/gui/Opening Screen.png")).getImage();
	public static final Image GUI_PICARD = new ImageIcon(Game.class.getResource("/gui/Picard.png")).getImage();
	public static final Image GUI_ARROW_BOARD = new ImageIcon(Game.class.getResource("/gui/Arrow Board.png")).getImage();
	
	public static final Image[] GUI_PICARD_MOOD = {
		new ImageIcon(Game.class.getResource("/gui/Picard Face.png")).getImage(),
		new ImageIcon(Game.class.getResource("/gui/Picard Happy.png")).getImage(),
		new ImageIcon(Game.class.getResource("/gui/Picard Angry.png")).getImage()
	};
	
	public static final Image[] ARROW_SET = {
		new ImageIcon(Game.class.getResource("/arrows/Arrow Up.png")).getImage(),
		new ImageIcon(Game.class.getResource("/arrows/Arrow Left.png")).getImage(),
		new ImageIcon(Game.class.getResource("/arrows/Arrow Right.png")).getImage(),
		new ImageIcon(Game.class.getResource("/arrows/Arrow Down.png")).getImage()
	};
	
	public static final Image[] ARROW_SET_GLOW_GREEN = {
		new ImageIcon(Game.class.getResource("/arrows/Arrow Up Glow.png")).getImage(),
		new ImageIcon(Game.class.getResource("/arrows/Arrow Left Glow.png")).getImage(),
		new ImageIcon(Game.class.getResource("/arrows/Arrow Right Glow.png")).getImage(),
		new ImageIcon(Game.class.getResource("/arrows/Arrow Down Glow.png")).getImage()
	};
	
	public static final Image[] ARROW_SET_GLOW_RED = {
		new ImageIcon(Game.class.getResource("/arrows/Arrow Up Glow 2.png")).getImage(),
		new ImageIcon(Game.class.getResource("/arrows/Arrow Left Glow 2.png")).getImage(),
		new ImageIcon(Game.class.getResource("/arrows/Arrow Right Glow 2.png")).getImage(),
		new ImageIcon(Game.class.getResource("/arrows/Arrow Down Glow 2.png")).getImage()
	};
	
	public static final Image[] PICARD_IDLE_SET = {
		new ImageIcon(Game.class.getResource("/dancers/picard/Picard Idle 1.png")).getImage(),
		new ImageIcon(Game.class.getResource("/dancers/picard/Picard Idle 2.png")).getImage(),
		new ImageIcon(Game.class.getResource("/dancers/picard/Picard Idle 3.png")).getImage(),
		new ImageIcon(Game.class.getResource("/dancers/picard/Picard Idle 4.png")).getImage()
	};
	
	public static final Image[] PICARD_UP_SET = {
		new ImageIcon(Game.class.getResource("/dancers/picard/Picard Up 1.png")).getImage(),
		new ImageIcon(Game.class.getResource("/dancers/picard/Picard Up 2.png")).getImage(),
		new ImageIcon(Game.class.getResource("/dancers/picard/Picard Up 3.png")).getImage(),
		new ImageIcon(Game.class.getResource("/dancers/picard/Picard Up 4.png")).getImage(),
		new ImageIcon(Game.class.getResource("/dancers/picard/Picard Up 5.png")).getImage(),
		new ImageIcon(Game.class.getResource("/dancers/picard/Picard Up 6.png")).getImage(),
		new ImageIcon(Game.class.getResource("/dancers/picard/Picard Up 7.png")).getImage(),
		new ImageIcon(Game.class.getResource("/dancers/picard/Picard Up 8.png")).getImage(),
		new ImageIcon(Game.class.getResource("/dancers/picard/Picard Up 9.png")).getImage(),
		new ImageIcon(Game.class.getResource("/dancers/picard/Picard Up 10.png")).getImage(),
		new ImageIcon(Game.class.getResource("/dancers/picard/Picard Up 11.png")).getImage(),
		new ImageIcon(Game.class.getResource("/dancers/picard/Picard Up 12.png")).getImage(),
		new ImageIcon(Game.class.getResource("/dancers/picard/Picard Up 13.png")).getImage(),
		new ImageIcon(Game.class.getResource("/dancers/picard/Picard Up 14.png")).getImage(),
		new ImageIcon(Game.class.getResource("/dancers/picard/Picard Up 15.png")).getImage(),
		new ImageIcon(Game.class.getResource("/dancers/picard/Picard Up 15.png")).getImage()
	};
	
	public static final Image[] PICARD_LEFT_SET = {
		new ImageIcon(Game.class.getResource("/dancers/picard/Picard Left 1.png")).getImage(),
		new ImageIcon(Game.class.getResource("/dancers/picard/Picard Left 2.png")).getImage(),
		new ImageIcon(Game.class.getResource("/dancers/picard/Picard Left 3.png")).getImage(),
		new ImageIcon(Game.class.getResource("/dancers/picard/Picard Left 4.png")).getImage(),
		new ImageIcon(Game.class.getResource("/dancers/picard/Picard Left 5.png")).getImage(),
		new ImageIcon(Game.class.getResource("/dancers/picard/Picard Left 5.png")).getImage()
	};
	
	public static final Image[] PICARD_RIGHT_SET = {
		new ImageIcon(Game.class.getResource("/dancers/picard/Picard Right 1.png")).getImage(),
		new ImageIcon(Game.class.getResource("/dancers/picard/Picard Right 2.png")).getImage(),
		new ImageIcon(Game.class.getResource("/dancers/picard/Picard Right 3.png")).getImage(),
		new ImageIcon(Game.class.getResource("/dancers/picard/Picard Right 4.png")).getImage(),
		new ImageIcon(Game.class.getResource("/dancers/picard/Picard Right 5.png")).getImage(),
		new ImageIcon(Game.class.getResource("/dancers/picard/Picard Right 5.png")).getImage()
	};
	
	public static final Image[] PICARD_DOWN_SET = {
		new ImageIcon(Game.class.getResource("/dancers/picard/Picard Down 1.png")).getImage(),
		new ImageIcon(Game.class.getResource("/dancers/picard/Picard Down 2.png")).getImage(),
		new ImageIcon(Game.class.getResource("/dancers/picard/Picard Down 3.png")).getImage(),
		new ImageIcon(Game.class.getResource("/dancers/picard/Picard Down 4.png")).getImage(),
		new ImageIcon(Game.class.getResource("/dancers/picard/Picard Down 4.png")).getImage()
	};
}
