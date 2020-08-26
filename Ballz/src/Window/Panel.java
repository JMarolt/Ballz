package Window;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import Miscellaneous.Constants;

public class Panel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public void paintComponent(Graphics g) {
		g.setColor(Constants.bgColor);
		g.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		for(int k = 0; k < Window.tiles.length; k++) {
			g.setColor(Color.white);
			g.fillRect(Window.tiles[k][0].getX(), Window.tiles[k][0].getY(), Window.tiles[k][0].getWidth(), Window.tiles[k][0].getHeight());
		}
		for(int i = 0; i < Window.blocks.length; i++) {
			for(int k = 0; k < Window.blocks[i].length; k++) {
				if(Window.blocks[i][k] != null) {
					Window.blocks[i][k].draw(g);
				}
			}
		}
	}

}
