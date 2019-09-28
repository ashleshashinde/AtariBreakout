package demo;

import java.awt.event.ActionEvent;
import java.io.Serializable;

import javax.swing.JButton;

public class Restart implements Controls , Serializable{

	JButton restart;
	public Restart() {
		restart = new JButton("Restart");
		
	}
	@Override
	public JButton getButton() {
		// TODO Auto-generated method stub
		return restart;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Game.running = true;
		Game.gameOver = false;
		Game.paddle.set(900, 400); 
		Game.brick.set(30, 30); 
		Game.ball.set(0, 0); 
		Game.clock.count = 0;
		
		
	}

}

