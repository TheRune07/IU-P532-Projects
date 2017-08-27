import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;


public class Bean implements Serializable {
	
	private static int bx;
	private static int by;
	private static int px;
	private static int py;
	private Image ball;
	private Image paddle;
	private static boolean gameIsOn;
	private static int moveX;
	private static int moveY;
	private static String time;
	private static int[][] bricksX = new int[6][19];
	private static int[][] bricksY = new int[6][19];
	private static final int BALL_WIDTH = 50;
	private static final int BALL_HEIGHT = 50;
	private static final int PADDLE_WIDTH = 150;
	private static final int PADDLE_HEIGHT = 20;
	private static final int BRICK_WIDTH = 75;
	private static final int BRICK_HEIGHT = 20;
	private static int FRAME_WIDTH;
	private static int FRAME_HEIGHT;
	
	public Bean()
	{
		bx = 500;
		by = 400;
		px = 900;
		py = 970;
		ball = new ImageIcon("C:\\Users\\kshitij\\Desktop\\soccerball.png").getImage();
		paddle = new ImageIcon("C:\\Users\\kshitij\\Desktop\\paddle.jpg").getImage();
		gameIsOn = true;
		moveX = 1;
		moveY = 1;
		time = "";
		
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
		return PADDLE_WIDTH;
	}
	
	int getPaddleHeight()
	{
		return PADDLE_HEIGHT;
	}
	
	boolean getGameIsOn()
	{
		return gameIsOn;
	}
	
	void setGameIsOn(boolean b)
	{
		gameIsOn = b;
	}
	
	int getMoveX()
	{
		return moveX;
	}
	
	void setMoveX(int x)
	{
		moveX = x;
	}
	
	int getMoveY()
	{
		return moveY;
	}
	
	void setMoveY(int y)
	{
		moveY = y;
	}
	
	String getTime()
	{
		return time;
	}
	
	void setTime(String t)
	{
		time = t;
	}
	
	int[][] getBricksX()
	{
		return bricksX;
	}
	
	int[][] getBricksY()
	{
		return bricksY;
	}
	
	void setBricksX(int i, int j , int x)
	{
		bricksX[i][j] = x;
	}
	
	void setBricksY(int i, int j , int x)
	{
		bricksY[i][j] = x;
	}
	
	int getBrickWidth()
	{
		return BRICK_WIDTH;
	}
	
	int getBrickHeight()
	{
		return BRICK_HEIGHT;
	}
	
	int getFrameWidth()
	{
		return FRAME_WIDTH;
	}
	
	int getFrameHeight()
	{
		return FRAME_HEIGHT;
	}
	
	void setFrameWidth(int w)
	{
		FRAME_WIDTH = w;
	}
	
	void setFrameHeight(int h)
	{
		FRAME_HEIGHT = h;
	}
}