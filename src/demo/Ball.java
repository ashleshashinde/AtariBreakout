package demo;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JOptionPane;

public class Ball implements Drawable,Cloneable,Serializable{
	public static Stack<Drawable> ballUndo ;
	public static ArrayList<Drawable> ballReplay ;
	int ballX=0,ballY=0;
	///int ballMoveX = 2,y2 = 5,v=2;
	
	 Game game;
	 Behavioral moveBall; 
	 int ballDiameter = 30;
	// Behavioral paddle;

	public Ball(Game game,Behavioral paddleMove,Behavioral brickCollide,Drawable brick ) {
		this.game = game;
		moveBall = new BallMove(this,game, paddleMove, brickCollide, brick );
		ballUndo = new Stack<Drawable>();
		ballReplay = new ArrayList<Drawable>();
	}
	
/*
	public void moveBall(){
		if (x1 + x2 < 0)
			x2 = v;
		if (x1 + x2 > game.getWidth() - 30)
			x2 = -v;
		if (y1 + y2 < 0)
			y2 = v;
		if (y1 + y2 > game.getHeight() - 30)
			y2 = -v;
		if (collidePaddle()) {
			y2=-v;
		}
		if (game.brick.getCoordinates().intersects(getCoordinates())) {
			
			JOptionPane message =new JOptionPane();
			game.input = message.showConfirmDialog(game,"Game Over! Do you want to Start a New Game?");
			y1=0;
			x1=0;
			game.paddle.x1=20;
			
		}
		
		x1 = x1 + x2;
		y1 = y1 + y2;
	}
	public boolean collidePaddle() {
		if (game.paddle.getCoordinates().intersects(getCoordinates()))
		{
			return true;
		}
		return false;
	}
	public Rectangle getCoordinates() {
		return new Rectangle(x1, y1, 30, 30);
	}*/
	
	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.gray);
		g.fillOval(ballX, ballY, 30, 30);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		//System.out.println("ball update");
		moveBall.updateState();
		
	}

	@Override
	public int[] get() {
		// TODO Auto-generated method stub
		int[] coordinates = {ballX,ballY};
		return coordinates;
	}

	@Override
	public void set(int x,int y) {
		// TODO Auto-generated method stub
		ballX = x;
		ballY = y;
		//saveState();
		//System.out.println(ballUndo);
		
	}
	@Override
	public void saveState() {
		//Ball ball = (Ball) clone();
		//System.out.println(ball.get()[0]);
		try {
			Drawable ball = (Drawable) this.clone();
			ballUndo.push(ball);
			ballReplay.add(ball);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(ballUndo);
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
		
	}
	
	@Override
	public int getWidth() {
		return ballDiameter;
	}
	@Override
	public int getHeight() {
		return ballDiameter;
	}

	@Override
	public Behavioral getBehavior() {
		// TODO Auto-generated method stub
		return moveBall;
	}

	@Override
	public void setStack(Stack<Drawable> stack) {
		// TODO Auto-generated method stub
		ballUndo=stack;
		
	}

	@Override
	public void setQueue(ArrayList<Drawable> q) {
		// TODO Auto-generated method stub
		ballReplay = q;
		
	}

	@Override
	public ArrayList<Drawable> getQueue() {
		// TODO Auto-generated method stub
		return ballReplay;
	}

	@Override
	public ArrayList<Integer> getClockQueue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stack<Drawable> getStack() {
		// TODO Auto-generated method stub
		return ballUndo;
	}

	@Override
	public Stack<Integer> getClockStack() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setClockStack(Stack<Integer> stack) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setClockQueue(ArrayList<Integer> stack) {
		// TODO Auto-generated method stub
		
	}
	
	

}
