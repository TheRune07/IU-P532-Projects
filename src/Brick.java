
public class Brick {
	public void checkCollision(Bean bean)
	{
		int bx = bean.getBx();
		int by = bean.getBy();
		int bricksX[][] = bean.getBricksX();
		int bricksY[][] = bean.getBricksY();
		
		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < 19; j++)
			{
				if(bx+20 >= bricksX[i][j] && bx+20 <= bricksX[i][j] + 75 && by >= bricksY[i][j] + 20 && by <= bricksY[i][j] + 75)
				{
					bricksX[i][j] = -1;
					bean.setMoveY(-1);
				}
			}
		}
	}
}
