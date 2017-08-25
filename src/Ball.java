import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

public class Ball implements Observer 
{

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
	public void registerBall(Bean bean)
	{
		Breakout b = new Breakout();
		
		b.registerObserver(this);
	}	

}
