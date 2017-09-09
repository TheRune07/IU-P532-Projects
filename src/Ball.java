import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;


public class Ball implements Observer, Sprite, Cloneable

{
	int bx = Constants.BALL_POS_X;
	int by = Constants.BALL_POS_Y;
	int moveX = Constants.BALL_VEL_X;
	int moveY =Constants.BALL_VEL_Y;
	final int BALL_WIDTH = Constants.BALL_WIDTH;
	final int BALL_HEIGHT = Constants.BALL_HEIGHT;
	Ball cloneBall;
	
	Ball(int bx, int by, int moveX, int moveY)
	{
		this.bx = bx;
		this.by = by;
		this.moveX = moveX;
		this.moveY = moveY;
	}
	
	Ball(Ball ball)
	{
		cloneBall = ball;
	}
	
	Ball()
	{
		
	}
	
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();	
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		Paddle paddle = (Paddle) arg;
		
		if(bx == 0){
			moveX = 10;
		}
		if(bx == Constants.BOARD_WIDTH-30){
			moveX = -10;
		}
		if(by == 0){
			moveY = 10;
		}
		if(by == Constants.BOARD_HEIGHT){
			Breakout.gameIsOn = false;
		}
		
		if((bx >= paddle.getPx()) && (bx <= paddle.getPx() + paddle.getPaddleWidth())
				&& (by + BALL_HEIGHT >= paddle.getPy()) && ( by <= by + paddle.getPaddleHeight()))
			moveY = -10;	
	}
	
	public void registerBall()
	{
		BreakoutObservable oberservable = new BreakoutObservable();
		oberservable.addObserver(this);
	}	
	
	public void unregisterBall()
	{
		BreakoutObservable observable = new BreakoutObservable();
		observable.removeObserver(this);
	}
	
	public void moveBall()
	{
		// I am changing these values temporarily 
		bx = bx + moveX;
		by = by + moveY;
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.setColor(Color.RED);
        g2d.fillOval(bx, by, BALL_WIDTH, BALL_HEIGHT);
	}
	
	int getBx()
	{
		return bx;
	}
	
	int getBy()
	{
		return by;
	}
	
	void setBx(int x)
	{
		bx = x;
	}
	
	void setBy(int y)
	{
		by = y;
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

}
