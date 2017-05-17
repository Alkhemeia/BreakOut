package de.hpi.javaide.breakout.elements;

import java.awt.Dimension;
import java.awt.Point;

import de.hpi.javaide.breakout.basics.Font;
import de.hpi.javaide.breakout.basics.Rectangular;
import de.hpi.javaide.breakout.starter.Game;
import processing.core.PApplet;

//TODO wichtige Attribute: Größe, Position, Abstand der Bricks untereinander
//     Irgendwie muss ich herausbekommen ob der Stein noch existiert oder nicht.
public class Brick extends Rectangular {
	int brickLifes = 3;

	public Brick(Game game, Point position, Dimension dimension) {
		super(game, position, dimension);
		setColor(0, 255, 0);
	}

	@Override
	public void display() {
		game.rectMode(PApplet.CENTER);
		game.noStroke();
		game.fill(getR(), getG(), getB());
		game.rect(getX(), getY(), getWidth(), getHeight());
	}
	
	public void loseLife() {
		this.brickLifes--;
		setColor();
	}

	private void setColor() {
		int red = 255;
		int green = 255;
		int blue = 255;
		
		if (brickLifes == 2) {
			blue = 0;
		}
		else if (brickLifes == 1) {
			blue = 0;
			green = 0;
		}
		else if (brickLifes <= 0) {
			red = 0;
			green = 0;
			blue = 0;
		}
		else {
			red = 0;
			blue = 0;
		}
		setColor(red, green, blue);
	}

}
