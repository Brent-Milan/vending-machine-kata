import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DisplayControllerTest {
	
	DisplayController underTest;
	VendingMachine bankController;

	@Before
	public void setUp() throws Exception {
		underTest = new DisplayController();
		bankController = underTest.bankController;
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
	
	@Test
	public void shouldReturnFalseByDefault() {
		assertFalse(underTest.sodaButtonIsPressed);
	}
	
	@Test
	public void shouldCheckConditionalsAndReturnPriceStringForSoda() {
		underTest.sodaButtonIsPressed = true;
		Soda soda = new Soda(10);
		
		String expected = "PRICE 1.00";
		assertEquals(expected, underTest.updateDisplay(bankController.getCoinsInserted(), soda)); 
	}
	
	@Test
	public void shouldReturnExpectedProductPriceStringForChips() {
		underTest.chipsButtonIsPressed = true;
		Chips bagOfChips = new Chips(10);
		
		String expected = "PRICE 0.50";
		assertEquals(expected, underTest.updateDisplay(bankController.getCoinsInserted(), bagOfChips));
	} 
	
	@Test
	public void shouldReturnExpectedProductPriceStringForCandy() {
		underTest.candyButtonIsPressed = true;
		Candy candy = new Candy(10);
		
		String expected = "PRICE 0.65";
		assertEquals(expected, underTest.updateDisplay(bankController.getCoinsInserted(), candy));
	} 

}
