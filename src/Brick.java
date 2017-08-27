
public class Brick {
	
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
