package demo;
import java.awt.event.ActionEvent;
import java.io.Serializable;

import javax.swing.JButton;

public class Start implements Controls,Serializable{
	JButton start;
	public Start() {
		start = new JButton("Resume");
		
	}

	@Override
	public JButton getButton() {
		// TODO Auto-generated method stub
		return start;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Game.running = true;
		Game.clock.timer.restart();
		//thread.notifyAll();
		//System.out.println("Start");
	}

}
