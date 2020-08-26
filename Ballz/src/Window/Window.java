package Window;

import java.awt.Dimension;

import javax.swing.JFrame;

import Map.Block;
import Map.Tile;
import Miscellaneous.Constants;

public class Window extends JFrame implements Runnable{

	private static final long serialVersionUID = 1L;

	private static String title = "Ballz";
	public static Tile[][] tiles;
	public static Block[][] blocks;
	private int round = 1;
	
	private boolean isRunning = true;
	private static Panel panel;
	private static Window window = null;

	public Window() {
		initializeWindow();
	}
	
	public void initializeWindow() {
		panel = new Panel();
		this.setTitle(title);
		this.setPreferredSize(new Dimension(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.add(panel);
		this.pack();
		this.setVisible(true);
	}
	
	public static Window getWindow() {
		if(Window.window == null) {
			Window.window = new Window();
		}
		
		return Window.window;
	}
	
	private void createTiles() {
		tiles = new Tile[7][13];
		for(int i = 0; i < 7; i++) {
			for(int k = 0; k < 13; k++) {
				tiles[i][k] = new Tile(i * Constants.TILE_LENGTH, k * Constants.TILE_LENGTH, Constants.TILE_LENGTH, Constants.TILE_LENGTH);
			}
		}
	}
	
	private void createBlocks() {
		blocks = new Block[7][13];
		for(int i = 0; i < 7; i++) {
			for(int k = 0; k < 13; k++) {
				if(k == 0) {
					blocks[i][k] = new Block(tiles[i][k], Block.createRandomScore(round), Constants.BLOCK_LENGTH, Constants.BLOCK_LENGTH);
				}
			}
		}
	}
	
	public void init() {
		createTiles();
		createBlocks();
	}
	
	public void update() {
		Window.panel.repaint();
	}

	@Override
	public void run() {
		while(isRunning) {
			update();
		}
	}
	
}
