package demo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.Serializable;

import javax.swing.JButton;

public class Pause implements Controls, ActionListener,Serializable {
	JButton pause;
	//Game game; Thread thread;
	public Pause() {
		//this.game = game;
		//this.thread = thread;
		pause = new JButton("Pause");
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("action performed");
		Game.running = false;
		Game.clock.timer.stop();
		
		
	}


	@Override
	public JButton getButton() {
		// TODO Auto-generated method stub
		return pause;
	}

}
