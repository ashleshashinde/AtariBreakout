package demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;

public class Undo implements Controls, ActionListener,Serializable {
	JButton undoButton;
	CompositeUndo undo = new CompositeUndo();
	BallUndo bundo = new BallUndo();
	PaddleUndo pundo = new PaddleUndo();
	BrickUndo brundo = new BrickUndo();
	CommandInvoker invoker = new CommandInvoker();
	//Game game; Thread thread;
	public Undo() {
		//this.game = game;
		//this.thread = thread;
		undoButton = new JButton("Undo");
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("action performed");
		Game.running=false;
		undo.add(bundo);
		undo.add(pundo);
		undo.add(brundo);
		invoker.setCommand(undo);
		invoker.invoke();
		Game.undoState = true;
	}


	@Override
	public JButton getButton() {
		// TODO Auto-generated method stub
		return undoButton;
	}

}
