package demo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CompositeReplay implements Command, Serializable{
	private List<Command> replayList = new ArrayList<Command>();
	public void execute() {
		for(Command cmd:replayList) 
        { 
            cmd.execute(); 
        } 
	}
	
	public void add(Command cmd) 
    { 
        replayList.add(cmd); 
    } 
       
    public void remove(Command cmd) 
    { 
        replayList.remove(cmd); 
    } 

}
