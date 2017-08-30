
public class VendingMachine {

	
	public double identifyCoin(Coin coin) {
		int size = coin.getSize();
		int weight = coin.getWeight();
		
		if(size == 4 && weight == 4) {
			return 0.25;
		} if(size == 1 && weight == 1) {
			return 0.10;
		}
		return 0.00;
	}
	
	
	
}
