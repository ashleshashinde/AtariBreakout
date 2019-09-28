package demo;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlPanel extends JPanel implements ActionListener, Serializable{
	JButton restartButton,undoButton,replayButton,changeLayoutButton,saveButton,loadButton, startButton, pauseButton;
	Controls pause,start,changeLayout,save,load,undo, replay, restart;
	JPanel north,south, center;
	
	Game game;
	
	public ControlPanel()//Game game,Thread thread)
	{
		//pause = new JButton("Pause");
		/*changeLayout = new JButton("ChangeLayout");
		undo = new JButton("Undo");
		replay = new JButton("Replay");
		save = new JButton("Save");
		load = new JButton("Load");
		*/
		north = new JPanel();
		south = new JPanel();
		center = new JPanel();
		pause = new Pause();
		start = new Start();
		changeLayout = new ChangeLayout(this);
		save = new Save();
		load = new Load(game);
		undo = new Undo();
		replay = new Replay();
		restart = new Restart();
		restartButton = restart.getButton();
		pauseButton = pause.getButton();
		startButton = start.getButton();
		changeLayoutButton = changeLayout.getButton();
		saveButton = save.getButton();
		loadButton = load.getButton();
		undoButton = undo.getButton();
		replayButton = replay.getButton();
		
		pauseButton.setFocusable(false);
		startButton.setFocusable(false);
		changeLayoutButton.setFocusable(false);
		saveButton.setFocusable(false);
		loadButton.setFocusable(false);
		undoButton.setFocusable(false);
		replayButton.setFocusable(false);
		restartButton.setFocusable(false);
		
		north.add(pauseButton);
		north.add(startButton);
		south.add(undoButton);
		add(north);
		center.add(changeLayoutButton);
		center.add(restartButton);
		add(saveButton);
		add(loadButton);
		south.add(replayButton);
		add(south);
		add(center);
		//add(changeLayout);
		//add(load);
		//add(save);
		//add(pause);
		//add(replay);
		//add(undo);
		//this.setFocusable(true);
		//pauseButton.addActionListener(Main.game);
		//pauseButton.setFocusable(false);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==pauseButton) {
			pause.actionPerformed(e);
		}
		if (e.getSource()==startButton) {
			start.actionPerformed(e);
		}
		else if (e.getSource()==changeLayoutButton) {
			changeLayout.actionPerformed(e);
		}
		else if (e.getSource()==saveButton) {
			//System.out.println("in Save");
			Game.running = false;
			save.actionPerformed(e);
			
		}
		else if (e.getSource()==loadButton) {
			//System.out.println("in load");
			load.actionPerformed(e);
		}
		else if (e.getSource()==undoButton) {
			//System.out.println("in undo");
			undo.actionPerformed(e);
		}
		else if (e.getSource()==replayButton) {
			//System.out.println("in replay");
			replay.actionPerformed(e);
		}
		else if (e.getSource()==restartButton) {
			//System.out.println("in restart");
			restart.actionPerformed(e);
		}
		
		
	}
	public void addButtons() {
		//add(changeLayoutButton,BorderLayout.CENTER);
		//add(pauseButton,BorderLayout.NORTH);
		//add(undo,BorderLayout.SOUTH);
		//add(startButton,BorderLayout.SOUTH);
		add(north,BorderLayout.NORTH);
		add(south,BorderLayout.SOUTH);
		add(center,BorderLayout.CENTER);
		//add(replay,BorderLayout.NORTH);
		add(saveButton,BorderLayout.EAST);
		add(loadButton,BorderLayout.WEST);
		//to add undo button
		//to add replay button
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
	
	

}
