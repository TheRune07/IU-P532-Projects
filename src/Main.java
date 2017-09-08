import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Main
{
	static Breakout breakout;
	
	public static void main(String args[])
	{
		final int FRAME_WIDTH = 1920;
		final int FRAME_HEIGHT = 1030;
		JFrame frame = new JFrame();
		frame.setSize(1920, 1030);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Breakout!");
		
		Image ballImage = new ImageIcon("C:\\Users\\kshitij\\Desktop\\soccerball.png").getImage();
		Image paddleImage = new ImageIcon("C:\\Users\\kshitij\\Desktop\\paddle.jpg").getImage();
		
		Ball ball = new Ball(ballImage, 800, 500, 1, 1);
		Paddle paddle = new Paddle(paddleImage, 900, 970);
		Brick brick = new Brick();
		Clock clock = new Clock();
		
		breakout = new Breakout(ball, paddle, brick, clock);
		breakout.setSize(FRAME_WIDTH,FRAME_HEIGHT);
		frame.add(breakout);
		//frame.setBackground(Color.YELLOW);

		frame.setVisible(true);
		breakout.startGame(ball, paddle, brick, clock);
		
	}
}
