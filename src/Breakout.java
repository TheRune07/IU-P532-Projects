import java.awt.Color;
import java.awt.Font;
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
		this.addKeyListener(new Paddle(bean));
		setFocusable(true);
		
		Brick b1 = new Brick();
		b1.initializeBricks(b);
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g2d = (Graphics2D) g;
		g2d.drawImage(bean.getPaddle(), bean.getPx(), bean.getPy(), bean.getPaddleWidth(), bean.getPaddleHeight(), this);
		g2d.setColor(Color.YELLOW);
		g2d.drawImage(bean.getBall(), bean.getBx(), bean.getBy(), bean.getBallWidth(), bean.getBallHeight(), this);
		g2d.setColor(Color.red);
		
		g.setFont(new Font("TimesRoman", Font.BOLD, 20));
		g2d.drawString(bean.getTime(), 1830, 24);
		g2d.setColor(Color.ORANGE);
		
		int[][] bricksX = bean.getBricksX();
		int[][] bricksY = bean.getBricksY();
		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < 19; j++)
			{
				if(bricksX[i][j] != -1 && bricksX[i][j] != -1)
				{
					g2d.setColor(Color.ORANGE);
					g2d.fillRect(bricksX[i][j], bricksY[i][j], bean.getBrickWidth(), bean.getBrickHeight());
				}
			}
		}
		
		if(!bean.getGameIsOn())
		{
			g2d.setColor(Color.RED);
			g2d.drawString("GAME OVER!", 870, 500);
		}
	}
	
	public void startGame()
	{
		Ball ball = new Ball(bean);
		ball.registerBall();
		
		Clock clock = new Clock();
		clock.registerClock();
		
		Brick brick = new Brick();
		
		while(bean.getGameIsOn())
		{
			ball.moveBall(bean);
			brickCollide();
			//brick.checkCollision(bean);
			
			n.notifyObservers();
			try {
				Thread.sleep(45);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			repaint();
		}
		System.out.println("game over");
	}
	
	public void registerObserver(Observer obs){
		n.addObserver(obs);
	}
	
	public void unregisterObserver(Observer obs){
		n.removeObserver(obs);
	}
	
	
	
	public boolean bottomCollision(int xBall, int yBall, int xBrick, int yBrick) 
	{
		if ((xBall >= xBrick) && (xBall <= xBrick + 75) && (yBall == yBrick + 20)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean topCollision(int xBall, int yBall, int xBrick, int yBrick) {
		if ((xBall >= xBrick) && (xBall <= xBrick + 75) && (yBall == yBrick - 25)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void brickCollide() 
	{
		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < 19; j++)
			{
				if(bottomCollision(bean.getBx(), bean.getBy(), bean.getBricksX()[i][j], bean.getBricksY()[i][j])) {
					bean.setMoveY(1);
					bean.setBricksX(i, j, -1);
					bean.setBricksY(i, j, -1);
				}
				
				if(topCollision(bean.getBx(), bean.getBy(), bean.getBricksX()[i][j], bean.getBricksY()[i][j])) {
					bean.setMoveY(-1);
					bean.setBricksX(i, j, -1);
					bean.setBricksY(i, j, -1);
				}
			}
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
	
	class Paddle extends KeyAdapter 
	{ 
		
		int px;
		int py;
		
		Paddle(Bean bean)
		{
			bean.setPx(900);
			bean.setPy(970);
		}
		
		@Override
		public void keyPressed(KeyEvent ke) 
		{
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
