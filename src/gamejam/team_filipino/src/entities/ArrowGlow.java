package gamejam.team_filipino.src.entities;

import gamejam.team_filipino.src.Game;
import gamejam.team_filipino.src.Images;
import gamejam.team_filipino.src.utils.MathHelper;

public class ArrowGlow {

	public double x, y;
	public int arrowId;
	public int glowType;
	public int width, height;
	private boolean removed = false;
	
	/**
	 * Creates the glow to an arrow when it is hit or missed.
	 * @param x : double : Starting X coordinate
	 * @param y : double : Starting X coordinate
	 * @param arrowId : int : ID of the arrow it is being given a glow for (Same as arrow class as in its direction).
	 * @param glowType : int : 0 or 1. 0 being green glow for hit and 1 being red glow for missed.
	 */
	public ArrowGlow(int x, int y, int arrowId, int glowType) {
		this.x = x;
		this.y = y;
		this.arrowId = arrowId;
		width = 32;
		height = 32;
		this.glowType = glowType;
	}
	
	/**
	 * Flags the glow to be removed when the next update is called.
	 */
	private void remove() {
		removed = true;
	}
	
	/**
	 * Returns if the arrow should be removed.
	 * @return removed
	 */
	public boolean removed() {
		return removed;
	}
	
	// the time (in updates) the arrow has been alive for.
	int aliveTime = 0;
	/**
	 * Updates the arrow glow effect.
	 * Simply detects the type (red or green) and changes the Y coordinate accordingly.
	 * Red goes down, green goes up.
	 */
	public void update() {
		aliveTime++;
		// checks if the glow has been alive for .7 seconds.
		if(aliveTime >= MathHelper.getSeconds(.7)) {
			remove();
		} else {
			if(glowType == 0) {
				y -= .8;
			} else {
				y += .5;
			}
		}
	}
	
	/**
	 * Renders the glow effect.
	 */
	public void render() {
		if(glowType == 0) {
			Game.instance.get2DGraphics().drawImage(Images.ARROW_SET_GLOW_GREEN[arrowId], (int)x, (int)y, width, height, null);
		} else {
			Game.instance.get2DGraphics().drawImage(Images.ARROW_SET_GLOW_RED[arrowId], (int)x, (int)y, width, height, null);
		}
	}
	
}
