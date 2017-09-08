import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {
	
	private VendingMachine underTest;
	
	ArrayList<Coin> coins = new ArrayList<Coin>();
	
	Coin penny = generatePenny();
	Coin nickel = generateNickel();
	Coin dime = generateDime();
	Coin quarter = generateQuarter();

	@Before
	public void setUp() throws Exception {
		underTest = new VendingMachine();
	}

	@Test
	public void shouldReturnQuarterValue() {
		Coin quarter = generateQuarter();
		double expected = 0.25;
		
		assertEquals(expected, underTest.identifyCoin(quarter), 0);
	}
	
	@Test 
	public void shouldReturnDimeValue() {
		Coin dime = generateDime(); 	
		double expected = 0.10;
		
		assertEquals(expected, underTest.identifyCoin(dime), 0);
	}  
	 
	@Test
	public void shouldReturnNickelValue() {
		Coin nickel = generateNickel();
		double expected = .05;
		
		assertEquals(expected, underTest.identifyCoin(nickel), 0);
	}
	
	@Test
	public void shouldReturnPennyValue() {
		Coin penny = generatePenny();
		double expected = 0.01;
		
		assertEquals(expected, underTest.identifyCoin(penny), 0);
	} 
	
	@Test
	public void shouldReturnExpectedArrayListOfCoins() {
		coins.add(penny);
		coins.add(nickel);
		coins.add(dime);
		coins.add(quarter); 
		
		assertEquals(coins, underTest.queueCoins(penny, nickel, dime, quarter));
	} 
	
	@Test
	public void shouldCalculateValueOfQueuedCoinsTo41Cents() {
		ArrayList<Coin> coinsList = createArrayWithOneOfEachCoinType();
		assertEquals(00.41, underTest.calcValueOfCoinsInQueue(coinsList), .001);
	} 
	
	@Test
	public void shouldCalculateValueOfGivenCoinsTo1() {
		coins = underTest.queueCoins(quarter, quarter, dime, dime, dime, nickel, nickel, nickel, penny, penny, penny, penny, penny);
		
		assertEquals(1.00, underTest.calcValueOfCoinsInQueue(coins), 0);
	}
	
	@Test
	public void shouldReturnCorrectChangeDueAs50Cents() {
		Chips bagOfChips = new Chips();
		
		coins = underTest.queueCoins(quarter, quarter, dime, dime, dime, nickel, nickel, nickel, penny, penny, penny, penny, penny);
		double expected = 0.50;
		
		assertEquals(expected, underTest.calcChangeDue(coins, bagOfChips), 0);
	} 
	
	@Test
	public void shouldReturnCorrectChangeDueAs35Cents() {
		Candy licorice = new Candy();
		
		coins = underTest.queueCoins(quarter, quarter, dime, dime, dime, nickel, nickel, nickel, penny, penny, penny, penny, penny);
		double expected = 0.35;
		
		assertEquals(expected, underTest.calcChangeDue(coins, licorice), 0);
	}
	
	@Test
	public void shouldReturnCorrectChangeDueAs0() {
		Soda soda = new Soda();
		
		coins = underTest.queueCoins(quarter, quarter, dime, dime, dime, nickel, nickel, nickel, penny, penny, penny, penny, penny);
		double expected = 0.00;
		
		assertEquals(expected, underTest.calcChangeDue(coins, soda), 0);
	}
	
	@Test
	public void shouldCheckForSufficientCoinValueAndReturnFalse() {
		Chips bagOfChips = new Chips();
		coins = underTest.queueCoins(quarter);
		
		assertFalse(underTest.isSufficientPayment(coins, bagOfChips));
	}
	
	@Test
	public void shouldCheckForSufficientCoinValueAndReturnTrue() {
		coins = underTest.queueCoins(quarter, quarter, dime, dime, dime, nickel, nickel, nickel, penny, penny, penny, penny, penny);
		
		Soda soda = new Soda();
		
		assertTrue(underTest.isSufficientPayment(coins, soda));
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
		assertEquals(expected, underTest.updateDisplay(coins, soda)); 
		
	}
	
	@Test
	public void shouldReturnExpectedProductPriceStringForChips() {
		underTest.chipsButtonIsPressed = true;
		Chips bagOfChips = new Chips(10);
		
		String expected = "PRICE 0.50";
		assertEquals(expected, underTest.updateDisplay(coins, bagOfChips));
	} 
	
	@Test
	public void shouldReturnExpectedProductPriceStringForCandy() {
		underTest.candyButtonIsPressed = true;
		Candy candy = new Candy(10);
		
		String expected = "PRICE 0.65";
		assertEquals(expected, underTest.updateDisplay(coins, candy));
	} 
	
	@Test
	public void shouldReturnInsertCoinStringForInsufficientCoinValue() {
		Soda cola = new Soda();	
		String expected = "INSERT COIN";
		
		assertEquals(expected, underTest.updateDisplay(coins, cola));
	} 
	
	@Test
	public void shouldDisplayOutOfStockWhenSodaInventoryCountIsZero() {
		underTest.sodaButtonIsPressed = true;
		Soda soda = new Soda(0);
		String expected = "Out of Stock";
		assertEquals(expected, underTest.updateDisplay(coins, soda));
	}
	
	@Test
	public void shouldDisplayOutOfStockWhenCandyInventoryCountIsZero() {
		underTest.candyButtonIsPressed = true;
		Candy candy = new Candy(0);
		String expected = "Out of Stock";
		assertEquals(expected, underTest.updateDisplay(coins, candy));
	}
	
	@Test
	public void shouldDisplayOutOfStockWhenChipsInventoryCountIsZero() {
		underTest.candyButtonIsPressed = true;
		Chips bagOfChips = new Chips();
		String expected = "Out of Stock";
		assertEquals(expected, underTest.updateDisplay(coins, bagOfChips));
	} 
	
	@Test
	public void shouldCheckForSufficentPaymentAndThenReduceSodaInventoryCountByOne() {
		Soda soda = new Soda(20);
		coins = underTest.queueCoins(quarter, quarter, dime, dime, dime, nickel, nickel, nickel, penny, penny, penny, penny, penny);
		underTest.vendSelectedProduct(coins, soda);
		
		int expected = 19;
		
		assertEquals(expected, soda.getInventoryCount());
	} 
	
	@Test
	public void shouldCheckForSufficentPaymentAndThenReduceCandyInventoryCountByOne() {
		Candy candy = new Candy(20);
		coins = underTest.queueCoins(quarter, quarter, dime, dime, dime, nickel, nickel, nickel, penny, penny, penny, penny, penny);
		underTest.vendSelectedProduct(coins, candy);
		
		int expected = 19;
		
		assertEquals(expected, candy.getInventoryCount());
	}  
	
	@Test
	public void shouldCheckForSufficentPaymentAndThenReduceChipsInventoryCountByOne() {
		Chips bagOfChips = new Chips(20);
		coins = underTest.queueCoins(quarter, quarter, dime, dime, dime, nickel, nickel, nickel, penny, penny, penny, penny, penny);
		underTest.vendSelectedProduct(coins, bagOfChips);
		
		int expected = 19;
		
		assertEquals(expected, bagOfChips.getInventoryCount());
	}  
	
	
	private Coin generateQuarter() {
		Coin quarter = new Coin(24.26, 5.67);
		return quarter;
	}

	private Coin generateDime() {
		Coin dime = new Coin(17.91, 2.268);
		return dime;
	}

	private Coin generateNickel() {
		Coin nickel = new Coin(21.21, 5.0);
		return nickel;
	}

	private Coin generatePenny() {
		Coin penny = new Coin(19.05, 2.5);
		return penny;
	}
	
	private ArrayList<Coin> createArrayWithOneOfEachCoinType() {
		ArrayList<Coin> coins = new ArrayList<Coin>();
		
		Coin penny = generatePenny();
		Coin nickel = generateNickel();
		Coin dime = generateDime();
		Coin quarter = generateQuarter();
		
		coins.add(penny);
		coins.add(nickel);
		coins.add(dime);
		coins.add(quarter);
		
		return coins;
	}  
	
} 
