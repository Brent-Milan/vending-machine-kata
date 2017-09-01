import java.util.ArrayList;

public class VendingMachine {

	private ArrayList<Coin> coins = new ArrayList<Coin>();
	
	public double identifyCoin(Coin coin) {
		double size = coin.getSizeInMillimeters();
		double weight = coin.getWeightInGrams();
		
		if(size == 24.26 && weight == 5.67) {
			return 0.25;
		} if(size == 17.91 && weight == 2.268) {
			return 0.10;
		} if(size == 21.21 && weight == 5.0) {
			return 0.05;
		} if (size == 19.05 && weight == 2.5) {
			return 0.01;
		}
		
		return 0.00;
	} 
	
	public void addCoin(Coin coin) {
		coins.add(coin);
	}
	
	public ArrayList<Coin> queueCoins(Coin... coinsAsArray) {

		for(int index = 0; index < coinsAsArray.length; index++) {
			coins.add(coinsAsArray[index]);
		}
		
		return coins;
	}
	
	
}
