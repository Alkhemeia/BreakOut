package de.hpi.javaide.breakout.elements;

import java.awt.Point;
import java.util.ArrayList;

import de.hpi.javaide.breakout.Displayable;
import de.hpi.javaide.breakout.Measureable;
import de.hpi.javaide.breakout.starter.Game;

//TODO hier werden wir sicher eine Collection brauchen um die Bälle unterzubringen.
//     Vermutlich werden wir wissen wollen wann das Depot leer ist.
//     Irgendwie müssen die Bälle an den Start gebracht werden.
public class BallDepot implements Displayable, Measureable {
	
	private ArrayList<Ball> balls = new ArrayList<>();
	Ball currentBall;
	
	public BallDepot(Game game) {
		// TODO Auto-generated constructor stub
		Point position = new Point(game.width / 2, game.height - 40);
		balls.add(new Ball(game, position));
		balls.add(new Ball(game, position));
		balls.add(new Ball(game, position));
		this.currentBall = this.balls.get(0);
	}

	@Override
	public int getX() {
		return currentBall.getX();
	}

	@Override
	public int getY() {
		return currentBall.getY();
	}

	@Override
	public int getWidth() {
		return currentBall.getWidth();
	}

	@Override
	public int getHeight() {
		return currentBall.getHeight();
	}

	@Override
	public void display() {
		currentBall.display();		
	}

	public boolean isEmpty() {
		for (Ball ball : balls) {
		    if (ball.ballLost == false)
		        return false;
		}
		return true;
	}

	public Ball dispense() {
		if (!isEmpty()) {
			for (Ball ball : balls) {
			    if (ball.ballLost == false) {
			    	return ball;
			    }
			}
		}
		//TODO: Anderen Fall sicherheitshalber irgendwie noch abfangen
		return null;
	}

}
