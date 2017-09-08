import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;


public class Ball implements Observer, Sprite, Cloneable

{
	int bx = 800;
	int by = 500;
	int moveX = 1;
	int moveY =1;
	final int BALL_WIDTH = 25;
	final int BALL_HEIGHT = 25;
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
			moveX = 1;
		}
		if(bx == 1870){
			moveX = -1;
		}
		if(by == 0){
			moveY = 1;
		}
		if(by == 1030){
			Breakout.gameIsOn = false;
		}
		
		if((bx >= paddle.getPx()) && (bx <= paddle.getPx() + paddle.getPaddleWidth())
				&& (by + BALL_HEIGHT >= paddle.getPy()) && ( by <= by + paddle.getPaddleHeight()))
			moveY = -1;
		
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
