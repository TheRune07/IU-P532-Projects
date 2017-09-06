import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class BreakoutObservable extends Observable
{
	public static ArrayList<Observer> observers = new ArrayList<Observer>();
	
	public BreakoutObservable() {
		// TODO Auto-generated constructor stub
		
	}
	
	public void addObserver(Observer obs)
	{
		observers.add(obs);
	}
	
	public void removeObserver(Observer obs)
	{
		observers.remove(obs);
	}
	
	public int countObservers(){
		return observers.size();
	}
	
	public void notifyObservers(){
		for(int i = 0; i < observers.size(); i++){
			observers.get(i).update(this, null);
			Breakout breakout = new Breakout();
			breakout.repaint();
		}
	}
}
