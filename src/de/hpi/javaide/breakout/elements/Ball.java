package de.hpi.javaide.breakout.elements;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.text.Position;

import de.hpi.javaide.breakout.basics.Elliptic;
import de.hpi.javaide.breakout.basics.Vector;
import de.hpi.javaide.breakout.starter.Game;
import processing.core.PApplet;

/**
 * Blueprint for a Ball
 * 
 * @author Ralf Teusner and Tom Staubitz
 *
 */
//TODO neben dem Ergänzen der vom Interface erwarteten Methoden, 
//     sollte der Ball Eigenschaften wie Größe und Richtung mitbringen.
//     Richtung wird in der Regel als Vector definiert. 
//     Vermutlich sollte er die Richtung ändern können und sehr wahrscheinlich wird früher oder später 
//     jemand wissen wollen in welche Richtung er fliegt.
public class Ball extends Elliptic {
	
	public boolean ballLost = false;
	int posX;
	int posY;
	int dirX = 0;
	int dirY = 0;
	
	public Ball(Game game, Point position) {
		super(game, position, new Dimension(10, 10));
		this.posX = position.x;
		this.posY = position.y;
    setColor(150, 150, 150);
	}

	@Override
	public void display() {
	  if(!ballLost) {
  		game.ellipseMode(PApplet.CENTER);
  		game.noStroke();
  		game.fill(getR(), getG(), getB());
  		if(dirX == 0 && dirY == 0) {
  		  this.posX = game.mouseX;
  		}
  		  game.ellipse(this.posX, this.posY, getWidth(), getHeight());
	  }
	}
	
	public int getX() {
		return this.posX;
	}
	
	public int getY() {
		return this.posY;
	}
	
	public void turnX() {
		this.dirX = this.dirX * -1;
	}
	
	public void turnY() {
		this.dirY = this.dirY * -1;
	}
	
	public void setDirX(int dirValue){
		this.dirX = dirValue;
	}
	
	public void setDirY(int dirValue){
		this.dirY = dirValue;
	}

	public void move() {
		System.out.println("X: " + posX + " | Y: " + posY);
		this.posX = this.posX + this.dirX * 3;
		this.posY = this.posY + this.dirY * 3;
	}
}
