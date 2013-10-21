package gamejam.team_filipino.src.utils;

import java.util.logging.Level;

/**
 * Everything here is just used for easier and faster access to writing to the console because I am lazy and dont want to writee
 * System.out.println() every time.
 *
 */
public class Log {

	private static void out(Level lvl, String msg) {
		System.out.println("[" + lvl + "] " + msg);
	}
	
	public static void info(String msg) {
		out(Level.INFO, msg);
	}
	
	public static void warn(String warn) {
		out(Level.WARNING, warn);
	}
	
	public static void error(Exception e) {
		out(Level.SEVERE, e.getLocalizedMessage());
	}
	
}
