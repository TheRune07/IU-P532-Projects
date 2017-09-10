import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class TestBrick {
	private int[][] bricksX;
	private int[][] bricksY;
	private Ball ball;
	private Brick brick;
	
	@Before
	public void setUp() {
		this.ball = new Ball(Constants.BALL_POS_X, Constants.BALL_POS_Y, Constants.BALL_VEL_X, Constants.BALL_VEL_Y);
		this.brick = new Brick(1);
		this.bricksX = new int[Constants.BRICK_ROW][Constants.BRICK_COLUMN];
		this.bricksY = new int[Constants.BRICK_ROW][Constants.BRICK_COLUMN];
	}

	
	@Test
	public void testBottomCollision() {
		int xBall = ball.getBx();
		int yBall = ball.getBy();
		int xBrick = 120;
		int yBrick = 40;
		boolean actual = brick.bottomCollision(xBall, yBall, xBrick, yBrick);
		boolean expected = false;
		assertEquals(actual, expected);
	}

	@Test
	public void testTopCollision() {
		int xBall = ball.getBx();
		int yBall = ball.getBy();
		int xBrick = 120;
		int yBrick = 40;
		boolean actual = brick.topCollision(xBall, yBall, xBrick, yBrick);
		boolean expected = false;
		assertEquals(actual, expected);
	}

	@Test
	public void testLeftCollision() {
		int xBall = ball.getBx();
		int yBall = ball.getBy();
		int xBrick = 120;
		int yBrick = 40;
		boolean actual = brick.leftCollision(xBall, yBall, xBrick, yBrick);
		boolean expected = false;
		assertEquals(actual, expected);
	}

	@Test
	public void testRightCollision() {
		int xBall = ball.getBx();
		int yBall = ball.getBy();
		int xBrick = 120;
		int yBrick = 40;
		boolean actual = brick.rightCollision(xBall, yBall, xBrick, yBrick);
		boolean expected = false;
		assertEquals(actual, expected);
	}


	@Test
	public void testGetBricksX() {
		int[][] expected = brick.bricksX;
		int[][] actual = brick.getBricksX();
		assertTrue(Arrays.equals(expected, actual));
	}

	@Test
	public void testGetBricksY() {
		int[][] expected = brick.bricksY;
		int[][] actual = brick.getBricksY();
		assertTrue(Arrays.equals(expected, actual));
	}

}
