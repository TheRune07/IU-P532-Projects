import java.awt.Color;
import java.awt.Graphics2D;

public class Brick implements Sprite {
	
	static int[][] bricksX = new int[6][19];
	static int[][] bricksY = new int[6][19];
	static final int BRICK_WIDTH = 75;
	static final int BRICK_HEIGHT = 10;
	
	
	public void initializeBricks()
	{
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
		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < 19; j++)
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
		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < 19; j++)
			{
				if(bricksX[i][j] != -1 && bricksX[i][j] != -1)
				{
					g2d.setColor(Color.ORANGE);
					g2d.fillRect(bricksX[i][j], bricksY[i][j], BRICK_WIDTH, BRICK_HEIGHT);
				}
			}
		}
		
		
	}
}
