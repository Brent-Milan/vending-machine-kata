import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

public class NickelRepositoryTest {
	
	NickelRepository underTest;
	Nickel nickel = new Nickel();

	@Before
	public void setUp() throws Exception {
		underTest = new NickelRepository();
	}

	@Test
	public void shouldReturnAFrequencyOf3() {
		underTest.stockNickelsInBank(nickel, nickel, nickel);
		
		int expected = 3;
		
		assertEquals(expected, countNickels(underTest.nickelRepo));
	}
	
	public int countNickels(ArrayList<Nickel> nickels) {
		return Collections.frequency(nickels, nickel);
	}
	
	

}
