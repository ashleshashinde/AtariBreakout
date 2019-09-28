package demo;

import java.io.Serializable;

public class ClockReplay implements Command, Serializable{
	int clock;
	public void execute() {
		clock = Clock.clockReplay.get(Game.counter);
		Game.clock.set(clock,0);
		//System.out.println(Game.clock.get()[0]);
	}

}
