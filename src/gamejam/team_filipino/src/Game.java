package gamejam.team_filipino.src;

import gamejam.team_filipino.src.screens.Screen;
import gamejam.team_filipino.src.screens.SplashScreen;
import gamejam.team_filipino.src.utils.Log;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	public static Game instance;
	
	public static final String TITLE = "Star Trek: Break Dancing Beta";
	public static final int WIDTH = 818;
	public static final int HEIGHT = WIDTH / 12 * 9; // 12 : 9 ratio
	
	// Player score
	public int score = 0;
	// Player lives
	public int lives = 10;
	// Player combo (arrows hit in a row)
	public int combo = 0;
	
	// The actual width of the screen to draw on
	private int actualWidth;
	// The actual height of the screen to draw on
	private int actualHeight;
	
	// Frame for the game (Game window)
	public JFrame frame;
	// Game screen (Splash, home etc.)
	private Screen screen;
	// The 2D Graphics object (For drawing shit)
	private Graphics2D g2D;
	// Instance of input to check if keys are down
	public InputHandler input;
	
	// Determines if program running
	private boolean running = false;
	// Game thread
	private Thread gameThread;
	
	// Is the game launched as an applet? (Web)
	private boolean isApplet;
	
	public Game(boolean isApplet) {
		instance = this;
		this.isApplet = isApplet;
		frame = new JFrame(TITLE);
		frame.setSize(new Dimension(WIDTH, HEIGHT));
		if(!isApplet) frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exits program when frame is closed.
		frame.setLocationRelativeTo(null); // Positions the frame in the middle of the screen.
		frame.add(instance); // Adds the game (canvas) to the frame so we can draw 'n shit.
		frame.setVisible(true); // Makes the window visible.
	}
	
	/**
	 * Initializes the core game objects.
	 */
	private void init() {
		screen = new SplashScreen(this);
		input = new InputHandler(this);
		if(!isApplet) {
			actualWidth = WIDTH - (frame.getInsets().left + frame.getInsets().right);
			actualHeight = HEIGHT - (frame.getInsets().top + frame.getInsets().bottom);
		} else {
			actualWidth = 800;
			actualHeight = 567;
		}
	}
	
	/**
	 * Starts the game.
	 */
	public void start() {
		if(!running) {
			running = true;
			gameThread = new Thread(this, "Thread-Game");
			gameThread.start();
		} else {
			Log.warn("Attempted to reinitialize game thread when already running. Fix yo shit..");
		}
	}
	
	/**
	 * Stops the game.
	 */
	public void stop() {
		running = false;
		try {
			gameThread.join();
		} catch (InterruptedException e) {
			Log.error(e);
		}
	}
	
	public void run() {
		double nsPerUpdate = 1000000000.0 / 60; // Determines how many updates per second (60 here).
		long lastUpdateTime = System.nanoTime(); // Gets the current update time (in nanoseconds for accuracy)
		long lastTime = System.currentTimeMillis(); // This is used to update the FPS and UPS every second at bottom
		double unprocessedUpdates = 0; // The number of updates that need to be called this loop.
		
		int fps = 0; // guess..
		int ups = 0; // updates per second
		
		init();
		
		// Main game loop
		while(running) {
			long currentUpdateTime = System.nanoTime(); // gets the current update time (because it just started).
			unprocessedUpdates += (currentUpdateTime - lastUpdateTime) / nsPerUpdate; // sets the number of updates based on the time of last
																					// update and the current.
			lastUpdateTime = currentUpdateTime; // Updates the last update time to the current time so the loop works again
			
			// If there are updates needed.. then update
			while(unprocessedUpdates >= 1) {
				update();
				ups++;
				unprocessedUpdates -= 1;
			}
			
			// Render the game as fast as possible because YOLO?
			render();
			fps++;

			// heres the thing that updates the fps in game window title each second.
			// just checks if 1000ms (1 second) has passed
			if(System.currentTimeMillis() - lastTime > 1000) {
				lastTime += 1000;
				// Only update the title if the game is not an applet (because frames are not used on the Web applets are.
				if(!isApplet) {
					frame.setTitle(TITLE + "   FPS: " + fps + "   UPS: " + ups);
					fps = 0;
					ups = 0;
				}
			}
		}
	}
	
	/**
	 * Controls all updating for the game.
	 */
	public void update() {
		if(screen != null) {
			screen.update();
		}
		input.update();
	}
	
	/**
	 * Controls all rendering for the game.
	 */
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(3); // Creates 3 buffers to prevent screen from flickering.
			requestFocus(); // Requests focus (grabs mouse attention).
			return; // breaks out of this render call because we had to create the buffer strategy (basically buffers the stuff we draw)
		}
		
		Graphics g = bs.getDrawGraphics(); // Gets graphics from the buffer strategy.
		g2D = (Graphics2D)g; // Casts the basic graphics object into a 2D graphics object. (Has rendering hints(anti-aliasing))
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // adds anti aliasing to the g2D object.
		g2D.clearRect(0, 0, WIDTH, HEIGHT); // clears the screen
		
		if(screen != null) {
			screen.render();
		}
		
		g.dispose(); // disposes of graphics object resources
		g2D.dispose(); // disposes of 2d graphics object resources
		bs.show(); // shows the stuff in the buffer
	}
	
	/**
	 * Returns the actual width of the canvas (Space consumed by content after frame insets deducted).
	 * @return actualWidth
	 */
	public int getDrawWidth() {
		return actualWidth;
	}
	
	/**
	 * Returns the actual height of the canvas (Space consumed by content after frame insets deducted).
	 * @return actualHeight
	 */
	public int getDrawHeight() {
		return actualHeight;
	}
	
	/**
	 * Changes the screen for the game.
	 * @param screen
	 */
	public void setScreen(Screen screen) {
		this.screen = screen;
	}
	
	/**
	 * Returns the Graphics2D object for this class
	 * @return g2D
	 */
	public Graphics2D get2DGraphics() {
		return g2D;
	}
	
	public static void main(String[] args) {
		JOptionPane.showConfirmDialog(instance, "This game may take a few seconds to appear whilst sounds are loaded.", "Game notification", JOptionPane.PLAIN_MESSAGE, JOptionPane.WARNING_MESSAGE);
		Sound.load();
		Game game = new Game(false);
		game.start();
	}
}
