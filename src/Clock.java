import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class Clock implements Observer{

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		Bean bean = (Bean) arg1;
		Date date = new Date();
		String time = date.toString();
		time = time.substring(11, 19);
		bean.setTime(time);
	}
	
	public void registerClock()
	{
		Breakout b = new Breakout();
		b.registerObserver(this);
	}
	
	public void unregisterClock()
	{
		Breakout b = new Breakout();
		b.unregisterObserver(this);
	}
	
}
