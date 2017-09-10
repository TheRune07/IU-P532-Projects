import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Main
{
	static Breakout breakout;
	
	public static void main(String args[])
	{
<<<<<<< HEAD
		final int FRAME_WIDTH = 1200;
		final int FRAME_HEIGHT = 700;
		JFrame frame = new JFrame();
		frame.setSize(1200, 700);
=======
		final int FRAME_WIDTH = 1920;
		final int FRAME_HEIGHT = 1030;
		JFrame frame = new JFrame();
		frame.setSize(1920, 1030);
>>>>>>> 2f327cf9249d1efc12b7b00dc9db006057e46950
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Breakout!");
		
<<<<<<< HEAD
		Ball ball = new Ball(200, 200, 5, 5);
		Paddle paddle = new Paddle(600, 600);
=======
		Ball ball = new Ball(800, 500, 5, 5);
		Paddle paddle = new Paddle(900, 970);
>>>>>>> 2f327cf9249d1efc12b7b00dc9db006057e46950
		Brick brick = new Brick(1);
		Clock clock = new Clock();
		
		breakout = new Breakout(ball, paddle, brick, clock);
		breakout.setSize(FRAME_WIDTH,FRAME_HEIGHT);
		frame.add(breakout);
		//frame.setBackground(Color.YELLOW);

		frame.setVisible(true);
		breakout.startGame(ball, paddle, brick, clock);
		
	}
}
