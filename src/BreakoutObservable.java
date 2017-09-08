import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class BreakoutObservable extends Observable
{
	public static ArrayList<Observer> observers = new ArrayList<Observer>();
	Paddle paddle;
	public BreakoutObservable(Paddle paddle) {
		// TODO Auto-generated constructor stub
		this.paddle = paddle;
	}
	
	public BreakoutObservable()
	{
		
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
		for(int i = 0; i < observers.size(); i++)
		{
			if(i == 0)
			{
				observers.get(i).update(this, paddle);
			}
			else{
			observers.get(i).update(this, paddle);
			}
			Breakout breakout = new Breakout();
			breakout.repaint();
		}
	}
}
