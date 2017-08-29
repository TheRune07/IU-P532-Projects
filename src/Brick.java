
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
	
	public boolean bottomCollision(int xBall, int yBall, int xBrick, int yBrick, Bean bean) 
	{
		if ((xBall+25 >= xBrick) && (xBall <= xBrick + bean.getBrickWidth()) && (yBall == yBrick + bean.getBrickHeight())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean topCollision(int xBall, int yBall, int xBrick, int yBrick, Bean bean) {
		if ((xBall+25 >= xBrick) && (xBall <= xBrick + bean.getBrickWidth()) && (yBall == yBrick - 25)) {
				return true;
			}
		else
			return false;
		
	}
	
	public boolean leftCollision(int xBall, int yBall, int xBrick, int yBrick, Bean bean) {
		if ((yBall+25 >= yBrick) && (yBall <= yBrick + bean.getBrickHeight()) && (xBall+25 == xBrick)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean rightCollision(int xBall, int yBall, int xBrick, int yBrick, Bean bean) {
		if ((yBall+25 >= yBrick) && (yBall <= yBrick + bean.getBrickHeight()) && (xBall == xBrick + bean.getBrickWidth())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void brickCollide(Bean bean) 
	{
		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < 19; j++)
			{
				if(bottomCollision(bean.getBx(), bean.getBy(), bean.getBricksX()[i][j], bean.getBricksY()[i][j], bean)) {
					bean.setMoveY(1);
					bean.setBricksX(i, j, -1);
					bean.setBricksY(i, j, -1);
				}
				
				if(topCollision(bean.getBx(), bean.getBy(), bean.getBricksX()[i][j], bean.getBricksY()[i][j], bean)) {
					bean.setMoveY(-1);
					bean.setBricksX(i, j, -1);
					bean.setBricksY(i, j, -1);
				}
				
				if(rightCollision(bean.getBx(), bean.getBy(), bean.getBricksX()[i][j], bean.getBricksY()[i][j], bean)) {
					bean.setMoveX(-bean.getMoveX());
					bean.setBricksX(i, j, -1);
					bean.setBricksY(i, j, -1);
				}
				
				if(leftCollision(bean.getBx(), bean.getBy(), bean.getBricksX()[i][j], bean.getBricksY()[i][j], bean)) {
					bean.setMoveX(-bean.getMoveX());
					bean.setBricksX(i, j, -1);
					bean.setBricksY(i, j, -1);
				}
			}
		}
	}
}
