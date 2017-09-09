import static org.junit.Assert.*;

import java.awt.Graphics2D;
import java.util.Stack;

import javax.swing.JButton;

import org.junit.Before;
import org.junit.Test;

public class testBreakout {
	/*-------------------------------------
	Set expected values for the given method
	Create test object and run testable method to get actual value
	Compare actual value with expected value
	If test fails, examine and fix testable method or Junit test until test passed
	-------------------------------------*/
	
	private Ball ball;
	private Brick brick;
	private Paddle paddle;
	private Clock clock;
	private JButton replay, undo, pause, start;
	private static Stack<Ball> ballObjects;
	private static Stack<Paddle> paddleObjects;
	private static Stack<Clock> clockObjects;
	private static Stack<Brick> brickObjects;
	private static int breakLoop = 1; 
	private static boolean gameIsOn = true;
	private static int win = 0;
	private int play = 0, pauseChecker = 0, startChecker = 0;
	
	private Breakout breakout;
	
	
	@Before
	public void setUp() {
		this.ball = new Ball(Constants.BALL_POS_X, Constants.BALL_POS_Y, Constants.BALL_VEL_X, Constants.BALL_VEL_Y);
		this.paddle = new Paddle(Constants.PADDLE_POS_X,Constants.PADDLE_POS_Y);
		this.brick = new Brick();
		this.clock = new Clock();
		this.breakout = new Breakout(ball, paddle, brick, clock);	
	}

	@Test
	public void testStartGame() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckWin() {
		boolean expected = false;
		boolean actual = breakout.checkWin(breakout.brick);
		assertEquals("Check Win function is not working properly", expected, actual);
	}

	@Test
	public void testStoreInstance() {
		fail("Not yet implemented");
	}

	@Test
	public void testActionPerformed() {
		fail("Not yet implemented");
	}

}
