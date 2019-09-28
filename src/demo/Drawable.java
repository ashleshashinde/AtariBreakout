package demo;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Stack;

public interface Drawable {
	
	
	public void draw(Graphics2D g);
	public void update();
	public int[] get();
	public void set( int x,int y);
	public int getWidth();
	public int getHeight();
	public Behavioral getBehavior();
	public Object clone() throws CloneNotSupportedException ;
	public void saveState();
	public void setStack(Stack<Drawable> stack);
	public void setQueue(ArrayList<Drawable> q);
	public ArrayList<Drawable> getQueue();
	public ArrayList<Integer> getClockQueue();
	public Stack<Drawable> getStack();
	public Stack<Integer> getClockStack();
	public void setClockStack(Stack<Integer> stack);
	public void setClockQueue(ArrayList<Integer> stack);
	
	
	

}
