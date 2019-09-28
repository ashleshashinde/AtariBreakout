package demo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CompositeUndo implements Command, Serializable{
	private List<Command> undoList = new ArrayList<Command>();
	public void execute() {
		for(Command cmd:undoList) 
        { 
            cmd.execute(); 
        } 
	}
	
	public void add(Command cmd) 
    { 
        undoList.add(cmd); 
    } 
       
    public void remove(Command cmd) 
    { 
        undoList.remove(cmd); 
    } 
}
