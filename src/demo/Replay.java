package demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;

public class Replay implements Controls, ActionListener,Serializable {
	JButton replayButton;
	CompositeReplay replay = new CompositeReplay();
	BallReplay breplay = new BallReplay();
	PaddleReplay preplay = new PaddleReplay();
	BrickReplay brreplay = new BrickReplay();
	ClockReplay creplay = new ClockReplay();
	CommandInvoker invoker = new CommandInvoker();
	//Game game; Thread thread;
	public Replay() {
		//this.game = game;
		//this.thread = thread;
		replayButton = new JButton("Replay");
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("replay");
		Game.running = false;
		Game.replayState = true;
		//Game.clock.timer.stop();
	}


	@Override
	public JButton getButton() {
		// TODO Auto-generated method stub
		return replayButton;
	}

}
