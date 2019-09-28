package demo;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

//public class Clock extends JPanel{
public class Clock implements Drawable, Serializable, ActionListener,Cloneable
{

	private static final long serialVersionUID = 1L;
	Timer timer;
	Behavioral clockTick;
	JButton timeDisplay = new JButton();
	ActionEvent evt;
	int count,x,y;
	Clock clock;
	public static Stack<Integer> clockUndo ;
	public static ArrayList<Integer> clockReplay ;

	public Clock() 
	{
		/*
		 * jlabclock = new JLabel("Time"); jlabclock.setSize(100, 100);
		 * jlabclock.setVisible(true); setLayout(new FlowLayout()); add(jlabclock);
		 * setSize(100,100); ct= new ClockThread(this);
		 */

		timeDisplay.setBounds(450, 50, 100, 50);
		timeDisplay.disable();
		timeDisplay.setBorderPainted(false);
		clockTick = new ClockTick(this);
		count = 0;
		clockUndo = new Stack<Integer>();
		clockReplay = new ArrayList<Integer>();

	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() 
	{
		timer = new Timer(1000, new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				clockTick.updateState();
			}

		});
		timer.setInitialDelay(0);
		timer.start();

		// TODO Auto-generated method stub

	}

	@Override
	public int[] get() {
		int[] coordinates = {x};
		// TODO Auto-generated method stub
		return coordinates;
	}

	@Override
	public void set(int x, int y) 
	{
		count = x;
		String st = String.format("%02d:%02d", x / 60, x % 60);
		timeDisplay.setText(st);
		// TODO Auto-generated method stub

	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Behavioral getBehavior() {
		// TODO Auto-generated method stub
		return clockTick;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{

		// TODO Auto-generated method stub

	}
	public Object clone() throws CloneNotSupportedException{
		return super.clone();

	}
	public void saveState() {
		Drawable clock = null;
		try {
			clock  = (Drawable) this.clone();
			clockUndo.push(count);
			clockReplay.add(count);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
		}


	}

	@Override
	public void setStack(Stack<Drawable> stack) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setQueue(ArrayList<Drawable> q) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Drawable> getQueue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Integer> getClockQueue() {
		// TODO Auto-generated method stub
		return clockReplay;
	}

	@Override
	public Stack<Drawable> getStack() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stack<Integer> getClockStack() {
		// TODO Auto-generated method stub
		return clockUndo; 
	}

	
	@Override
	public void setClockStack(Stack<Integer> stack) {
		// TODO Auto-generated method stub
		clockUndo = stack;
	}

	@Override
	public void setClockQueue(ArrayList<Integer> q) {
		// TODO Auto-generated method stub
		clockReplay = q;
		
	}




}