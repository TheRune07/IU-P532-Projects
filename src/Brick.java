import java.awt.Color;
import java.awt.Graphics2D;

public class Brick implements Sprite, Cloneable {
	
	int[][] bricksX = new int[Constants.BRICK_ROW][Constants.BRICK_COLUMN];
	int[][] bricksY = new int[Constants.BRICK_ROW][Constants.BRICK_COLUMN];
	static final int BRICK_WIDTH = 50;
	static final int BRICK_HEIGHT = 10;
	Brick cloneBrick;
	
	Brick(Brick brick)
	{
		cloneBrick = brick;
	}
	
	public Brick()
	{
		int brx = 0;
		int bry = 0;
<<<<<<< HEAD

=======
>>>>>>> origin/master
		for(int i = 0; i < Constants.BRICK_ROW; i++) // put in initializeBricks
		{
			for(int j = 0; j < Constants.BRICK_COLUMN; j++)
			{
				bricksX[i][j] = brx + 20;
				bricksY[i][j] = bry + 40;
				brx = brx + 80;
			}
			brx = 0;
			bry = bry +40;
		}
	}
	
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();	
	}
	
	
	public boolean bottomCollision(int xBall, int yBall, int xBrick, int yBrick) 
	{
		if ((xBall+25 >= xBrick) && (xBall <= xBrick + BRICK_WIDTH) && (yBall == yBrick + BRICK_HEIGHT)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean topCollision(int xBall, int yBall, int xBrick, int yBrick) {
		if ((xBall+25 >= xBrick) && (xBall <= xBrick + BRICK_WIDTH) && (yBall == yBrick - 25)) {
				return true;
			}
		else
			return false;
		
	}
	
	public boolean leftCollision(int xBall, int yBall, int xBrick, int yBrick) {
		if ((yBall+25 >= yBrick) && (yBall <= yBrick + BRICK_HEIGHT) && (xBall+25 == xBrick)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean rightCollision(int xBall, int yBall, int xBrick, int yBrick) {
		if ((yBall+25 >= yBrick) && (yBall <= yBrick + BRICK_HEIGHT) && (xBall == xBrick + BRICK_WIDTH)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void brickCollide(Ball ball) 
	{
		for(int i = 0; i < Constants.BRICK_ROW; i++)
		{
			for(int j = 0; j < Constants.BRICK_COLUMN; j++)
			{
				if(bottomCollision(ball.getBx(), ball.getBy(), bricksX[i][j], bricksY[i][j])) {
					ball.setMoveY(1);
					bricksX[i][j] = -1;
					bricksY[i][j] = -1;
					
				}
				
				if(topCollision(ball.getBx(), ball.getBy(), bricksX[i][j], bricksY[i][j])) {
					ball.setMoveY(-1);
					bricksX[i][j] = -1;
					bricksY[i][j] = -1;
				}
				
				if(rightCollision(ball.getBx(), ball.getBy(), bricksX[i][j], bricksY[i][j])) {
					ball.setMoveX(-ball.getMoveX());
					bricksX[i][j] = -1;
					bricksY[i][j] = -1;
				}
				
				if(leftCollision(ball.getBx(), ball.getBy(), bricksX[i][j], bricksY[i][j])) {
					ball.setMoveX(-ball.getMoveX());
					bricksX[i][j] = -1;
					bricksY[i][j] = -1;
				}
			}
		}
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		for(int i = 0; i < Constants.BRICK_ROW; i++)
		{
			for(int j = 0; j < Constants.BRICK_COLUMN; j++)
			{
				if(bricksX[i][j] != -1 && bricksX[i][j] != -1)
				{
					g2d.setColor(Color.ORANGE);
					g2d.fillRect(bricksX[i][j], bricksY[i][j], BRICK_WIDTH, BRICK_HEIGHT);
				}
			}
		}
	}
	
	int[][] getBricksX()
	{
		return bricksX;
	}
	
	int[][] getBricksY()
	{
		return bricksY;
	}
	
}
