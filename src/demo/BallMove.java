package demo;
import java.awt.event.ActionEvent;

import java.awt.event.KeyEvent;
import java.io.Serializable;

import javax.swing.JOptionPane;

public class BallMove implements Behavioral,Serializable {
	
	Drawable ball;
	int x2 = 5,y2 = 5;//v=2;
	Game game;
	Behavioral paddleMove;
	Behavioral brickCollide;
	Drawable brick;
	public BallMove(Drawable ball, Game game,Behavioral paddleMove,Behavioral brickCollide,Drawable brick ) {
		this.ball = ball;
		this.game = game;
		this.paddleMove = paddleMove;
		this.brickCollide = brickCollide;
		this.brick = brick;
	}

	@Override
	public void updateState() {
		// TODO Auto-generated method stub
		int[] coordinates = ball.get();
		int x1 = coordinates[0];
		int y1 = coordinates[1];
		if (x1 + x2 < 0)
			x2 = -x2;
		if (x1 + x2 > game.getWidth() - 30)
			x2 = -x2;
		if (y1 + y2 < 0)
			y2 = -y2;
		if (y1 + y2 > game.getHeight() - 30)
			y2 = -y2;
		if (paddleMove.collide( x1+x2,y1+y2,ball)) {
			x2=-x2;
			//y2=-x2;
		}
		if (brickCollide.collide(x1+x2, y1+y2, ball)) {
			brick.update();
			
			game.gameOver = true;
			/*JOptionPane message =new JOptionPane();
			game.input = message.showConfirmDialog(game,"Game Over! Do you want to Start a New Game?");
			y1=0;
			x1=0;
			game.paddle.x1=20;*/
			
		}
		
		x1 = x1 + x2;
		y1 = y1 + y2;
		//System.out.println("x1 :"+ x1 +", y1:" +y1);
		ball.set(x1, y1);
		game.storeObject.storeObject();
	}

	@Override
	public boolean collide(int x, int y, Drawable drawable) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void keyPressed(KeyEvent evt) {
		// TODO Auto-generated method stub
		
	}

	
	

}
