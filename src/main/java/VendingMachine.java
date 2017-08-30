
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
		} if (size == 2 && weight == 2) {
			return 0.01;
		}
		
		return 0.00;
	}
	
	
	
}
