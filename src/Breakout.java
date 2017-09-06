import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Breakout extends JPanel {

	public static Graphics2D g2d = null;
	static boolean gameIsOn = true;
	static int win = 0;
	Image ballImage = new ImageIcon("C:\\Users\\kshitij\\Desktop\\soccerball.png").getImage();
	Image paddleImage = new ImageIcon("C:\\Users\\kshitij\\Desktop\\paddle.jpg").getImage();
	
	//Ball ball = new Ball(ballImage, 800, 500, 1, 1);
	Ball ball;
	Paddle paddle;
	Brick brick;
	Clock clock;
	BreakoutObservable observable = new BreakoutObservable();
	
	
	Breakout()
	{
				
	}
	Breakout(Ball ball, Paddle paddle, Brick brick, Clock clock)
	{
		this.ball = ball;
		this.paddle = paddle;
		this.brick = brick;
		this.clock = clock;
		this.addKeyListener(paddle);
		setFocusable(true);
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g2d = (Graphics2D) g;
		//paddle.draw(g2d);
		g2d.drawImage(paddleImage, Paddle.px, Paddle.py, 150, 20, this);
		g2d.setColor(Color.YELLOW);
		
		//ball.draw(g2d);
		g2d.drawImage(ballImage, ball.getBx(), ball.getBy(), 25, 25, new Breakout());	
		
		g2d.setColor(Color.red);
		g.setFont(new Font("TimesRoman", Font.BOLD, 20));
		//clock.draw(g2d);
		g2d.drawString(Clock.time, 1850, 24);
		
		g2d.setColor(Color.ORANGE);
		Brick brick = new Brick();
		//brick.draw(g2d);
		
		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < 19; j++)
			{
				if(Brick.bricksX[i][j] != -1 && Brick.bricksX[i][j] != -1)
				{
					g2d.setColor(Color.ORANGE);
					g2d.fillRect(Brick.bricksX[i][j], Brick.bricksY[i][j], 75, 10);
				}
			}
		}
		
		if(!gameIsOn)
		{
			g2d.setColor(Color.RED);
			g2d.drawString("GAME OVER!", 870, 500);
		}
		if(win == 1)
		{
			g2d.setColor(Color.RED);
			g2d.drawString("You are Victorious!", 870, 500);
		}
	}
	
	public void startGame()
	{		
		ball.registerBall();
		clock.registerClock();
		brick.initializeBricks();
		
		while(gameIsOn)
		{
			ball.moveBall();
			brick.brickCollide(ball);	
			observable.notifyObservers();
			
			if(checkWin())
			{
				gameIsOn = false;
				win = 1;
			}
			
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			repaint();
		}
		ball.unregisterBall();
		clock.unregisterClock();
	}

	public boolean checkWin()
	{
		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < 19; j++)
			{
				if(Brick.bricksX[i][j] != -1)
				{
					return false;
				}
			}
		}
		return true;
	}
	
	/*
	public static class Paddle extends KeyAdapter 
	{ 
		
		static int px = 900;
		static int py = 970;
		
		Paddle()
		{
			
		}
		
		@Override
		public void keyPressed(KeyEvent ke) 
		{
			int key = ke.getKeyCode();
			if(px != 0)
			{
				if (key == 37) {
					px = px - 50;
				}
			}
			if(px != 1750)
			{
				if (key == 39) {
					px = px + 50;
				}
			
			}
		}
	}*/
	
}
