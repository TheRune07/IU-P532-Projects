import static org.junit.Assert.*;

import java.util.Observer;

import org.junit.Before;
import org.junit.Test;

public class TestBreakoutObservable {
	private Ball ball;
	private Paddle paddle;
	private BreakoutObservable observable;
	private Observer obs;
	
	@Before
	public void setUp() {
		this.ball = new Ball(Constants.BALL_POS_X, Constants.BALL_POS_Y, Constants.BALL_VEL_X, Constants.BALL_VEL_Y);
		this.paddle = new Paddle(Constants.PADDLE_POS_X,Constants.PADDLE_POS_Y);
		this.observable = new BreakoutObservable(paddle, ball);
	}

	/*
	@Test
	public void testNotifyObservers() {
		fail("Not yet implemented");
	}*/

	@Test
	public void testCountObservers() {
		int expected = 0;
		int actual = observable.countObservers();
		assertEquals(expected, actual);
	}

	@Test
	public void testAddObserverObserver() {
		BreakoutObservable.observers.add(obs);
		assertTrue(BreakoutObservable.observers.contains(obs));
	}

	@Test
	public void testRemoveObserver() {
		BreakoutObservable.observers.remove(obs);
		assertTrue(!BreakoutObservable.observers.contains(obs));
	}

}
