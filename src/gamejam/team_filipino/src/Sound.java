package gamejam.team_filipino.src;

import gamejam.team_filipino.src.utils.Log;

import java.applet.Applet;
import java.applet.AudioClip;


public class Sound {

	private AudioClip clip;
	
	public static Sound music_picard;
	public static Sound music_trekkin;
	public static Sound enter_game;
	public static Sound hit_note;
	public static Sound fail_note;
	
	public Sound(String file) {
		try {
			clip = Applet.newAudioClip(Sound.class.getResource(file));
		} catch(Exception e) {
			Log.error(e);
		}
	}
	
	public static void load() {
		Log.info("Loading sounds...");
		music_picard = new Sound("/sounds/music/Picard.wav");
		music_trekkin = new Sound("/sounds/music/Trekkin.wav");
		enter_game = new Sound("/sounds/Enter.wav");
		hit_note = new Sound("/sounds/Succeed.wav");
		fail_note = new Sound("/sounds/Fail.wav");
	}
	
	public void stop() {
		clip.stop();
	}
	
	public void play() {
		try {
			new Thread() {
				public void run() {
					clip.play();
				}
			}.start();
		} catch (Exception e) {
			Log.error(e);
		}
	}
}
