import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Main
{
	static Breakout breakout;
	
	public static void main(String args[])
	{
//		final int FRAME_WIDTH = 1920;
//		final int FRAME_HEIGHT = 1030;
		JFrame frame = new JFrame();
		frame.setSize(Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT );
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Breakout!");
		
		Ball ball = new Ball(Constants.BALL_POS_X, Constants.BALL_POS_Y, Constants.BALL_VEL_X, Constants.BALL_VEL_Y);
		Paddle paddle = new Paddle(Constants.PADDLE_POS_X, Constants.PADDLE_POS_Y);
		Brick brick = new Brick();
		Clock clock = new Clock();
		
		breakout = new Breakout(ball, paddle, brick, clock);
		breakout.setSize(Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT);
		frame.add(breakout);
		//frame.setBackground(Color.YELLOW);

		frame.setVisible(true);
		breakout.startGame(ball, paddle, brick, clock);
		
	}
}
