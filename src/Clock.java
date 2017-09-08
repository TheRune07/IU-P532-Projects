import java.awt.Graphics2D;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class Clock implements Observer, Sprite, Cloneable{

	String time = "";
	long startTime;
	Clock cloneClock;
	
	public Clock()
	{
		this.startTime =  System.nanoTime();
	}
	
	Clock(Clock clock)
	{
		cloneClock = clock;
	}
	
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();	
	}
	
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		Double timeElapsed = (System.nanoTime() - startTime) / 1000000000.0;
		time = timeElapsed.toString();
		time = time.substring(0, 6);
	}
	
	public void registerClock()
	{
		BreakoutObservable oberservable = new BreakoutObservable();
		oberservable.addObserver(this);
	}
	
	public void unregisterClock()
	{
		BreakoutObservable observable = new BreakoutObservable();
		observable.removeObserver(this);
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.drawString(time, 1850, 24);
		
	}
	
}
