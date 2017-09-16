import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

public class PennyReposoitoryTest {
	
	private PennyRepository underTest;
	private	Penny penny;

	@Before
	public void setUp() throws Exception {
		underTest = new PennyRepository();
		penny = new Penny();
	}

	@Test
	public void shouldReturnAFrequencyOf3() {
		underTest.stockPenniesInBank(penny, penny, penny);
		
		int expected = 3;
		
		assertEquals(expected, countPennies(underTest.pennyRepo));
	}

	public int countPennies(ArrayList<Penny> pennies) {
		return Collections.frequency(pennies, penny);
	}

}
