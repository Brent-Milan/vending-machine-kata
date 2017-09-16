import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

public class DimeRepositoryTest {

	private DimeRepository underTest;
	private Dime dime;
	
	@Before
	public void setUp() throws Exception {
		underTest = new DimeRepository();
		dime = new Dime();
	}

	@Test
	public void shouldReturnAFrequencyOf3() {
		underTest.stockDimesInBank(dime, dime, dime);
		
		int expected = 3;
		
		assertEquals(expected, countDimes(underTest.dimeRepo));
	}

	public int countDimes(ArrayList<Dime> dimes) {
		return Collections.frequency(dimes, dime);
	}
}