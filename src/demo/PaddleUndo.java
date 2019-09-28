package demo;

import java.io.Serializable;

public class PaddleUndo implements Command, Serializable {
	Drawable paddle;
	public void execute() {
		paddle =  Paddle.paddleUndo.pop();
		//Game.paddle = paddle;
		Game.paddleKeyListner = false;
		Game.paddle.set(paddle.get()[0], paddle.get()[1]);
		
	}

}
