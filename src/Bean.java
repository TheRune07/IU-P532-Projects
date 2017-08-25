import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;


public class Bean implements Serializable {
	
	private int bx;
	private int by;
	private int px;
	private int py;
	private Image ball;
	private Image paddle;
	private final int BALL_WIDTH = 50;
	private final int BALL_HEIGHT = 50;
	private final int PADDLE_WIDTH = 380;
	private final int PADDLE_HEIGHT = 20;
	
	public Bean()
	{
		bx = 1000;
		by = 100;
		px = 900;
		py = 930;
		ball = new ImageIcon("C:\\Users\\kshitij\\Desktop\\soccerball.png").getImage();
		paddle = new ImageIcon("C:\\Users\\kshitij\\Desktop\\paddle.jpg").getImage();
	}
	
	int getBx()
	{
		return bx;
	}
	
	int getBy()
	{
		return by;
	}
	
	int getPx()
	{
		return px;
	}
	
	int getPy()
	{
		return py;
	}
	
	Image getBall()
	{
		return ball;
	}
	
	Image getPaddle()
	{
		return paddle;
	}
	
	void setBx(int x)
	{
		bx = x;
	}
	
	void setBy(int y)
	{
		by = y;
	}
	
	void setPx(int x)
	{
		px = x;
	}
	
	void setPy(int y)
	{
		py = y;
	}
	
	void setBall(Image b)
	{
		ball = b;
	}
	
	void setPaddle(Image p)
	{
		paddle = p;
	}
	
	int getBallWidth()
	{
		return BALL_WIDTH;
	}
	
	int getBallHeight()
	{
		return BALL_HEIGHT;
	}
	
	int getPaddleWidth()
	{
		return BALL_WIDTH;
	}
	
	int getPaddleHeight()
	{
		return BALL_HEIGHT;
	}
}