package production;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class DisplayControllerTest {
	
	DisplayController underTest;
	
	BankController bank;
	Coin coin = new Coin();
	Coin quarter = coin.createQuarter();
	Coin dime = coin.createDime();
	Coin nickel = coin.createNickel();
	Coin penny = coin.createPenny();

	@Before
	public void setUp() throws Exception {
		underTest = new DisplayController();
		bank = underTest.bank;
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
		assertEquals(expected, underTest.updateDisplay(bank.getCoinsInserted(), soda)); 
	}
	
	@Test
	public void shouldReturnExpectedProductPriceStringForChips() {
		underTest.chipsButtonIsPressed = true;
		Chips bagOfChips = new Chips(10);
		
		String expected = "PRICE 0.50";
		assertEquals(expected, underTest.updateDisplay(bank.getCoinsInserted(), bagOfChips));
	} 
	
	@Test
	public void shouldReturnExpectedProductPriceStringForCandy() {
		underTest.candyButtonIsPressed = true;
		Candy candy = new Candy(10);
		
		String expected = "PRICE 0.65";
		assertEquals(expected, underTest.updateDisplay(bank.getCoinsInserted(), candy));
	} 
	
	@Test
	public void shouldReturnInsertCoinStringForInsufficientCoinValue() {
		Soda cola = new Soda();	
		String expected = "INSERT COIN";
		bank.isBankChangeLow = false;
		
		assertEquals(expected, underTest.updateDisplay(bank.getCoinsInserted(), cola));
	} 
	
	@Test
	public void shouldDisplaySoldOutWhenSodaInventoryCountIsZero() {
		underTest.sodaButtonIsPressed = true;
		Soda soda = new Soda(0);
		String expected = "SOLD OUT";
		assertEquals(expected, underTest.updateDisplay(bank.getCoinsInserted(), soda));
	}
	
	@Test
	public void shouldDisplaySoldOutWhenCandyInventoryCountIsZero() {
		underTest.candyButtonIsPressed = true;
		Candy candy = new Candy(0);
		String expected = "SOLD OUT";
		assertEquals(expected, underTest.updateDisplay(bank.getCoinsInserted(), candy));
	}
	
	@Test
	public void shouldDisplaySoldOutWhenChipsInventoryCountIsZero() {
		underTest.candyButtonIsPressed = true;
		Chips bagOfChips = new Chips();
		String expected = "SOLD OUT";
		assertEquals(expected, underTest.updateDisplay(bank.getCoinsInserted(), bagOfChips));
	} 
	
	@Test
	public void shouldCheckForSufficentPaymentAndThenReduceSodaInventoryCountByOne() {
		Soda soda = new Soda(20);
		bank.coinsInserted = bank.queueCoins(quarter, quarter, dime, dime, dime, nickel, nickel, nickel, penny, penny, penny, penny, penny);
		underTest.vendSelectedProduct(bank.getCoinsInserted(), soda);
		
		int expected = 19;
		
		assertEquals(expected, soda.getInventoryCount());
	} 
	
	@Test
	public void shouldCheckForSufficentPaymentAndThenReduceCandyInventoryCountByOne() {
		Candy candy = new Candy(20);
		bank.coinsInserted = bank.queueCoins(quarter, quarter, dime, dime, dime, nickel, nickel, nickel, penny, penny, penny, penny, penny);
		underTest.vendSelectedProduct(bank.getCoinsInserted(), candy);
		
		int expected = 19;
		
		assertEquals(expected, candy.getInventoryCount());
	} 
	
	@Test
	public void shouldCheckForSufficentPaymentAndThenReduceChipsInventoryCountByOne() {
		Chips bagOfChips = new Chips(20);
		bank.coinsInserted = bank.queueCoins(quarter, quarter, dime, dime, dime, nickel, nickel, nickel, penny, penny, penny, penny, penny);
		underTest.vendSelectedProduct(bank.getCoinsInserted(), bagOfChips);
		
		int expected = 19;
		
		assertEquals(expected, bagOfChips.getInventoryCount());
	} 

	@Test
	public void shouldDisplayThankYouAfterCheckingForSufficientPaymentAndInventoryCountForSoda() {
		Soda soda = new Soda(10);
		underTest.sodaButtonIsPressed = true;
		bank.coinsInserted = bank.queueCoins(quarter, quarter, dime, dime, dime, nickel, nickel, nickel, penny, penny, penny, penny, penny);
		
		String expected = "THANK YOU";
		
		assertEquals(expected, underTest.updateDisplay(bank.getCoinsInserted(), soda));
	}
	
	@Test 
	public void shouldDisplayThankYouAfterCheckingForSufficientPaymentAndInventoryCountForCandy() {
		Candy candy = new Candy(10);
		underTest.candyButtonIsPressed = true;
		bank.coinsInserted = bank.queueCoins(quarter, quarter, quarter);
		
		String expected = "THANK YOU";
		
		assertEquals(expected, underTest.updateDisplay(bank.getCoinsInserted(), candy));
	}
	
	@Test
	public void shouldDisplayThankYouAfterCheckingForSufficientPaymentAndInventoryCountForChips() {
		Chips bagOfChips = new Chips(10);
		underTest.chipsButtonIsPressed = true;
		bank.coinsInserted = bank.queueCoins(quarter, quarter, quarter);
		
		String expected = "THANK YOU";
		
		assertEquals(expected, underTest.updateDisplay(bank.getCoinsInserted(), bagOfChips));
	}
	
	@Test
	public void shouldUpdateDisplayToReadExactChangeWhenChangeBankIsLow() {
		bank.coinsInserted = bank.queueCoins();
		Soda soda = new Soda(10);
		bank.isBankChangeLow= true;
		
		String expected = "EXACT CHANGE ONLY";
		
		assertEquals(expected, underTest.updateDisplay(bank.getCoinsInserted(), soda));
	}

}
