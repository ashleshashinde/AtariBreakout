package demo;

import java.io.Serializable;

public class PaddleReplay implements Command, Serializable{
	Drawable paddle;
	public void execute() {
		paddle = Paddle.paddleReplay.get(Game.counter);
		Game.paddle.set(paddle.get()[0], paddle.get()[1]);
		//System.out.println("Paddle Co: "+Game.paddle.get()[1]);
	}

}
