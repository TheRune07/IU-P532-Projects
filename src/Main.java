import java.awt.Color;

import javax.swing.JFrame;

public class Main {
	public static void main(String args[])
	{
		JFrame frame = new JFrame();
		frame.setSize(1920, 1080);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Breakout!");
		
		Bean bean = new Bean();
		Breakout breakout = new Breakout(bean);
		breakout.setBackground(Color.YELLOW);
		frame.add(breakout);
		frame.setVisible(true);
		breakout.startGame();
	}
}
