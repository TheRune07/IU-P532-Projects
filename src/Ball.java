import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class Ball implements Observer 
{
	int bx = 0, by = 0, moveX = 0, moveY = 0;
	

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
		
	}
	
	public void registerBall(Bean bean)
	{
		Breakout b = new Breakout();
		b.registerObserver(this);
	}	
	
	public void moveBall(Bean bean)
	{
		bx = bean.getBx();
		by = bean.getBy();
		moveX = bean.getMoveX();
		moveY = bean.getMoveY();
		
		bx = bx + moveX;
		by = by + moveY;
		
		bean.setBx(bx);
		bean.setBy(by);
		
		
		//return bean;
	}

}
