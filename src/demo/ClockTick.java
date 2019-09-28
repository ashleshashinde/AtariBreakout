package demo;

import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import javax.swing.Timer;

public class ClockTick implements Behavioral, Serializable
{
	Clock clock;
	
	public ClockTick(Clock clock2)
	{
		this.clock = clock2;
	}
	
	
	@Override
	public void updateState()
	{
		clock.count++;
		if (clock.count < 100000) {
			//TimeUnit.MILLISECONDS.sleep(1000);
			//String st = String.format("%02d:%02d", clock.count / 60, clock.count % 60);
			clock.set(clock.count,0);
			//System.out.println(Integer.parseInt(String.format("%02d:%02d", clock.count / 60, clock.count % 60)));
			
		} else {
			((Timer)(clock.evt.getSource())).stop();
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean collide(int x, int y, Drawable drawable) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void keyPressed(KeyEvent evt) {
		// TODO Auto-generated method stub
		
	}
	

}

