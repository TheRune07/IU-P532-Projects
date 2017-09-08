import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.Timer;


public class Clock implements Observer, Sprite, Cloneable,ActionListener{
	
	
    protected int clockSeconds =0;
	protected int clockMinutes = 0;
	protected Timer t;
	private int timerStartFlag = 0;
	protected int pauseFlag = 0;
	  
	Clock cloneClock;
	  
	public Clock() { 
	    t = new Timer(1000,this);	   
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
		
		if(timerStartFlag <= 0){
			t.start();
			timerStartFlag++;
		}
		
		
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
		
		// g2d.setColor(Color.GREEN);
		 //g2d.setFont(new Font("serif", Font.PLAIN,15));
		 //g2d.drawString((" mm"+ "  :   "+ " ss"), 30, 10);
		  
		 g2d.setColor(Color.GREEN);
		 g2d.setFont(new Font("serif", Font.BOLD,40));
		 g2d.drawString((""+clockMinutes+ " : "+ clockSeconds), 1800, 33);
		  	
	}




	  @Override
		public void actionPerformed(ActionEvent e) {
		  	if(pauseFlag == 0){
				if(clockSeconds == 59){
					clockMinutes++;
					clockSeconds = 0;
				}
				else{
					clockSeconds++;
				}
		  	}
			 	  
		}
	  	 	
}


	
	 
	    
		


