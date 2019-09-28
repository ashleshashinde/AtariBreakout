package demo;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.Serializable;

public class BrickMove implements Behavioral,Serializable
{
	Drawable brick;
	Game game;
	boolean brickBlast;

	public BrickMove(Drawable brick, Game game) {
		this.brick = brick;
		this.game = game ;

	}
	@Override
	public void updateState() 
	{
		
			
		brick.set(0, 0);
		
		
	}

	@Override
	public boolean collide(int ballX, int ballY, Drawable ball) {
		// TODO Auto-generated method stub
		int[] coordinates = brick.get();
		int brickX = coordinates[0];
		int brickY = coordinates[1];
		if (ballX + ball.getWidth() >= brickX
				&& ballX <= brickX + brick.getWidth()
				&& ballY+ ball.getHeight() >= brickY
				&& ballY <= brickY + brick.getHeight()) {
			
			//System.out.println("Collideed");
			brickBlast = true;
			return true;
		    
		}
		return false;
	}
	@Override
	public void keyPressed(KeyEvent evt) {
		// TODO Auto-generated method stub
		
	}
	

}
