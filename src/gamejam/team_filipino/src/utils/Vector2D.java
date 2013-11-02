package gamejam.team_filipino.src.utils;

public class Vector2D {
	
	public double x;
	public double y;
	
	public Vector2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Add vec2d to this vector.
	 * @param vec2d
	 */
	public void add(Vector2D vec2d) {
		x += vec2d.x;
		y += vec2d.y;
	}
	
	/**
	 * Subtracts vec2d from this vector.
	 * @param vec2d
	 */
	public void sub(Vector2D vec2d) {
		x -= vec2d.x;
		y -= vec2d.y;
	}
	
	/**
	 * Divides this vector by vec2d.
	 * @param vec2d
	 */
	public void divide(Vector2D vec2d) {
		x /= vec2d.x;
		y /= vec2d.y;
	}
	
	/**
	 * Multiplies this vector by vec2d.
	 * @param vec2d
	 */
	public void multiply(Vector2D vec2d) {
		x *= vec2d.x;
		y *= vec2d.y;
	}

}
