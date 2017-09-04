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
		Chips bagOfChips = new Chips(0.50);
		
		coins = underTest.queueCoins(quarter, quarter, dime, dime, dime, nickel, nickel, nickel, penny, penny, penny, penny, penny);
		double expected = 0.50;
		
		assertEquals(expected, underTest.calcChangeDue(coins, bagOfChips), 0);
	} 
	
	@Test
	public void shouldReturnCorrectChangeDueAs35Cents() {
		Candy licorice = new Candy(0.65);
		
		coins = underTest.queueCoins(quarter, quarter, dime, dime, dime, nickel, nickel, nickel, penny, penny, penny, penny, penny);
		double expected = 0.35;
		
		assertEquals(expected, underTest.calcChangeDue(coins, licorice), 0);
	}
	
	@Test
	public void shouldReturnCorrectChangeDueAs0() {
		Soda cola = new Soda(1.00);
		
		coins = underTest.queueCoins(quarter, quarter, dime, dime, dime, nickel, nickel, nickel, penny, penny, penny, penny, penny);
		double expected = 0.00;
		
		assertEquals(expected, underTest.calcChangeDue(coins, cola), 0);
	}
	
	@Test
	public void shouldCheckForSufficientCoinValueAndReturnFalse() {
		Chips bagOfChips = new Chips(0.50);
		coins = underTest.queueCoins(quarter);
		
		assertFalse(underTest.isSufficientPayment(coins, bagOfChips));
	}
	
	@Test
	public void shouldCheckForSufficientCoinValueAndReturnTrue() {
		coins = underTest.queueCoins(quarter, quarter, dime, dime, dime, nickel, nickel, nickel, penny, penny, penny, penny, penny);
		
		Soda cola = new Soda(1.00);
		
		assertTrue(underTest.isSufficientPayment(coins, cola));
	}
	
	@Test
	public void shouldReturnInsertChangeStringForInsufficientCoinValue() {
		coins = underTest.queueCoins(quarter, nickel);
		Soda cola = new Soda(1.00);
		
		String expected = "INSERT COIN";
		
		assertEquals(expected, underTest.display(coins, cola));
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
