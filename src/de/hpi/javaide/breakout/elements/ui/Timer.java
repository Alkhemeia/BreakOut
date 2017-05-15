package de.hpi.javaide.breakout.elements.ui;

import de.hpi.javaide.breakout.basics.Font;
import de.hpi.javaide.breakout.basics.UIObject;
import de.hpi.javaide.breakout.starter.Game;

public class Timer extends UIObject {

	private int seconds;
	private int frame = 0;

	public Timer(Game game) {
		super(game);
		seconds = 60;
	}

	@Override
	public void display() {
		game.fill(255);
		game.textFont(Font.getFont16());
		game.text("Time left: " + seconds, game.width-150, game.height-80);

	}

	@Override
	public void update(String input) {
    this.frame++;
    if (this.frame > 30) {
      this.frame = 0;
      this.seconds--;
    }	
	}
	
	public int getTime() {
	  return this.seconds;
	}
}
