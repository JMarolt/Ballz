package Map;

import java.awt.Color;
import java.awt.Graphics;

import Miscellaneous.Constants;

public class Block {

	private Tile location;
	private int score;
	private int width, height;
	
	private int x;
	private int y;
	
	public Block(Tile location, int score, int width, int height) {
		this.location = location;
		this.score = score;
		this.width = width;
		this.height = height;
	}
	
	public static int createRandomScore(int round) {
		int chance = (int)(Math.random()*4) + 1;
		if(chance == 4) {
			return 2*round;
		}else {
			return round;
		}
	}
	
	public void update() {
		
	}
	
	public void init() {
		x = location.getX() + ((Constants.TILE_LENGTH - Constants.BLOCK_LENGTH) / 2);
		y = location.getY() + ((Constants.TILE_LENGTH - Constants.BLOCK_LENGTH) / 2);
	}
	
	public void draw(Graphics g) {
		//Graphics2D g2d = (Graphics2D)g;
		g.setColor(Color.red);
		g.fillRect(location.getX() + ((Constants.TILE_LENGTH - Constants.BLOCK_LENGTH) / 2), location.getY() + ((Constants.TILE_LENGTH - Constants.BLOCK_LENGTH) / 2), width, height);
		g.setColor(Color.white);
		g.drawString(score + "", location.getX() + (width/2), location.getY() + (height/2));
	}

	public Tile getLocation() {
		return location;
	}

	public void setLocation(Tile location) {
		this.location = location;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}
