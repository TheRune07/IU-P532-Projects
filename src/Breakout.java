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

public class Breakout extends JPanel implements ActionListener {

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
	static int breakLoop = 0; 
	int play = 0;
	
	
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
		pause.addActionListener(this);
		resume.addActionListener(this);
		undo.addActionListener(this);
		replay.addActionListener(this);
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
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
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
	
	public void startGame()
	{		
		while(true)
		{ System.out.println("");
		
			if(breakLoop == 0)
			{
				while(gameIsOn)
				{
					if(breakLoop == 1)
					{
						break;
					}
					ball.moveBall();
			
					brick.brickCollide(ball);
					storeInstance(ball, paddle, clock, brick);	//clone objects before calling this
					BreakoutObservable observable = new BreakoutObservable(paddle);
					observable.notifyObservers();
			
					if(checkWin(brick))
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
			}
			if(play == 1){ 
				break;
				}
		}
		
		if(breakLoop != 1)
		{
			ball.unregisterBall();
			clock.unregisterClock();
		}
	}
	
	

	public boolean checkWin(Brick brick)
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
		Ball cloneBall = null;
		Paddle clonePaddle = null;
		Brick cloneBrick = null;
		Clock cloneClock = null;
		try {
			cloneBall = (Ball) ball.clone();
			clonePaddle = (Paddle) paddle.clone();
			cloneBrick = (Brick) brick.clone();
			cloneClock = (Clock) clock.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ballObjects.push(cloneBall);
		paddleObjects.push(clonePaddle);
		clockObjects.push(cloneClock);
		brickObjects.push(cloneBrick);
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == pause)
		{
			breakLoop = 1;
		}
		
		else if(e.getSource() == resume)
		{
			breakLoop = 0;
			System.out.println("sadsad");
			repaint();
		}
		
		else if(e.getSource() == undo)
		{
				breakLoop = 1;
				//popAll()
		}
		
		else if(e.getSource() == replay)
		{
			breakLoop = 1;
			/*
			 for stack size:1
			 startGame(ball, paddle, brick, clock);
			 and set breakLoop to 1;
			*/
		}

	}	
}
