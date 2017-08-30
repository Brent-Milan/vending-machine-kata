
public class VendingMachine {

	
	public double identifyCoin(Coin coin) {
		int size = coin.getSize();
		int weight = coin.getWeight();
		
		if(size == 4 && weight == 4) {
			return 0.25;
		}
		return 0.00;
	}
	
	
	
}
