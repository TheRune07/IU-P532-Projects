import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class Breakout extends JPanel implements Runnable {

	Bean bean = new Bean();
	private static int bx = 0, by = 0, px = 0, py = 0;
	private int BALL_WIDTH = 0, BALL_HEIGHT = 0, PADDLE_WIDTH = 0, PADDLE_HEIGHT = 0;
	public Graphics2D g2d = null;
	
	Breakout()
	{
		
	}
	Breakout(Bean b)
	{
		bean = b;
		bx = bean.getBx();
		by = bean.getBy();
		px = bean.getPx();
		py = bean.getPy();
		BALL_WIDTH = bean.getBallWidth();
		BALL_HEIGHT = bean.getBallHeight();
		PADDLE_WIDTH = bean.getPaddleWidth();
		PADDLE_HEIGHT = bean.getPaddleHeight();	
	}
	
	public void paint(Graphics g)
	{
		g2d = (Graphics2D) g;
		g2d.drawImage(bean.getBall(), bean.getBx(), bean.getBy(), BALL_WIDTH, BALL_HEIGHT, this);
		g.drawImage(bean.getPaddle(), px, py, 80, 20, this);
	}
	
	public void startGame()
	{
		Breakout b = new Breakout();
		Thread ballThread = new Thread(b);
		ballThread.start();
		Ball b1 = new Ball();
		b1.registerBall(bean);
		repaint();
	}
	
	public void registerObserver(Observer obs){
		Notifier n = new Notifier();
		n.addObserver(obs);
	}
	
	class Notifier extends Observable 
	{
		ArrayList observers = new ArrayList<Observer>();
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
	
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
