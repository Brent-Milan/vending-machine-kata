import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DisplayControllerTest {
	
	DisplayController underTest;
	VendingMachine bankController;
	
	Quarter quarter = new Quarter();
	Dime dime = new Dime();
	Nickel nickel = new Nickel();
	Penny penny = new Penny();;

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
	
	@Test
	public void shouldReturnInsertCoinStringForInsufficientCoinValue() {
		Soda cola = new Soda();	
		String expected = "INSERT COIN";
		underTest.changeBankIsLow = false;
		
		assertEquals(expected, underTest.updateDisplay(bankController.getCoinsInserted(), cola));
	} 
	
	@Test
	public void shouldDisplaySoldOutWhenSodaInventoryCountIsZero() {
		underTest.sodaButtonIsPressed = true;
		Soda soda = new Soda(0);
		String expected = "SOLD OUT";
		assertEquals(expected, underTest.updateDisplay(bankController.getCoinsInserted(), soda));
	}
	
	@Test
	public void shouldDisplaySoldOutWhenCandyInventoryCountIsZero() {
		underTest.candyButtonIsPressed = true;
		Candy candy = new Candy(0);
		String expected = "SOLD OUT";
		assertEquals(expected, underTest.updateDisplay(bankController.getCoinsInserted(), candy));
	}
	
	@Test
	public void shouldDisplaySoldOutWhenChipsInventoryCountIsZero() {
		underTest.candyButtonIsPressed = true;
		Chips bagOfChips = new Chips();
		String expected = "SOLD OUT";
		assertEquals(expected, underTest.updateDisplay(bankController.getCoinsInserted(), bagOfChips));
	} 
	
	@Test
	public void shouldCheckForSufficentPaymentAndThenReduceSodaInventoryCountByOne() {
		Soda soda = new Soda(20);
		bankController.coinsInserted = bankController.queueCoins(quarter, quarter, dime, dime, dime, nickel, nickel, nickel, penny, penny, penny, penny, penny);
		underTest.vendSelectedProduct(bankController.getCoinsInserted(), soda);
		
		int expected = 19;
		
		assertEquals(expected, soda.getInventoryCount());
	} 

}
