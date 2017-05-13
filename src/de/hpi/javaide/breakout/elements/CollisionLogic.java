package de.hpi.javaide.breakout.elements;

import java.time.chrono.IsoChronology;

import de.hpi.javaide.breakout.starter.Game;

//TODO den Fehler unten haben wir absichtlich eingebaut, um zu zeigen, dass hier noch was getan werden muss.
//     Hier sollen alle Kollisionen geprüft werden. Trifft der Ball das Paddle.
//     Für jeden Stein in der Mauer: wurde er getroffen?
//     Erreicht der Ball den Spielfeld Rand.
//     Tipp: Schleifen könnten sich als hilfreich erweisen.
public class CollisionLogic {
	/**
	 * The constructor of this class is private to make sure that it is only used as a static class.
	 * - it cannot be instantiated,
	 * - it cannot hold a state,
	 * - it contains only static methods
	 */
	private CollisionLogic() {}
	
	/**
	 * This method provides a way to determine if the ball collides with any of the collidable elements on the screen.
	 * Paddle, Bricks, ...
	 * 
	 * @param game
	 * @param ball
	 * @param paddle
	 * @param wall
	 */
	public static void checkCollision(Game game, Ball ball, Paddle paddle, Wall wall) {
		if (ball.getX() <= 0) {
			ball.setDirX(1);
		}
		if (ball.getX() >= game.width) {
			ball.setDirX(-1);
		}
		if (ball.getY() <= 0) {
			ball.setDirY(1);
		}
		if (ball.getY() >= game.height) {
			ball.ballLost = true;
			
		}
		checkPaddleCollision(ball, paddle);
		checkWallCollision(ball, wall);
	}
	
	public static void checkPaddleCollision(Ball ball, Paddle paddle) {
		int paddleRightEnd = paddle.getX() + (paddle.getWidth() / 2);
		int paddleLeftEnd = paddle.getX() - (paddle.getWidth() / 2);
		int paddleUpperEnd = paddle.getY() - (paddle.getHeight() / 2);
		int paddleBottomEnd = paddle.getY() + (paddle.getHeight() / 2);
		
		if (ball.getX() >= paddleLeftEnd && ball.getX() <= paddleRightEnd && ball.getY() >= paddleUpperEnd && ball.getY() <= paddleBottomEnd) {
			if(ball.getX() <= paddle.getX() && ball.getX() >= paddleLeftEnd) {
				ball.setDirX(-1);
			}
			
			if(ball.getX() >= paddle.getX() && ball.getX() <= paddleRightEnd) {
				ball.setDirX(1);
			}
			
			if(ball.getY() >= paddle.getY() && ball.getY() <= paddleBottomEnd) {
				ball.setDirY(1);
			}
			
			if(ball.getY() <= paddle.getY() && ball.getY() >= paddleUpperEnd) {
				ball.setDirY(-1);
			}
		}
		
	}
	
	public static void checkBrickCollision(Ball ball, Brick brick) {
    int brickRight = brick.getX() + (brick.getWidth() / 2);
    int brickLeft = brick.getX() - (brick.getWidth() / 2);
    int brickTop = brick.getY() - (brick.getHeight() / 2);
    int brickBottom = brick.getY() + (brick.getHeight() / 2);
    boolean collision = false;
    
    if (brick.brickLifes > 0) {
      if (ball.getX() >= brickLeft && ball.getX() <= brickRight && ball.getY() >= brickTop && ball.getY() <= brickBottom) {
        if(ball.getX() >= brickLeft && ball.getX() < brick.getX()) {
          ball.setDirX(-1);
          collision = true;
        }
        if(ball.getX() >= brickRight && ball.getX() > brick.getX()) {
          ball.setDirX(1);
          collision = true;
        }
        if(ball.getY() <= brickBottom && ball.getY() > brick.getY()) {
          ball.setDirY(1);
          collision = true;
        }
        if(ball.getY() >= brickTop && ball.getY() < brick.getY()) {
          ball.setDirY(-1);
          collision = true;
        }
        
        if(collision == true) {
          brick.loseLife();
          collision = false;
        }
      } 
    }
	}
	
	public static void checkWallCollision(Ball ball, Wall wall) {
		for (Brick brick : wall) {
			checkBrickCollision(ball, brick);
		}
	}
}
