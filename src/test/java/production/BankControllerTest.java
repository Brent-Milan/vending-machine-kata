package production;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class BankControllerTest {
	
	private BankController underTest;
	Coin coin = new Coin();
	
	ArrayList<Coin> coinsInserted = new ArrayList<Coin>();
	
	Coin penny = coin.createPenny();
	Coin nickel = coin.createNickel();
	Coin dime = coin.createDime();
	Coin quarter = coin.createQuarter();

	@Before
	public void setUp() throws Exception {
		underTest = new BankController();
		
	}

	@Test
	public void shouldReturnQuarterValue() {
		double expected = 0.25;
		
		assertEquals(expected, underTest.identifyCoin(quarter), 0);
	}
	
	@Test 
	public void shouldReturnDimeValue() {	
		double expected = 0.10;
		
		assertEquals(expected, underTest.identifyCoin(dime), 0);
	}  
	 
	@Test
	public void shouldReturnNickelValue() {
		double expected = .05;
		
		assertEquals(expected, underTest.identifyCoin(nickel), 0);
	}
	
	@Test
	public void shouldReturnPennyValue() {
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
	
	private ArrayList<Coin> createArrayWithOneOfEachCoinType() {
		ArrayList<Coin> coins = new ArrayList<Coin>(); 
		

		coins.add(penny);
		coins.add(nickel);
		coins.add(dime);
		coins.add(quarter);
		
		return coins;
	}
	
} 
