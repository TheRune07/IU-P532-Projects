import static org.junit.Assert.*;

import java.awt.Graphics2D;
import java.util.Stack;

import javax.swing.JButton;

import org.junit.Before;
import org.junit.Test;

public class testBreakout {
	/*-------------------------------------
	 * Steps:
	 * Set expected values for the given method
	 * Create test object and run testable method to get actual value
	 * Compare actual value with expected value
	 * If test fails, examine and fix testable method or Junit test until test passed
	-------------------------------------*/
	
	private Ball ball;
	private Brick brick;
	private Paddle paddle;
	private Clock clock;
	
	
	
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
		// TODO How?
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
		breakout.storeInstance(ball, paddle, clock, brick);
		assertTrue(Breakout.ballObjects.contains(ball));
		assertTrue(Breakout.paddleObjects.contains(paddle));
		assertTrue(Breakout.brickObjects.contains(brick));
		assertTrue(Breakout.clockObjects.contains(clock));
		
	}

	@Test
	public void testActionPerformed() {
		// pause button test
		breakout.pause.doClick();
		assertEquals(breakout.pauseChecker, 1);
		// start/restart button test
		breakout.start.doClick();
		assertEquals(breakout.startChecker, 1);
		// TODO undo
		breakout.undo.doClick();
		// TODO replay
		breakout.replay.doClick();
		
	}

}
