package production;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

public class PennyReposoitoryTest {
	
	private CoinRepository underTest;
	private	Coin penny = new Coin();

	@Before
	public void setUp() throws Exception {
		underTest = new CoinRepository();
		penny = penny.createPenny();
	}

	@Test
	public void shouldReturnAFrequencyOf3() {
		underTest.stockPenniesInBank(penny, penny, penny);
		
		int expected = 3;
		
		assertEquals(expected, countPennies(underTest.coinRepo));
	}

	@Test
	public void shouldReturnAFrequencyof2() {
		underTest.stockPenniesInBank(penny, penny, penny);
		
		underTest.remove(penny);
		int expected = 2;
		
		assertEquals(expected, countPennies(underTest.coinRepo));
	}
	
	@Test
	public void shouldReturnFalse() {
		underTest.stockPenniesInBank(penny, penny, penny, penny, penny, penny, penny, penny);
		
		assertEquals(false, underTest.isStocked());
	}

	public int countPennies(ArrayList<Coin> pennies) {
		return Collections.frequency(pennies, penny);
	}
}
