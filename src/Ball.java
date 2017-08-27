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
		HashMap<String, Object> map = new HashMap<String, Object>();
		map = (HashMap<String, Object>) arg;
		Bean bean = (Bean) map.get("bean");
		Breakout b = new Breakout(bean);
		Graphics g2d = b.getGraphics();
		
		//g2d.drawImage(bean.getBall(), bean.getBx(), bean.getBy(), bean.getBallWidth(), bean.getBallHeight(), b);
		g2d.drawRect(bean.getBx(), bean.getBy(), bean.getBallWidth(), bean.getBallHeight());
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
