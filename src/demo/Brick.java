package demo;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;

public class Brick implements Drawable,Cloneable,Serializable
{
Behavioral brickMove;
 Game game;
 int x = 1000,y=300;
 int h= 30, w =30;
 public static boolean brickBlast = false;
 public static Stack<Drawable> brickUndo ;
 public static ArrayList<Drawable> brickReplay ;
	
 public Brick(Game game) {
		this.game= game;
		brickMove = new BrickMove(this,game);
		brickUndo = new Stack<Drawable>();
		brickReplay = new ArrayList<Drawable>();
	}
 public void draw(Graphics2D g) {
	    g.setColor(Color.gray);
		g.fillRect(x, y, h, w);
		
	}
 /*public Rectangle getCoordinates() {
		return new Rectangle(x, y, h, w);
	}*/
@Override
public void update() 
{
	brickMove.updateState();
	// TODO Auto-generated method stub
	
}
@Override
public int[] get() {
	// TODO Auto-generated method stub
	int[] coordinates = {x,y};
	return coordinates ;
}
@Override
public void set(int x, int y) {
	h = x;
	w = y;
	
	// TODO Auto-generated method stub
	
}
@Override
public int getWidth() {
	// TODO Auto-generated method stub
	return w;
}
@Override
public int getHeight() {
	// TODO Auto-generated method stub
	return h;
}

public static void setBrickBlast(boolean blast)
{
	brickBlast = blast;
}

public boolean getBrickBlast()
{
	return brickBlast;
}
@Override
public Behavioral getBehavior() {
	// TODO Auto-generated method stub
	return brickMove;
}
@Override
public void saveState() {
	Drawable brick =null;
	try {
		brick = (Drawable) this.clone();
		
	} catch (CloneNotSupportedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	brickUndo.push(brick);
	brickReplay.add(brick);
	
	
	//System.out.println(brickUndo);
}
@Override
public Object clone() throws CloneNotSupportedException {
	return super.clone();
	
}
@Override
public void setStack(Stack<Drawable> stack) {
	// TODO Auto-generated method stub
	brickUndo = stack;
	
}
@Override
public void setQueue(ArrayList<Drawable> q) {
	// TODO Auto-generated method stub
	brickReplay = q; 
}
@Override
public ArrayList<Drawable> getQueue() {
	// TODO Auto-generated method stub
	return brickReplay;
}
@Override
public ArrayList<Integer> getClockQueue() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public Stack<Drawable> getStack() {
	// TODO Auto-generated method stub
	return brickUndo;
}
@Override
public Stack<Integer> getClockStack() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public void setClockStack(Stack<Integer> stack) {
	// TODO Auto-generated method stub
	//return null;
}
@Override
public void setClockQueue(ArrayList<Integer> stack) {
	// TODO Auto-generated method stub
	//return null;
}
}
