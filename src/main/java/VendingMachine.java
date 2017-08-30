
public class VendingMachine {

	
	public double identifyCoin(Coin coin) {
		int size = coin.getSize();
		int weight = coin.getWeight();
		
		if(size == 4 && weight == 4) {
			return 0.25;
		} if(size == 1 && weight == 1) {
			return 0.10;
		} if(size == 3 && weight == 3) {
			return 0.05;
		}
		return 0.00;
	}
	
	
	
}
