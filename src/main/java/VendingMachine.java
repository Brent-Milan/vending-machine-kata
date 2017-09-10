import java.util.ArrayList; 

public class VendingMachine {

	private ArrayList<Coin> coinsInserted = new ArrayList<Coin>();
	
	private ArrayList<Coin> coinsToReturn = new ArrayList<Coin>();
	
//	private ArrayList<Coin> quarterBank = new ArrayList<Coin>();
	private QuarterRepository quarterBank = new QuarterRepository();
	
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
		coinsInserted.add(coin);
	}
	
	public ArrayList<Coin> queueCoins(Coin... coinsAsArray) {
		for(int index = 0; index < coinsAsArray.length; index++) {
		coinsInserted.add(coinsAsArray[index]);
		}
		return coinsInserted;
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
	
	public ArrayList<Coin> returnCoins(ArrayList<Coin> coins, Product product) {
		double difference = calcChangeDue(coins, product);
		while(difference > 0)
			if(difference > 0.25) {
				quarterBank.remove(0);
			}
		return coinsToReturn;
	}
	
	public boolean isSufficientPayment(ArrayList<Coin> coins, Product product) {
		return calcValueOfCoinsInQueue(coins) >= product.getCost();
	}
	
	public String updateDisplay(ArrayList<Coin> coins, Product product) {
		if(buttonIsPressedAndProductIsOutOfStock(product)) {
			return "Out of Stock";
		}
		if(paymentIsSufficientAndProductIsInStock(product)) {
			vendSelectedProduct(coins, product); 
			return "THANK YOU"; 
		} 
		if(productButtonIsPressed()) { 
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
	
	public boolean paymentIsSufficientAndProductIsInStock(Product product) {
		if( (isSufficientPayment(coinsInserted, product) && product.getInventoryCount() > 0 && sodaButtonIsPressed) ||
			(isSufficientPayment(coinsInserted, product) && product.getInventoryCount() > 0 && candyButtonIsPressed)||
			(isSufficientPayment(coinsInserted, product) && product.getInventoryCount() > 0 && chipsButtonIsPressed)) {
			return true;
			}
		return false;
	}
	
	public boolean productButtonIsPressed() {
		if(sodaButtonIsPressed || chipsButtonIsPressed || candyButtonIsPressed) {
			return true;
		}
		return false;
	}
	
	public ArrayList<Coin> getCoinsToReturn() {
		return coinsToReturn;
	}
	
	 
}
