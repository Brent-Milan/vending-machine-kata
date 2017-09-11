import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

public class QuarterRepositoryTest {
	
	private QuarterRepository underTest;
	private Quarter quarter = new Quarter();

	@Before
	public void setUp() throws Exception {
		underTest = new QuarterRepository();
	}
	
	@Test
	public void shouldReturnAFrequencyOf3() {
		underTest.stockQuartersInBank(quarter, quarter, quarter);
		
		int expected = 3;
		
		assertEquals(expected, countQuarters(underTest.quarterRepo));
	}

	@Test
	public void shouldReturnAFrequencyOf1() {
		underTest.stockQuartersInBank(quarter, quarter);
		underTest.remove(0);
		
		int result = countQuarters(underTest.quarterRepo);
		int expected = 1;
		
		assertEquals(expected, result);
	}

	
	public int countQuarters(ArrayList<Quarter> quarters) {
	return Collections.frequency(quarters, quarter);
	}

}