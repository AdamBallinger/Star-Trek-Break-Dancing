package gamejam.team_filipino.src.entities;

import gamejam.team_filipino.src.Game;
import gamejam.team_filipino.src.utils.MathHelper;

import java.awt.Image;

/**
 * The animation class for controlling Picard's dance moves and any other characters if there were any.
 * Most likely not the best way of doing things but it works :).
 *
 */
public class Animation {
	
	// The collection of images that will be rendered during the animation.
	public Image[] imgSet;
	// The time (in seconds) that each frame will be displayed for.
	public double frameSpeed;
	// The number of frames the animation consists of (set automatically).
	public int maxFrames;
	// The current frame index being played.
	public int currentFrame;
	// The current play time for the animation.
	public int playTime;
	// The X and Y coordinates the animation is played at on the screen.
	public int x, y;
	// The width and height of the animation.
	public int width, height;
	// If the animation constantly loops (Not yet implemented).
	public boolean loop;
	
	// If the animation has played each image. If true, the animation will play backwards to make a smooth transition.
	private boolean animationPlayback = false;
	
	/**
	 * Animation Constructor
	 * @param imgSet : Image[] : The collection of images to render for the animation.
	 * @param frameSpeed : double : Display time for each frame (in seconds).
	 * @param loop : boolean : If the animation loops endlessly or not (Not implemented).
	 * @param x : int : X coordinate on screen.
	 * @param y : int : Y coordinate on screen.
	 * @param width : int : The width of the frames in animation.
	 * @param height : int : The height of the frames in animation.
	 */
	public Animation(Image[] imgSet, double frameSpeed, boolean loop, int x, int y, int width, int height) {
		this.imgSet = imgSet;
		this.frameSpeed = frameSpeed;
		this.loop = loop;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		playTime = 0;
		currentFrame = 0;
		maxFrames = imgSet.length - 1;
	}
	
	/**
	 * Plays the animation.
	 */
	public void play() {
		playTime++;
		if(playTime >= MathHelper.getSeconds(frameSpeed)) {
			if(currentFrame == 0) {
				animationPlayback = false;
			} else if(currentFrame == maxFrames) {
				animationPlayback = true;
			}
			if(animationPlayback) {
				currentFrame--;
				if(currentFrame == 0) {
					Picard.animationIndex = -1;
				}
			} else {
				currentFrame++;
			}
			playTime = 0;
		}
	}
	
	/**
	 * Renders the animation to the screen.
	 */
	public void render() {
		Game.instance.get2DGraphics().drawImage(imgSet[currentFrame], x, y, width, height, null);
	}
}
