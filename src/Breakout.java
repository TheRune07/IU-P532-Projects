import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class Breakout extends JPanel {

	public static Bean bean = new Bean();
	private static int bx = 0, by = 0, px = 0, py = 0;
	private int BALL_WIDTH = 0, BALL_HEIGHT = 0, PADDLE_WIDTH = 0, PADDLE_HEIGHT = 0;
	public static Graphics2D g2d = null;
	static Object gra = new Object();
	Notifier n = new Notifier();	
	public static ArrayList<Observer> observers = new ArrayList<Observer>();
	
	
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
	//	gra = (Object)g;
		g2d.drawImage(bean.getPaddle(), px, py, PADDLE_WIDTH, PADDLE_HEIGHT, this);
		g2d.setColor(Color.YELLOW);
		g2d.fillOval(bean.getBx() - bean.getMoveX(), bean.getBy() - bean.getMoveY(), bean.getBallWidth(), bean.getBallHeight());
		g2d.drawImage(bean.getBall(), bean.getBx(), bean.getBy(), bean.getBallWidth(), bean.getBallHeight(), this);
		
	}
	
	public void startGame()
	{
		
		Ball b1 = new Ball();
		b1.registerBall(bean);
		
		while(bean.getGameIsOn())
		{
			b1.moveBall(bean);
			//checkPaddle
			//checkBrick
			n.notifyObservers();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			repaint();
		}
	}
	
	public void registerObserver(Observer obs){
		n.addObserver(obs);
	}
	
	class Notifier extends Observable 
	{
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
				observers.get(i).update(this, bean);
				repaint();
			}
		}
		
	}	
}
