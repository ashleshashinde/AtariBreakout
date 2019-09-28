package demo;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public interface Behavioral {
public void updateState();
public boolean collide(int x,int y,Drawable drawable);
public void keyPressed(KeyEvent evt);

}
