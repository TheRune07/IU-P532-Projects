import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class Ball implements Observer 
{
	int bx = 0, by = 0, moveX = 0, moveY = 0;
	
	Ball(Bean bean)
	{
		bean.setBx(500);
		bean.setBy(400);
		bean.setMoveX(1);
		bean.setMoveY(1);
	}
	

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		Bean bean = (Bean) arg;
		
		if(bean.getBx() == 0){
			bean.setMoveX(1);
		}
		if(bean.getBx() == 1870){
			bean.setMoveX(-1);
		}
		if(bean.getBy() == 0){
			bean.setMoveY(1);
		}
		if(bean.getBy() == 1030){
			bean.setGameIsOn(false);
		}
		
		if((bean.getBx() >= bean.getPx()) && (bean.getBx() <= bean.getPx() + bean.getPaddleWidth())
				&& (bean.getBy()+bean.getBallHeight() >= bean.getPy()) && ( bean.getBy() <= bean.getBy() + bean.getPaddleHeight()))
			bean.setMoveY(-1);
		
	}
	
	public void registerBall()
	{
		Breakout b = new Breakout();
		b.registerObserver(this);
	}	
	
	public void unregisterBall()
	{
		Breakout b = new Breakout();
		b.unregisterObserver(this);
	}
	
	public void moveBall(Bean bean)
	{
		bean.setBx(bean.getBx() + bean.getMoveX());
		bean.setBy(bean.getBy() + bean.getMoveY());
	}

}
