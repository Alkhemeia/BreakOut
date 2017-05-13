package de.hpi.javaide.breakout.elements;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

import de.hpi.javaide.breakout.Displayable;
import de.hpi.javaide.breakout.starter.Game;

/**
 * Blueprint for the Wall
 * 
 * @author Ralf Teusner and Tom Staubitz
 *
 */
//TODO die Wall wird aus Bricks gebaut.
public class Wall implements Displayable, Iterable<Brick> {
	
	/**
	 * Datastructure to keep the Bricks
	 */
	private ArrayList<Brick> wall = new ArrayList<>();;


	public Wall(Game game, int i, int j) {
		buildWall(game, i, j);
	}
	
	@Override
	public Iterator<Brick> iterator() {
		return wall.iterator();
	}
	/**
	 * Build the wall by putting the single bricks into their position
	 * Hint: You might want to use one or two for-loops
	 * 
	 * @param game
	 * @param columns
	 * @param rows
	 */
	private void buildWall(Game game, int columns, int rows) {
		int brickWidth = 75;
		int brickHeight = 25;
		
		for (int y = 0; y < rows; y++) {
			for (int x = 0; x < columns; x++) {
				wall.add(new Brick(game, new Point(brickWidth + (brickWidth * y), brickHeight + (brickHeight * x)), new Dimension(brickWidth, brickHeight)));		
			}
		}
	}
	@Override
	public void display() {
		for (Brick brick : wall) {
			if (brick.brickLifes > 0) {
				brick.display();
			}
		}
	}
}
