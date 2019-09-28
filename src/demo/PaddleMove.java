package demo;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;

public class PaddleMove implements Behavioral, KeyListener,Serializable{
	
	//int paddleX = 500;
	//int paddleY = 500;
	int moveX = 15;
	int moveY = 25;
	Drawable paddle;
	Game game;
	public PaddleMove(Drawable paddle, Game game) {
		this.paddle = paddle;
		this.game = game;
		//this.addActionListener(game);
		
	}


	

	@Override
	public void updateState() {
		// TODO Auto-generated method stub
		int[] coordiantes = paddle.get();
		//int x1 = coordiantes[0];
		int y1 = coordiantes[1];
		//System.out.println("in updateState");
		if (y1+moveY > 0 && y1+moveY< game.getHeight()-100) {
			y1=y1+moveY;
			//System.out.println(y1);
			paddle.set(900, y1);
			//System.out.println("State updated");
		}
		
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		moveY=0;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()== KeyEvent.VK_UP)
		{
			moveY=-5;
		}
		if(e.getKeyCode()== KeyEvent.VK_DOWN)
		{
			moveY=5;
		}
		//System.out.println("Acttion");
		updateState() ;
		
	}
	@Override
	public boolean collide(int ballX, int ballY, Drawable ball) {
		int[] coordiantes = paddle.get();
		int paddleX = coordiantes[0];
		int paddleY = coordiantes[1];
		int ballWidth = ball.getWidth();
		
		if (ballX + ballWidth >= paddleX
				&& ballX <= paddleX + paddle.getWidth()
				&& ballY + ballWidth >= paddleY
				&& ballY <= paddleY + paddle.getHeight()) {
			return true;
		}
		return false;
	}




	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}





	
	
	

}
