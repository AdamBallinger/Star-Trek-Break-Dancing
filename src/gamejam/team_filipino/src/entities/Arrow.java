package gamejam.team_filipino.src.entities;

import gamejam.team_filipino.src.Game;
import gamejam.team_filipino.src.Images;
import gamejam.team_filipino.src.Sound;
import gamejam.team_filipino.src.screens.LostScreen;

public class Arrow {

	public double x, y;
	private int width = 32;
	private int height = 32;
	
	private boolean removed = false;
	private boolean hit = false;
	public int id;
	
	public Arrow(int id, int x, int y) {
		if(id < 0 || id > 3) {
			throw new RuntimeException("Arrow cant be given an ID less than 0 or more than 3. Fix yo shit..");
		} else {
			this.id = id;
		}
		this.x = x;
		this.y = y;
	}
	
	public boolean removed() {
		return removed;
	}
	
	public boolean hit() {
		return hit;
	}
	
	private void remove() {
		removed = true;
	}

	public void update() {
		/**
		 * Moves the arrows according to their ID to different "lanes".
		 */
		if(id == 1) {
			x = 50;
		} else if(id == 0) {
			x = 108;
		} else if(id == 3) {
			x = 160;
		} else if(id == 2) {
			x = 210;
		}
		
		// moves arrows down
		y += 2.5;
		
		// If the arrow is past the red line
		if(y >= 245) {
			hit = false;
			Picard.portraitIndex = 2;
			remove();
			Game.instance.lives--;
			Game.instance.combo = 0;
		} else {
			switch(id) {
			case 0: // UP
				if(Game.instance.input.up.clicked) {
					if((y + (height / 2)) >= 195 && (y + (height / 2)) <= 235) {
						Game.instance.score += 20;
						Game.instance.combo++;
						Sound.hit_note.play();
						hit = true;
						if(Picard.animationIndex == -1) {
							Picard.animationIndex = 0;
						}
						Picard.portraitIndex = 1;
						remove();
					} else {
						Game.instance.combo = 0;
						Sound.fail_note.play();
					}
				}
				break;
			case 1: // LEFT
				if(Game.instance.input.left.clicked) {
					if((y + (height / 2)) >= 195 && (y + (height / 2)) <= 235) {
						Game.instance.score += 20;
						Game.instance.combo++;
						Sound.hit_note.play();
						hit = true;
						if(Picard.animationIndex == -1) {
							Picard.animationIndex = 1;
						}
						Picard.portraitIndex = 1;
						remove();
					} else {
						Sound.fail_note.play();
					}
				}
				break;
			case 2: // RIGHT
				if(Game.instance.input.right.clicked) {
					if((y + (height / 2)) >= 195 && (y + (height / 2)) <= 235) {
						Game.instance.score += 20;
						Game.instance.combo++;
						Sound.hit_note.play();
						hit = true;
						if(Picard.animationIndex == -1) {
							Picard.animationIndex = 2;
						}
						Picard.portraitIndex = 1;
						remove();
					} else {
						Sound.fail_note.play();
					}
				}
				break;
			case 3: // DOWN
				if(Game.instance.input.down.clicked) {
					if((y + (height / 2)) >= 195 && (y + (height / 2)) <= 235) {
						Game.instance.score += 20;
						Game.instance.combo++;
						Sound.hit_note.play();
						hit = true;
						if(Picard.animationIndex == -1) {
							Picard.animationIndex = 3;
						}
						Picard.portraitIndex = 1;
						remove();
					} else {
						Sound.fail_note.play();
					}
				}
				break;
			}
		}
		
		// prevents score being a negative value.
		if(Game.instance.score < 0) {
			Game.instance.score = 0;
		}
		if(Game.instance.lives == 0) {
			Game.instance.setScreen(new LostScreen(Game.instance));
		}
		if(Game.instance.combo >= 10) {
			if(Game.instance.lives < 10) {
				Game.instance.lives++;
			}
			Game.instance.score += 50;
			Game.instance.combo = 0;
		}
	}
	
	public void render() {
		Game.instance.get2DGraphics().drawImage(Images.ARROW_SET[id], (int)x, (int)y, width, height, null);
	}
	
}
