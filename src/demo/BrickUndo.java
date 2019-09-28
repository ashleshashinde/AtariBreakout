package demo;

import java.io.Serializable;

public class BrickUndo implements Command, Serializable{
	Drawable brick;
	public void execute() {
		brick = Brick.brickUndo.pop();
		if(Brick.brickBlast) {
			Brick.setBrickBlast(false);;
		}
		Game.brick = brick;
	}

}
