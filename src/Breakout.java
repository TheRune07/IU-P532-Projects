import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Breakout extends JPanel {

	public static Graphics2D g2d = null;
	static boolean gameIsOn = true;
	static int win = 0;
	
	Ball ball;
	Paddle paddle;
	Brick brick;
	Clock clock;
	JButton replay, undo, pause, resume;
	static Stack<Ball> ballObjects;
	static Stack<Paddle> paddleObjects;
	static Stack<Clock> clockObjects;
	static Stack<Brick> brickObjects;
	int breakLoop = 0;

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
		replay = new JButton("Replay");
		replay.setFocusable(false);
		undo = new JButton("undo");
		undo.setFocusable(false);
		pause = new JButton("Pause");
		pause.setFocusable(false);
		resume = new JButton("Resume");
		resume.setFocusable(false);
		this.add(replay);
		this.add(undo);
		this.add(pause);
		this.add(resume);
		ballObjects = new Stack<Ball>();
		paddleObjects = new Stack<Paddle>();
		clockObjects = new Stack<Clock>();
		brickObjects = new Stack<Brick>();
		
		this.ball.registerBall();
		this.clock.registerClock();
		
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g2d = (Graphics2D) g;
		paddle.draw(g2d);
		g2d.setColor(Color.YELLOW);
		
		ball.draw(g2d);
		
		g2d.setColor(Color.red);
		g.setFont(new Font("TimesRoman", Font.BOLD, 20));
		clock.draw(g2d);
		
		g2d.setColor(Color.ORANGE);
		brick.draw(g2d);
		
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
	
	public void startGame(Ball ball, Paddle paddle, Brick brick, Clock clock)
	{		
		pause.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				breakLoop = 1;
			}
		});
		
		
		
		resume.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			//	startGame() with current Instances;
				//startGame(ball, paddle, brick, clock);
			}
		});
		
		undo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				breakLoop = 1;
				//popAll()
			}
		});
		
		replay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				breakLoop = 1;
				/*
				 for stack size:
					startGame(ball, paddle, brick, clock);
					and set breakLoop to 1;
				*/
			}
		});
		
		while(gameIsOn)
		{
			ball.moveBall();
			brick.brickCollide(ball);
			storeInstance(ball, paddle, clock, brick);	//clone objects before calling this
			BreakoutObservable observable = new BreakoutObservable(paddle);
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
			
			if(breakLoop == 1)
			{
				break;
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
				if(brick.getBricksX()[i][j] != -1)
				{
					return false;
				}
			}
		}
		return true;
	}
	
	
	public void storeInstance(Ball ball, Paddle paddle, Clock clock, Brick brick)
	{
		Ball cloneBall = new Ball(ball);
		Paddle clonePaddle = new Paddle(paddle);
		Brick cloneBrick = new Brick(brick);
		Clock cloneClock = new Clock(clock);
		ballObjects.push(cloneBall);
		paddleObjects.push(clonePaddle);
		clockObjects.push(cloneClock);
		brickObjects.push(cloneBrick);
	}
	
	
}
