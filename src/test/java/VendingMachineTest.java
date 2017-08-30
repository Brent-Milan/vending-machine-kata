import static org.junit.Assert.*;

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
		Coin quarter = new Coin(4, 4);
		
		double result = 0.25;
		
		assertEquals(result, underTest.identifyCoin(quarter), 0);
	}
	
	@Test 
	public void shouldReturnDimeValue() {
		Coin dime = new Coin(1, 1); 
			
		double result = 0.10;
		
		assertEquals(result, underTest.identifyCoin(dime), 0);
	} 
	 
	@Test
	public void shouldReturnNickelValue() {
		Coin nickel = new Coin(3, 3);
		
		double result = .05;
		
		assertEquals(result, underTest.identifyCoin(nickel), 0);
	}
} 
