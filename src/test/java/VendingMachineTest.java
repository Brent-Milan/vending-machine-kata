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
		Coin quarter = new Coin(24.26, 5.67);
		
		double result = 0.25;
		
		assertEquals(result, underTest.identifyCoin(quarter), 0);
	}
	
	@Test 
	public void shouldReturnDimeValue() {
		Coin dime = new Coin(17.91, 2.268); 
			
		double result = 0.10;
		
		assertEquals(result, underTest.identifyCoin(dime), 0);
	}  
	 
	@Test
	public void shouldReturnNickelValue() {
		Coin nickel = new Coin(21.21, 5.0);
		
		double result = .05;
		
		assertEquals(result, underTest.identifyCoin(nickel), 0);
	}
	
	@Test
	public void shouldReturnPennyValue() {
		Coin penny = new Coin(19.05, 2.5);
		
		double result = 0.01;
		
		assertEquals(result, underTest.identifyCoin(penny), 0);
	}
	
	@Test
	public void shouldReturnExpectedArrayListOfCoins() {
		ArrayList<Coin> expected = new ArrayList<Coin>();
		
		Coin penny = new Coin(19.05, 2.5);
		Coin nickel = new Coin(21.21, 5.0);
		Coin dime = new Coin(17.91, 2.268);
		Coin quarter = new Coin(24.26, 5.67);
		
		expected.add(penny);
		expected.add(nickel);
		expected.add(dime);
		expected.add(quarter);
		
		assertEquals(expected, underTest.queueCoins(penny, nickel, dime, quarter));
	}
	
//	@Test
//	public void ShouldReturnTotalOfCoinValues() {
//		Coin[] coins = new ArrayList();
//	}
} 
