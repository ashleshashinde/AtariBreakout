package demo;

import java.io.Serializable;

public class BrickReplay implements Command, Serializable{
	Drawable brick;
	public void execute() {
		brick = Brick.brickReplay.get(Game.counter);
		Game.brick = brick;
	}

}
