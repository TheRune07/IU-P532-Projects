import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Paddle implements KeyListener, Sprite, Cloneable
{
	int px = 600;
	int py = 600;
	final int PADDLE_WIDTH = 150;
	final int PADDLE_HEIGHT = 20;
	
	Paddle clonePaddle;
	
	Paddle(int px, int py)
	{
		this.px = px;
		this.py = py;
	}
	
	Paddle(Paddle paddle)
	{
		clonePaddle = paddle;
	}
	
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();	
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int key = arg0.getKeyCode();
		if(px != 0)
		{
			if (key == 37) {
				// moving the paddle left
				px = px - 50;
				
			}
		}
		if(px != 900)
		{
			if (key == 39) {
				// moving the paddle right
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
		g2d.setColor(Color.GREEN);
        g2d.fillRect(px,py,PADDLE_WIDTH,PADDLE_HEIGHT);
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
