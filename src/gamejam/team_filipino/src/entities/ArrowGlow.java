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
	
	public ArrowGlow(int x, int y, int arrowId, int glowType) {
		this.x = x;
		this.y = y;
		this.arrowId = arrowId;
		width = 32;
		height = 32;
		this.glowType = glowType;
	}
	
	private void remove() {
		removed = true;
	}
	
	public boolean removed() {
		return removed;
	}
	
	int aliveTime = 0;
	public void update() {
		aliveTime++;
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
	
	public void render() {
		if(glowType == 0) {
			Game.instance.get2DGraphics().drawImage(Images.ARROW_SET_GLOW_GREEN[arrowId], (int)x, (int)y, width, height, null);
		} else {
			Game.instance.get2DGraphics().drawImage(Images.ARROW_SET_GLOW_RED[arrowId], (int)x, (int)y, width, height, null);
		}
	}
	
}
