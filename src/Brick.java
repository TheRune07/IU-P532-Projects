
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
				if(bx >= bricksX[i][j] && bx <= bricksX[i][j] + 75 && by+25 >= bricksY[i][j] + 20 && by+25 <= bricksY[i][j] + 75)
				{
					bricksX[i][j] = -1;
					bean.setMoveY(-1);
				}
			} 
		}
	}
	
	public void initializeBricks(Bean bean)
	{
		int[][] bricksX = bean.getBricksX();
		int[][] bricksY = bean.getBricksY();
		
		int brx = 0;
		int bry = 0;
		for(int i = 0; i < 6; i++) // put in initializeBricks
		{
			for(int j = 0; j < 19; j++)
			{
				bricksX[i][j] = brx + 20;
				bricksY[i][j] = bry + 40;
				brx = brx + 100;
			}
			brx = 0;
			bry = bry +40;
		}
	}
}
