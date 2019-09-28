package demo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends Thread{
	
	public static void main(String args[])throws InterruptedException 
	{
		JFrame frame = new JFrame("Game");
		JPanel sidepanel = new JPanel();
		JPanel bottompanel = new JPanel();
		
		
		//Thread thread = new Thread();
		ControlPanel controlpanel = new ControlPanel();//(game,thread);
		
		Game game = new Game(controlpanel);
		
		
		
		//clock.clock.setLocation(450, 0);
		//clock.setSize(800, 20);
		game.setSize(1000, 575);
		game.setLocation(0,20);
		game.setBackground(Color.black);
		controlpanel.setSize(500,50);
		bottompanel.add(controlpanel,BorderLayout.CENTER);
		frame.setTitle("Breakout");
		frame.add(game);
		sidepanel.add(game.clock.timeDisplay);
		frame.add(sidepanel,BorderLayout.LINE_START);
		frame.add(bottompanel,BorderLayout.PAGE_END);
		//frame.add(controlpanel,BorderLayout.PAGE_END);
		frame.setSize(1200, 750);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new JPanel(),BorderLayout.LINE_END);
		game.startGame(game);
		
		
		/*while (true) {
			game.move();
			game.repaint();		
			thread.sleep(10);
			if (game.gameOver) {
				//System.out.println(game.getWi);
				thread.sleep(500000); 
			}
			
		}*/
	}
}
