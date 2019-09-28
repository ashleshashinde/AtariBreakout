package demo;

import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;


public class SaveObject implements Serializable
{
	Stack<Drawable> ballUndo;
	ArrayList<Drawable> ballReplay;
	Stack<Drawable> sliderUndo;
	ArrayList<Drawable> sliderReplay;
	//ArrayList<Drawable> sliderReplay2;
	Stack<Drawable> brickUndo;
	ArrayList<Drawable> brickReplay;
	ArrayList<Integer> clockReplay;
	Stack<Integer> clockUndo;
	
	Drawable ball;
	Drawable paddle,brick;
	Clock clock;
	//Game game;
	
	
	public SaveObject()
	{
		ballUndo = Game.ball.getStack();
		ballReplay = Game.ball.getQueue();
		sliderUndo = Game.paddle.getStack();
		sliderReplay = Game.paddle.getQueue();
		brickUndo = Game.brick.getStack();
		brickReplay = Game.brick.getQueue();
		clockReplay = Game.clock.getClockQueue();
		clockUndo = Game.clock.getClockStack();
		this.ball =  Game.ball;
		this.paddle =  Game.paddle;
		this.clock = Game.clock;
		this.brick = Game.brick;
		//this.game = Game;
		
	}
	
	public void save()
	{
		try {
			SaveObject saveObject = new SaveObject();
			
			/*for(int i=0; i<saveObject.sliderReplay.size();i++)
            {
            	//System.out.println(sa);
            	System.out.println(saveObject.sliderReplay.get(i).getSliderX()+ " "+saveObject.sliderReplay.get(i).getSliderY());
            }*/
			
			
			FileOutputStream fos = new FileOutputStream("Game.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(saveObject);
			oos.close();
			fos.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void load(Game game)
	{
		try {
			SaveObject saveObject2 = new SaveObject();
			FileInputStream fis = new FileInputStream("Game.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            saveObject2 = (SaveObject)ois.readObject();
            //sliderReplay2 = (ArrayList) ois.readObject();
            
            /*for(int i=0; i<saveObject2.sliderReplay.size();i++)
            {
            	//System.out.println(sa);
            	System.out.println(saveObject2.sliderReplay.get(i).getSliderX()+ " "+saveObject2.sliderReplay.get(i).getSliderY());
            }*/
            
           /* ballReplay = saveObject2.ballReplay;
            ballUndo = saveObject2.ballUndo;
            sliderReplay = saveObject2.sliderReplay;
            sliderUndo = saveObject2.sliderUndo;
            clockReplay = saveObject2.clockReplay;
            brickReplay = saveObject2.brickReplay;
            brickUndo = saveObject2.brickUndo;*/
            
            Game.ball = saveObject2.ball;
            Game.paddle = saveObject2.paddle;
            Game.brick = saveObject2.brick;
            
            Game.paddle.setQueue(saveObject2.sliderReplay);
            Game.paddle.setStack(saveObject2.sliderUndo);
            
            Game.ball.setQueue(saveObject2.ballReplay);
            Game.ball.setStack(saveObject2.ballUndo);
            
            Game.clock.setClockQueue(saveObject2.clockReplay);
            Game.clock.setClockStack(saveObject2.clockUndo);
            
            Game.brick.setQueue(saveObject2.brickReplay);       
            Game.brick.setStack(saveObject2.brickUndo);
           
            //game.addActionListener((KeyListener) paddle);
            
            Game.paddleKeyListner = false;
            Game.clock.timer.stop();
            //Game.clock.count = saveObject2.clock.count;
            Game.clock.set(saveObject2.clock.count,0);
           Game.clock.timer.restart();
           
            
            
            //System.out.println(saveObject2.ball.getBallX());
 
            ois.close();
            fis.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

