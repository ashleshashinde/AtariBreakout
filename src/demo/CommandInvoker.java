package demo;

import java.awt.event.ActionListener;
import java.io.Serializable;

public class CommandInvoker implements Serializable {
Command slot;
public void setCommand(Command command) 
{  
    slot = command; 
} 

public void invoke() 
{ 
    slot.execute(); 
} 
}

