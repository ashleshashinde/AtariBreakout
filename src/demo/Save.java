package demo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;

public class Save implements Controls, ActionListener,Serializable {
	JButton save;
	
	public Save() {
		//this.game = game;
		//this.thread = thread;
		save = new JButton("Save");
	}
	@Override
	public JButton getButton() {
		// TODO Auto-generated method stub
		return save;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("in Save");
		SaveObject saveObj = new SaveObject();		
		saveObj.save();
		
	}

}

