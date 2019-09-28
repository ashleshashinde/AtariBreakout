package demo;

import java.io.Serializable;

public class BallUndo implements Command, Serializable{
	Drawable ball;
public void execute() {
	ball =  Ball.ballUndo.pop();
	Game.ball.set(ball.get()[0], ball.get()[1]);
}
}
