import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class QuarterRepositoryTest {
	
	private QuarterRepository underTest;
	private Coin quarter = new Quarter();

	@Before
	public void setUp() throws Exception {
		underTest = new QuarterRepository();
	}


	@Test
	public void testRemove() {
		underTest.add(Quarter)
		ArrayList<Coin> expectedCoins = new ArrayList<Coin>();
	}

}
