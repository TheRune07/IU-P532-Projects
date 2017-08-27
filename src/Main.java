import java.awt.Color;

import javax.swing.JFrame;


public class Main {
	public static void main(String args[])
	{
		final int FRAME_WIDTH = 1920;
		final int FRAME_HEIGHT = 1030;
		JFrame frame = new JFrame();
		frame.setSize(1920, 1030);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Breakout!");
		
		Bean bean = new Bean();
		Breakout breakout = new Breakout(bean);
		breakout.setSize(FRAME_WIDTH,FRAME_HEIGHT);
		bean.setFrameWidth(FRAME_WIDTH);
		bean.setFrameHeight(FRAME_HEIGHT);
		frame.add(breakout);
		//frame.setBackground(Color.YELLOW);

		frame.setVisible(true);
		breakout.startGame();
	}
}
