package demo;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.Serializable;

import javax.swing.JButton;

public class ChangeLayout implements Controls,Serializable {
	JButton changeLayout;
	ControlPanel panel;
	public ChangeLayout(ControlPanel panel) {
		changeLayout = new JButton("ChangeLayout");
		this.panel =  panel;
	}

	@Override
	public JButton getButton() {
		// TODO Auto-generated method stub
		return changeLayout;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(panel.getLayout() instanceof BorderLayout ) {
			panel.setLayout(new FlowLayout());				
			panel.addButtons();
			//this.Height=700;

			
		}
		else if (panel.getLayout() instanceof FlowLayout) {
			panel.setLayout(new BorderLayout());
			panel.addButtons();
			//panel.Height = 650;
			
		}
		
	}
	

}
