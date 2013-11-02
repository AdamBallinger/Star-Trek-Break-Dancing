package gamejam.team_filipino.src.screens;

import gamejam.team_filipino.src.Game;
import gamejam.team_filipino.src.Images;
import gamejam.team_filipino.src.entities.Arrow;
import gamejam.team_filipino.src.entities.ArrowGlow;
import gamejam.team_filipino.src.entities.Picard;
import gamejam.team_filipino.src.utils.MathHelper;
import gamejam.team_filipino.src.utils.Vector2D;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

public class GameScreen extends Screen {

	// Stores the directional arrows displayed.
	private List<Arrow> arrows = new ArrayList<Arrow>();
	
	// Stores the glow effects from the arrows.
	private List<ArrowGlow> arrowsGlow = new ArrayList<ArrowGlow>();
	
	// Instance of the Picard sprite that dances.
	private Picard picard = new Picard();
	
	/**
	 * Screen for the game.
	 * @param game : Game : Instance of Game the screen is assigned too.
	 */
	public GameScreen(Game game) {
		super(game);
		game.score = 0;
		arrows.clear();
		arrowsGlow.clear();
	}
	
	int arrowTime = 0, arrowAliveTime = 0;
	double arrowTimeMin = 0, arrowTimeMax = 0;
	public void update() {
		if(game.input.escape.clicked) {
			game.setScreen(new HomeScreen(game));
		}
		
		// increments the amount of time since the last arrow was added.
		arrowTime++;
		arrowAliveTime++;
		
		if(arrowAliveTime <= MathHelper.getSeconds(10)) {
			arrowTimeMin = .3;
			arrowTimeMax = .8;
		} else if (arrowAliveTime >= MathHelper.getSeconds(25) && arrowAliveTime < MathHelper.getSeconds(50)) {
			arrowTimeMin = .3;
			arrowTimeMax = .6;
		} else if (arrowAliveTime >= MathHelper.getSeconds(60)) {
			arrowTimeMin = .22;
			arrowTimeMax = .35;
		}
		
		// Randomly determines a new arrow to be added to game. (0.3 , 0.1)
		if(arrowTime >= MathHelper.getSeconds(arrowTimeMax)) {
			if(rand.nextBoolean()) {
				arrows.add(new Arrow(rand.nextInt(4), new Vector2D(200, 25)));
			} else {
				if(arrowTime >= MathHelper.getSeconds(arrowTimeMin)) {
					arrows.add(new Arrow(rand.nextInt(4), new Vector2D(65, 25)));
				}
			}
			arrowTime = 0;
		}
		
		// Updates all arrows in the list and removes an arrow if it is due to be removed.
		for(int i = 0; i < arrows.size(); i++) {
			if(arrows.get(i).removed()) {
				if(arrows.get(i).hit()) {
					arrowsGlow.add(new ArrowGlow((int)arrows.get(i).pos.x, (int)arrows.get(i).pos.y, arrows.get(i).id, 0));
				} else {
					arrowsGlow.add(new ArrowGlow((int)arrows.get(i).pos.x, (int)arrows.get(i).pos.y, arrows.get(i).id, 1));
				}
				arrows.remove(i);
			} else {
				arrows.get(i).update();
			}
		}
		
		// Iterates through each glowing arrow in the list and updates it. will also check if it needs to be removed first
		// and will remove it if needed.
		for(int i = 0; i < arrowsGlow.size(); i++) {
			if(arrowsGlow.get(i).removed()) {
				arrowsGlow.remove(i);
			} else {
				arrowsGlow.get(i).update();
			}
		}
		
		// Updates Picard entity.
		picard.update();
	}
	
	public void render() {
		// Draws the main game interface
		game.get2DGraphics().drawImage(Images.GUI_BACKGROUND, 0, 0, game.getDrawWidth(), game.getDrawHeight(), null);
		game.get2DGraphics().setColor(new Color(199, 125, 1));
		game.get2DGraphics().fillRect(45, 302, 80, 24);
		game.get2DGraphics().setFont(new Font("Impact", Font.PLAIN, 32));
		game.get2DGraphics().setColor(Color.RED);
		game.get2DGraphics().drawString("Score: " + game.score, 52, 328);
		game.get2DGraphics().drawString("Lives: " + game.lives, 280, 60);
		game.get2DGraphics().drawString("Combo: " + game.combo + "x", 280, 90);
		game.get2DGraphics().drawImage(Images.GUI_ARROW_BOARD, 20, 20, 256, 256, null);
		
		// Draws the Picard portrait representing his mood.
		game.get2DGraphics().drawImage(Images.GUI_PICARD_MOOD[Picard.portraitIndex], 60, 335, 180, 180, null);
		
		// draws green line
		game.get2DGraphics().setColor(Color.GREEN);
		game.get2DGraphics().setStroke(new BasicStroke(3));
		game.get2DGraphics().drawLine(37, 195, 258, 195);
		
		// draws red line
		game.get2DGraphics().setColor(Color.RED);
		game.get2DGraphics().setStroke(new BasicStroke(3));
		game.get2DGraphics().drawLine(37, 240, 258, 240);
		
		// Draws all the arrows to the screen.
		for(int i = 0; i < arrows.size(); i++) {
			arrows.get(i).render();
		}
		
		// Draws all the glowing arrows to the screen.
		for(int i = 0; i < arrowsGlow.size(); i++) {
			arrowsGlow.get(i).render();
		}
		
		// Draws Picard.
		picard.render();
	}

}
