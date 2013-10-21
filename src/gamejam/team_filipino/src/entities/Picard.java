package gamejam.team_filipino.src.entities;

import gamejam.team_filipino.src.Images;

public class Picard {
	
	/**
	 * If the value is -1, then an animation can play. If an animation is already playing e.g animationIndex = 1,
	 * then to prevent animations cutting off when the speed of the game gets faster, it prevents a new animation
	 * from playing before the current one is completed, in which animationIndex returns to -1.
	 */
	public static int animationIndex = -1;
	// Controls the image used in the portrait on the game screen.
	public static int portraitIndex = 0;
	
	// X and Y coordinates of Picard.
	public int x, y;
	// Width of Picard.
	public int width = 256;
	// Height of Picard.
	public int height = 256;
	
	// Animation played whilst idle
	private Animation idleAnimation;
	// Animation played when moving to an UP arrow
	private Animation upAnimation;
	// Animation played when moving to a LEFT arrow
	private Animation leftAnimation;
	// Animation played when moving to a DOWN arrow
	private Animation downAnimation;
	// Animation played when moving to a RIGHT arrow
	private Animation rightAnimation;
	
	/**
	 * Picard constructor
	 */
	public Picard() {
		x = 450;
		y = 55;
		idleAnimation = new Animation(Images.PICARD_IDLE_SET, .15, false, x, y, width, height);
		upAnimation = new Animation(Images.PICARD_UP_SET, .04, false, x, y, width, height);
		leftAnimation = new Animation(Images.PICARD_LEFT_SET, .15, false, x, y, width, height);
		rightAnimation = new Animation(Images.PICARD_RIGHT_SET, .15, false, x, y, width, height);
		downAnimation = new Animation(Images.PICARD_DOWN_SET, .1, false, x, y, width, height);
	}
	
	/**
	 * Updates Picard
	 * Controls which animation should be played.
	 */
	public void update() {
		switch(animationIndex) {
		case -1: // IDLE MOVE
			idleAnimation.play();
			break;
		case 0: // UP MOVE
			upAnimation.play();
			break;
		case 1: // LEFT MOVE
			leftAnimation.play();
			break;
		case 2: // RIGHT MOVE
			rightAnimation.play();
			break;
		case 3: // DOWN MOVE
			downAnimation.play();
			break;
		}
	}
	
	/**
	 * Renders Picard
	 * Controls which animation should be rendered.
	 */
	public void render() {
		switch(animationIndex) {
		case -1: // IDLE MOVE
			idleAnimation.render();
			break;
		case 0: // UP MOVE
			upAnimation.render();
			break;
		case 1: // LEFT MOVE
			leftAnimation.render();
			break;
		case 2: // RIGHT MOVE
			rightAnimation.render();
			break;
		case 3: // DOWN MOVE
			downAnimation.render();
			break;
		}
	}	
}
