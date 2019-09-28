package demo;
import java.io.Serializable;
import java.util.ArrayList;

public class StoreObjectStates implements Serializable{
	ArrayList<Drawable> drawables ;
	
	public StoreObjectStates() {
		drawables = new ArrayList<Drawable>();
	}
	
	public void currentDrawables(Drawable obj) {
		drawables.add(obj);
		
	}
	public void storeObject() {
		for (Drawable obj : drawables) {
			obj.saveState();
		}
	}
	
	/*public void getStoredObject() {
		for (Drawable obj : drawables) {
			obj.popState();
		}
	}*/
	

}
