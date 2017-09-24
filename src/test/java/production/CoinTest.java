package production;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CoinTest {
	
	Coin underTest;
	BankController bank;

	@Before
	public void setUp() throws Exception {
		underTest = new Coin();
		bank = new BankController();
	}

	@Test
	public void shouldReturnACoinWithQuarterAttributes() {
		Coin quarter = underTest.createQuarter();
		
		assertEquals(0.25, bank.identifyCoin(quarter), 0.001);
	}
	
	@Test
	public void shouldReturnACoinWithDimeAttributes() {
		Coin dime = underTest.createDime();
		
		assertEquals(0.1, bank.identifyCoin(dime), 0.001);
	}

}
