import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DisplayControllerTest {
	
	DisplayController underTest;

	@Before
	public void setUp() throws Exception {
		underTest = new DisplayController();
	}

	@Test
	public void shouldDisplayCostOf1DollarWhenPressed() {
		String expected = "1.00";
		
		assertEquals(expected, underTest.displaySodaCost());
	}
	
	@Test
	public void shouldDisplayCostOf50CentsWhenPressed() {
		String expected = "0.50";
		
		assertEquals(expected, underTest.displayChipsCost());
	}
	
	@Test
	public void shouldDisplayCostOf65CentsWhenPressed() {
		String expected = "0.65";
		
		assertEquals(expected, underTest.displayCandyCost());
	}

}
