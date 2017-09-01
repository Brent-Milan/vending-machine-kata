import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {
	
	private VendingMachine underTest;

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
		ArrayList<Coin> expectedList = new ArrayList<Coin>();
		
		Coin penny = generatePenny();
		Coin nickel = generateNickel();
		Coin dime = generateDime();
		Coin quarter = generateQuarter();
		
		expectedList.add(penny);
		expectedList.add(nickel);
		expectedList.add(dime);
		expectedList.add(quarter);
		
		assertEquals(expectedList, underTest.queueCoins(penny, nickel, dime, quarter));
	} 
	
	@Test
	public void shouldCalculateValueOfQueuedCoinsTo41Cents() {
		ArrayList<Coin> coinsList = createArrayWithOneOfEachCoinType();
		
		assertEquals(00.41, underTest.calcTotalValueOfCoinsInQueue(coinsList), .001);
	} 
	
	public void shouldCalculateValueOfGivenCoinsTo1() {
		ArrayList<Coin> coins = new ArrayList<Coin>();
		
		Coin penny = generatePenny();
		Coin nickel = generateNickel();
		Coin dime = generateDime();
		Coin quarter = generateQuarter();
		
		coins = underTest.queueCoins(quarter,quarter, dime, dime, dime, nickel, nickel, nickel, penny, penny, penny, penny, penny);
		
		assertEquals(1.00, underTest.calcTotalValueOfCoinsInQueue(coins), 0);
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
