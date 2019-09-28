package demo;

import java.awt.event.ActionEvent;
import java.io.Serializable;

import javax.swing.JButton;

public class Load implements Controls, Serializable{
	JButton load;
	Game game;
	public Load(Game game) {
		this.game = game;
		//this.thread = thread;
		load = new JButton("Load");
	}

	@Override
	public JButton getButton() {
		// TODO Auto-generated method stub
		return load;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		SaveObject saveObj = new SaveObject();		
		saveObj.load(game);
		
	}

}

