package demo;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import java.util.ResourceBundle.Control;


@SuppressWarnings("serial")
public class Game extends JPanel implements ActionListener, Serializable {
	
	private static final long serialVersionUID = 1L;
	static boolean running = true;
	static boolean paddleKeyListner = true;
	static boolean undoState = false;
	static boolean replayState = false;
	static boolean gameOver = false;
	static int counter ;
	CompositeReplay replay = new CompositeReplay();
	BallReplay breplay = new BallReplay();
	PaddleReplay preplay = new PaddleReplay();
	BrickReplay brreplay = new BrickReplay();
	ClockReplay creplay = new ClockReplay();
	CommandInvoker invoker = new CommandInvoker();

	//Paddle paddle ;
	//Drawable brick ;
	PaddleMove paddleMove;
	Behavioral brickMove ;
	public static Drawable ball,brick ,paddle;
	ControlPanel buttonpanel; 
	StoreObjectStates storeObject; 

	public static Clock clock ;//= new Clock();	
	
	ClockTick clockTick ;//= new ClockTick(clock);




	public Game(ControlPanel controlpanel) {
		paddle = new Paddle(this);
		brick = new Brick(this);
		paddleMove = (PaddleMove) paddle.getBehavior();
		brickMove = new BrickMove(brick,this);
		ball = new Ball(this,paddleMove,brickMove,brick);
		clock = new Clock();
		clockTick = new ClockTick(clock);
		
		
		buttonpanel = controlpanel;
		buttonpanel.pauseButton.addActionListener(this);
		buttonpanel.startButton.addActionListener(this);
		buttonpanel.changeLayoutButton.addActionListener(this);
		buttonpanel.saveButton.addActionListener(this);
		buttonpanel.loadButton.addActionListener(this);
		buttonpanel.undoButton.addActionListener(this);
		buttonpanel.replayButton.addActionListener(this);
		buttonpanel.restartButton.addActionListener(this);
		
		this.addKeyListener(paddleMove);

		this.setFocusable(true);
		
		storeObject = new StoreObjectStates();
		storeObject.currentDrawables(ball);
		storeObject.currentDrawables(brick);
		storeObject.currentDrawables(paddle);
		storeObject.currentDrawables(clock);
		
		buttonpanel.setGame(this);

	}
	public void move() {

		ball.update();
		
	

	}



	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		ball.draw(g2d);
		paddle.draw(g2d);
		brick.draw(g2d);

	}

	public void startGame(Game game) 
	{   //this.thread = thread;
		clock.update();
		while(true) {
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		//if (running && !undoState)
			while (running) {
				game.move();

				try {
					Thread.sleep(15);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (game.gameOver) {
					running = false;
					clock.timer.stop();
				}
				if (!game.paddleKeyListner) {
					this.addKeyListener((KeyListener) paddle);
					game.paddleKeyListner = true;
				}
				repaint();
//				if(undoState) {
//					//running = false;
//					repaint();
//					undoState = false;
//					
//					
//				}
				//
			}
			if(!running && undoState) {
				repaint();
				storeObject.storeObject();
				undoState = false;
				//this.addKeyListener(paddleMove);
				
			}
			if(!running && replayState) {
				JFrame frame = (JFrame) this.getTopLevelAncestor();
				frame.setTitle("Replaying");
				replay.add(breplay);
				replay.add(preplay);
				replay.add(brreplay);
				replay.add(creplay);
				invoker.setCommand(replay);
				Game.replayState = true;
				for (Game.counter = 0; Game.counter<Ball.ballReplay.size(); Game.counter++)
				{
					invoker.invoke();
					try {
						Thread.sleep(15);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					repaint();
				}
				Game.replayState = false;
				frame.setTitle("Breakout");
				//System.out.println("below repaint");
				//this.addKeyListener(paddleMove);
				
			}
		}
		
	}
	


	/*
	 * @Override public void keyTyped(KeyEvent e) { // TODO Auto-generated method
	 * stub
	 * 
	 * }
	 * 
	 * @Override public void keyPressed(KeyEvent e) { // TODO Auto-generated method
	 * stub System.out.println("Key pressed"); ((KeyListener) paddle).keyPressed(e);
	 * 
	 * }
	 * 
	 * @Override public void keyReleased(KeyEvent e) { // TODO Auto-generated method
	 * stub ((KeyListener) paddle).keyReleased(e);
	 * 
	 * }
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e.getSource()+"clicked");
		
		buttonpanel.actionPerformed(e);
		//this.addKeyListener((KeyListener) paddle);
		

	}
	
	
	
	

}


