package gamejam.team_filipino.src.entities;

import gamejam.team_filipino.src.Images;

public class Picard {
	
	public static int animationIndex = -1;
	public static int portraitIndex = 0;
	
	public int x, y;
	public int width = 256;
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
	
	public Picard() {
		x = 450;
		y = 55;
		idleAnimation = new Animation(Images.PICARD_IDLE_SET, .15, false, x, y, width, height);
		upAnimation = new Animation(Images.PICARD_UP_SET, .04, false, x, y, width, height);
		leftAnimation = new Animation(Images.PICARD_LEFT_SET, .15, false, x, y, width, height);
		rightAnimation = new Animation(Images.PICARD_RIGHT_SET, .15, false, x, y, width, height);
		downAnimation = new Animation(Images.PICARD_DOWN_SET, .1, false, x, y, width, height);
	}
	
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
