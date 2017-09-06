import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;

public class Paddle implements KeyListener, Sprite
{
	int px = 900;
	int py = 970;
	final int PADDLE_WIDTH = 150;
	final int PADDLE_HEIGHT = 20;
	Image paddle;
	Paddle clonePaddle;
	
	Paddle(Image paddle, int px, int py)
	{
		this.paddle = paddle;
		this.px = px;
		this.py = py;
	}
	
	Paddle(Paddle paddle)
	{
		clonePaddle = paddle;
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
		g2d.drawImage(paddle, px, py, PADDLE_WIDTH, PADDLE_HEIGHT, new Breakout());
	}
	
	int getPx()
	{
		return px;
	}
	
	int getPy()
	{
		return py;
	}
	
	void setPx(int x)
	{
		px = x;
	}
	
	void setPy(int y)
	{
		py = y;
	}
	
	int getPaddleWidth()
	{
		return PADDLE_WIDTH;
	}
	
	int getPaddleHeight()
	{
		return PADDLE_HEIGHT;
	}

	
	
}
