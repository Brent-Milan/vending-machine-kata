package production;
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

	@Test
	public void shouldReturnAFrequencyof2() {
		underTest.stockDimesInBank(dime, dime, dime);
		
		underTest.remove(0);
		int expected = 2;
		
		assertEquals(expected, countDimes(underTest.dimeRepo));
	}
	
	@Test
	public void shouldReturnFalse() {
		underTest.stockDimesInBank(dime);
		
		assertEquals(false, underTest.isStocked());
	}
	
	public int countDimes(ArrayList<Dime> dimes) {
		return Collections.frequency(dimes, dime);
	}
	
}
