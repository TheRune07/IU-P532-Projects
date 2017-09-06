import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;

public class Paddle implements KeyListener, Sprite
{
	static int px = 900;
	static int py = 970;
	static final int PADDLE_WIDTH = 150;
	static final int PADDLE_HEIGHT = 20;
	Image paddle;
	
	Paddle(Image paddle, int px, int py)
	{
		this.paddle = paddle;
		Paddle.px = px;
		Paddle.py = py;
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int key = arg0.getKeyCode();
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
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.drawImage(paddle, Paddle.px, Paddle.py, PADDLE_WIDTH, PADDLE_HEIGHT, new Breakout());
	}
	
	
}
