package gamejam.team_filipino.src.entities;

import gamejam.team_filipino.src.Game;
import gamejam.team_filipino.src.Images;
import gamejam.team_filipino.src.Sound;
import gamejam.team_filipino.src.screens.LostScreen;
import gamejam.team_filipino.src.utils.Vector2D;

public class Arrow {

	// Stores the position of the arrow.
	public Vector2D pos;
	// width of the arrow
	private int width = 32;
	// height of the arrow
	private int height = 32;
	
	// if the arrow is to be removed
	private boolean removed = false;
	// if the arrow was correctly hit by the player
	private boolean hit = false;
	// id used for direction (up, left, right, down)
	public int id;
	
	/**
	 * Arrow Constructor
	 * @param id : int : Arrow id (direction).
	 * @param pos : Vector2D : Position of arrow
	 */
	public Arrow(int id, Vector2D pos) {
		// Checks the id to make sure its valid.
		if(id < 0 || id > 3) {
			// a runtime exception will close the program because arrow id needs to be 0-3
			// the message is displayed in the console.
			throw new RuntimeException("Arrow cant be given an ID less than 0 or more than 3. Fix yo shit..");
		} else {
			this.id = id;
		}
		this.pos = pos;
	}
	
	/**
	 * Returns if the arrow is removed or not.
	 * @return removed
	 */
	public boolean removed() {
		return removed;
	}
	
	/**
	 * Returns if the arrow was hit by the player in time.
	 * @return hit
	 */
	public boolean hit() {
		return hit;
	}
	
	/**
	 * Flags the arrow for removal for next update.
	 */
	private void remove() {
		removed = true;
	}

	/**
	 * Updates the arrow position etc.
	 */
	public void update() {
		/**
		 * Moves the arrows according to their ID to different "lanes".
		 */
		if(id == 1) {
			pos.x = 50;
		} else if(id == 0) {
			pos.x = 108;
		} else if(id == 3) {
			pos.x = 160;
		} else if(id == 2) {
			pos.x = 210;
		}
		
		// moves arrows down
		pos.y += 2.5;
		
		// If the arrow is past the red line
		if(pos.y >= 245) {
			hit = false;
			Picard.portraitIndex = 2;
			remove();
			Game.instance.lives--;
			Game.instance.combo = 0;
		} else {
			switch(id) {
			case 0: // UP
				if(Game.instance.input.up.clicked) {
					// checks if the arrow is between the green and red bar.
					if((pos.y + (height / 2)) >= 195 && (pos.y + (height / 2)) <= 235) { 
						Game.instance.score += 20;
						Game.instance.combo++;
						Sound.hit_note.play();
						hit = true;
						if(Picard.animationIndex == -1) {
							Picard.animationIndex = 0;
						}
						Picard.portraitIndex = 1;
						remove();
					} else { // else they missed it
						Game.instance.combo = 0;
						Sound.fail_note.play();
					}
				}
				break;
			case 1: // LEFT
				if(Game.instance.input.left.clicked) {
					// checks if the arrow is between the green and red bar.
					if((pos.y + (height / 2)) >= 195 && (pos.y + (height / 2)) <= 235) {
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
					// checks if the arrow is between the green and red bar.
					if((pos.y + (height / 2)) >= 195 && (pos.y + (height / 2)) <= 235) {
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
					// checks if the arrow is between the green and red bar.
					if((pos.y + (height / 2)) >= 195 && (pos.y + (height / 2)) <= 235) {
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
		// Checks if the player is out of lives.
		if(Game.instance.lives == 0) {
			Game.instance.setScreen(new LostScreen(Game.instance));
		}
		// Prevents the user from gaining more than 10 lives and controls combo.
		if(Game.instance.combo >= 10) {
			if(Game.instance.lives < 10) {
				Game.instance.lives++;
			} else {
				Game.instance.score += 50;
				Game.instance.combo = 0;
			}
		}
	}
	
	/**
	 * Renders the arrow.
	 */
	public void render() {
		Game.instance.get2DGraphics().drawImage(Images.ARROW_SET[id], (int)pos.x, (int)pos.y, width, height, null);
	}
	
}
