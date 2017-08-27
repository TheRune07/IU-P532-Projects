import java.awt.Color;

import javax.swing.JFrame;


public class Main {
	public static void main(String args[])
	{
		JFrame frame = new JFrame();
		frame.setSize(1920, 1030);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Breakout!");
		
		Bean bean = new Bean();
		Breakout breakout = new Breakout(bean);
		breakout.setSize(1920,1030);
		frame.add(breakout);
		frame.setBackground(Color.YELLOW);

		frame.setVisible(true);
		breakout.startGame();
	}
}
