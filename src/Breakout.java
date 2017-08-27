import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
		this.addKeyListener(new BreakoutListener());
		setFocusable(true);
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g2d = (Graphics2D) g;
		g2d.drawImage(bean.getPaddle(), bean.getPx(), bean.getPy(), bean.getPaddleWidth(), bean.getPaddleHeight(), this);
		g2d.setColor(Color.YELLOW);
		g2d.drawImage(bean.getBall(), bean.getBx(), bean.getBy(), bean.getBallWidth(), bean.getBallHeight(), this);
		g2d.setColor(Color.red);
		g2d.drawString(bean.getTime(), 1850, 20);
	}
	
	public void startGame()
	{
		Ball ball = new Ball();
		ball.registerBall();
		
		Clock clock = new Clock();
		clock.registerClock();
		
		while(bean.getGameIsOn())
		{
			ball.moveBall(bean);
			checkCollision();
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
		System.out.println(bean.getPx());
		System.out.println("game over");
	}
	
	public void registerObserver(Observer obs){
		n.addObserver(obs);
	}
	
	public void unregisterObserver(Observer obs){
		n.removeObserver(obs);
	}
	
	
	public boolean collidePaddle()
	{
		if((bean.getBx() >= bean.getPx()) && (bean.getBx() <= bean.getPx() + bean.getPaddleWidth())
				&& (bean.getBy()+bean.getBallHeight() >= bean.getPy()) && ( bean.getBy() <= bean.getBy() + bean.getPaddleHeight()))
			return true;
		return false;
	}
	
	public void checkCollision()
	{
		if(collidePaddle())
		{/*
			if((bean.getPx()<=0))
				bean.setPx(0);
			if(bean.getPx()+bean.getPaddleWidth() >= 1920)
				bean.setPx(1920-bean.getPaddleWidth());
			bean.setMoveX(bean.getMoveX());*/
			bean.setMoveY(-1);
		}
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
	
	public class BreakoutListener extends KeyAdapter {
		
		@Override
		public void keyPressed(KeyEvent ke) {
			int key = ke.getKeyCode();
			if(bean.getPx() != 0)
			{
				if (key == 37) {
					bean.setPx(bean.getPx() - 50);
				}
			}
			if(bean.getPx() != 1750)
			{
				if (key == 39) {
					bean.setPx(bean.getPx() + 50);
				}
			
			}
		}
	}

}
