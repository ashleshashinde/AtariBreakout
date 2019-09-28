package demo;

import java.io.Serializable;

public class BallReplay implements Command,Serializable{
Drawable ball;
public void execute() {
	ball = Ball.ballReplay.get(Game.counter);
	Game.ball.set(ball.get()[0], ball.get()[1]);
	//System.out.println("Ball Co: "+Game.ball.get()[0]);
}
}
