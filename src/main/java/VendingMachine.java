import java.util.ArrayList;

public class VendingMachine {

	private ArrayList<Coin> coins = new ArrayList<Coin>();
	
	public double identifyCoin(Coin coin) {
		double size = coin.getSizeInMillimeters();
		double weight = coin.getWeightInGrams();
		
		if(isAQuarter(size, weight)) {
			return 0.25;
		} if(isADime(size, weight)) {
			return 0.10;
		} if(isANickel(size, weight)) {
			return 0.05;
		} if (isAPenny(size, weight)) {
			return 0.01;
		}
		return 0.00;
	}

	private boolean isAPenny(double size, double weight) {
		return size == 19.05 && weight == 2.5;
	}

	private boolean isANickel(double size, double weight) {
		return size == 21.21 && weight == 5.0;
	}

	private boolean isADime(double size, double weight) {
		return size == 17.91 && weight == 2.268;
	}

	private boolean isAQuarter(double size, double weight) {
		return size == 24.26 && weight == 5.67;
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
