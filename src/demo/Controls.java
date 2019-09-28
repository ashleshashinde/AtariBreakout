package demo;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

public interface Controls {
	public JButton getButton();
	public void actionPerformed(ActionEvent e) ;

}
