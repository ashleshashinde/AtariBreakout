package demo;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;

public class Paddle implements Drawable, KeyListener,Cloneable,Serializable {
	Game game;
	int paddleX = 900;
	int paddleY = 400;
	int moveX = 10;
	int moveY = 10;
	final int PADDLE_WIDTH = 5;
	final int PADDLE_HEIGHT = 100;
	
	public static Stack<Drawable> paddleUndo ;
	public static ArrayList<Drawable> paddleReplay ;
	
	KeyEvent evt;
    Behavioral movePaddle;
    
	public Paddle(Game game) {
		this.game= game;
		movePaddle = new PaddleMove(this,game);
		paddleUndo = new Stack<Drawable>();
		paddleReplay = new ArrayList<Drawable>();
		
	}
	/*public void paint(Graphics2D g) {
		g.fillRect(x1, 500, 150, 10);
		
	}*/
	/*public void movePaddle() {
		if (x1+x2 > 0 && x1+x2< game.getWidth()-150) {
			x1=x1+x2;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		x2=0;
	}

	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()== KeyEvent.VK_LEFT)
		{
			x2=-v;
		}
		if(e.getKeyCode()== KeyEvent.VK_RIGHT)
		{
			x2= v;
		}
		movePaddle() ;
		
	}
	
	public Rectangle getCoordinates() {
		return new Rectangle(x1, 500, 150, 10);
	}*/
	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(Color.gray);
		g.fillRect(paddleX, paddleY, PADDLE_WIDTH, PADDLE_HEIGHT);
		
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		movePaddle.keyPressed(evt);
		
	}
	@Override
	public int[] get() {
		// TODO Auto-generated method stub
		int[] coordinates = {paddleX, paddleY};
		return coordinates ;
	}
	@Override
	public void set(int x, int y) {
		// TODO Auto-generated method stub
		paddleX = x;
		paddleY = y;
		
	}
	@Override
	public int getHeight() {
		return PADDLE_HEIGHT;
	}
	@Override
	public int getWidth() {
		return PADDLE_WIDTH;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	   // System.out.println("pressed");
		evt = e;
		update();
		
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("released");
		evt = e;
		update();
		
	}
	@Override
	public Behavioral getBehavior() {
		// TODO Auto-generated method stub
		return movePaddle;
	}
	@Override
	public void saveState() {
		// TODO Auto-generated method stub
		Drawable paddle = null;
		try {
			paddle = (Drawable) this.clone();
			
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		paddleUndo.push(paddle);
		paddleReplay.add(paddle);
		//System.out.println(paddleUndo);
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
		
	}
	@Override
	public void setStack(Stack<Drawable> stack) {
		// TODO Auto-generated method stub
		paddleUndo = stack;
		
	}
	@Override
	public void setQueue(ArrayList<Drawable> q) {
		// TODO Auto-generated method stub
		paddleReplay = q;
		
	}
	@Override
	public ArrayList<Drawable> getQueue() {
		// TODO Auto-generated method stub
		return paddleReplay;
	}
	@Override
	public ArrayList<Integer> getClockQueue() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Stack<Drawable> getStack() {
		// TODO Auto-generated method stub
		return paddleUndo;
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
