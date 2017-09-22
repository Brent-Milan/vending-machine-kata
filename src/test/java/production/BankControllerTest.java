package production;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class BankControllerTest {
	
	private BankController underTest;
	
	ArrayList<Coin> coinsInserted = new ArrayList<Coin>();
	
	Coin penny = generatePenny();
	Coin nickel = generateNickel();
	Coin dime = generateDime();
	Coin quarter = generateQuarter();

	@Before
	public void setUp() throws Exception {
		underTest = new BankController();
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
		coinsInserted.add(penny);
		coinsInserted.add(nickel);
		coinsInserted.add(dime);
		coinsInserted.add(quarter); 
		
		assertEquals(coinsInserted, underTest.queueCoins(penny, nickel, dime, quarter));
	} 
	
	@Test
	public void shouldCalculateValueOfQueuedCoinsTo41Cents() {
		ArrayList<Coin> coinsList = createArrayWithOneOfEachCoinType();
		assertEquals(00.41, underTest.calcValueOfCoinsInQueue(coinsList), .001);
	} 
	
	@Test
	public void shouldCalculateValueOfGivenCoinsTo1() {
		coinsInserted = underTest.queueCoins(quarter, quarter, dime, dime, dime, nickel, nickel, nickel, penny, penny, penny, penny, penny);
		
		assertEquals(1.00, underTest.calcValueOfCoinsInQueue(coinsInserted), 0);
	}
	
	@Test
	public void shouldReturnCorrectChangeDueAs50Cents() {
		Chips bagOfChips = new Chips();
		
		coinsInserted = underTest.queueCoins(quarter, quarter, dime, dime, dime, nickel, nickel, nickel, penny, penny, penny, penny, penny);
		double expected = 0.50;
		
		assertEquals(expected, underTest.calcChangeDue(coinsInserted, bagOfChips), 0);
	} 
	
	@Test
	public void shouldReturnCorrectChangeDueAs35Cents() {
		Candy licorice = new Candy();
		
		coinsInserted = underTest.queueCoins(quarter, quarter, dime, dime, dime, nickel, nickel, nickel, penny, penny, penny, penny, penny);
		double expected = 0.35;
		
		assertEquals(expected, underTest.calcChangeDue(coinsInserted, licorice), 0);
	}
	
	@Test
	public void shouldReturnCorrectChangeDueAs0() {
		Soda soda = new Soda();
		
		coinsInserted = underTest.queueCoins(quarter, quarter, dime, dime, dime, nickel, nickel, nickel, penny, penny, penny, penny, penny);
		double expected = 0.00;
		
		assertEquals(expected, underTest.calcChangeDue(coinsInserted, soda), 0);
	}
	
	@Test
	public void shouldCheckForSufficientCoinValueAndReturnFalse() {
		Chips bagOfChips = new Chips();
		coinsInserted = underTest.queueCoins(quarter);
		
		assertFalse(underTest.isSufficientPayment(coinsInserted, bagOfChips));
	}
	
	@Test
	public void shouldCheckForSufficientCoinValueAndReturnTrue() {
		coinsInserted = underTest.queueCoins(quarter, quarter, dime, dime, dime, nickel, nickel, nickel, penny, penny, penny, penny, penny);
		
		Soda soda = new Soda();
		
		assertTrue(underTest.isSufficientPayment(coinsInserted, soda));
	}

	@Test
	public void shouldCalculateChangeDueAndReturnOneQuarter() {
		coinsInserted = underTest.queueCoins(quarter, quarter, quarter, quarter, quarter);
		Soda soda = new Soda();
		
		ArrayList<Coin> expectedCoins = new ArrayList<Coin>();
		expectedCoins.add(quarter);
		double expectedCoinsValue = underTest.calcValueOfCoinsInQueue(expectedCoins);
		
		ArrayList<Coin> resultAsArray = underTest.returnCoins(coinsInserted, soda);
		double result = underTest.calcValueOfCoinsInQueue(resultAsArray);
		
		assertEquals(expectedCoinsValue, result, 0);
	}      
	
	@Test
	public void shouldCalculateChangeDueAndReturnOneDime() {
		coinsInserted = underTest.queueCoins(quarter, quarter, quarter, quarter, dime);
		Soda soda = new Soda();
		
		ArrayList<Coin> expectedCoins = new ArrayList<Coin>();
		expectedCoins.add(dime);
		double expectedCoinsValue = underTest.calcValueOfCoinsInQueue(expectedCoins);
		
		ArrayList<Coin> resultAsArray = underTest.returnCoins(coinsInserted, soda);
		double result = underTest.calcValueOfCoinsInQueue(resultAsArray);
		
		assertEquals(expectedCoinsValue, result, 0.01);
	}
	
	@Test
	public void shouldCalculateChangeDueAndReturnOneNickel() {
		coinsInserted = underTest.queueCoins(quarter, quarter, quarter, quarter, nickel);
		Soda soda = new Soda();
		
		ArrayList<Coin> expectedCoins = new ArrayList<Coin>();
		expectedCoins.add(nickel);
		double expectedCoinsValue = underTest.calcValueOfCoinsInQueue(expectedCoins);
		
		ArrayList<Coin> resultAsArray = underTest.returnCoins(coinsInserted, soda);
		double result = underTest.calcValueOfCoinsInQueue(resultAsArray);
		
		assertEquals(expectedCoinsValue, result, 0.01);
	}
	
	@Test
	public void shouldCalculateChangeDueAndReturnOnePenny() {
		coinsInserted = underTest.queueCoins(quarter, quarter, quarter, quarter, penny);
		Soda soda = new Soda();
		
		ArrayList<Coin> expectedCoins = new ArrayList<Coin>();
		expectedCoins.add(penny);
		double expectedCoinsValue = underTest.calcValueOfCoinsInQueue(expectedCoins);
		
		ArrayList<Coin> resultAsArray = underTest.returnCoins(coinsInserted, soda);
		double result = underTest.calcValueOfCoinsInQueue(resultAsArray);
		
		assertEquals(expectedCoinsValue, result, 0.01);
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
