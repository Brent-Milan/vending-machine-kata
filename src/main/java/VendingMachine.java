import java.util.ArrayList; 

public class VendingMachine {

	private ArrayList<Coin> coins = new ArrayList<Coin>();
	
	protected boolean sodaButtonIsPressed = false;
	protected boolean chipsButtonIsPressed = false;
	protected boolean candyButtonIsPressed = false;	
	
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

	public double calcValueOfCoinsInQueue(ArrayList<Coin> coinsList) {
		double total = 0;
		for(Coin current: coinsList) {
			total += identifyCoin(current);
		}
		return total;
	}
	
	public double calcChangeDue(ArrayList<Coin> coins, Product product) {
		double valueOfCoins = calcValueOfCoinsInQueue(coins);
		double difference = valueOfCoins - product.getCost();
		return difference;
	} 
	
	public boolean isSufficientPayment(ArrayList<Coin> coins, Product product) {
		return calcValueOfCoinsInQueue(coins) >= product.getCost();
	}
	
	public String updateDisplay(ArrayList<Coin> coins, Product product) {
		if(buttonIsPressedAndProductIsOutOfStock(product)) {
			return "Out of Stock";
		}
		if( (isSufficientPayment(coins, product) && product.getInventoryCount() > 0 && sodaButtonIsPressed) ||
			(isSufficientPayment(coins, product) && product.getInventoryCount() > 0 && candyButtonIsPressed)||
			(isSufficientPayment(coins, product) && product.getInventoryCount() > 0 && chipsButtonIsPressed)) {
			vendSelectedProduct(coins, product); 
			return "THANK YOU"; 
		} 
		if(sodaButtonIsPressed || chipsButtonIsPressed || candyButtonIsPressed) { 
			return "PRICE " + product.getCostAsString();
		}
		if(coins.isEmpty() || coins == null) { 
			return "INSERT COIN";
		} else {   
			return "error"; 
		}      
	}  
	
	public String displaySodaCost() {
		Soda soda = new Soda();
		return soda.getCostAsString();
	} 
	
	public String displayChipsCost() {
		Chips bagOfChips = new Chips();
		return bagOfChips.getCostAsString();
	}
	
	public String displayCandyCost() {
		Candy candy = new Candy();
		return candy.getCostAsString();
	}
	
	public void vendSelectedProduct(ArrayList<Coin> coins, Product product) {
		if(isSufficientPayment(coins, product)) {
			product.vendItem();
		}
	} 
	
	public boolean buttonIsPressedAndProductIsOutOfStock(Product product) {
		if( (sodaButtonIsPressed && product.getInventoryCount() == 0) || 
				(candyButtonIsPressed && product.getInventoryCount() == 0) ||
				(chipsButtonIsPressed && product.getInventoryCount() == 0) ) {
			return true;
		}
		return false;
	}
	 
}
