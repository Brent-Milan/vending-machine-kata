import java.util.ArrayList;
import java.util.List; 

public class VendingMachine {

	private ArrayList<Coin> coinsInserted = new ArrayList<Coin>();
	
	private ArrayList<Coin> coinsToReturn = new ArrayList<Coin>();
	
	private QuarterRepository quarterBank = new QuarterRepository();
	private DimeRepository dimeBank = new DimeRepository();
	private NickelRepository nickelBank = new NickelRepository();
	private PennyRepository pennyBank = new PennyRepository();
	
	protected boolean sodaButtonIsPressed = false;
	protected boolean chipsButtonIsPressed = false;
	protected boolean candyButtonIsPressed = false;

	protected boolean changeBankIsLow;
	
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
		while(changeIsDue(difference))
			if(isDueAQuarterOrMore(difference)) {
				difference = removeQuarterFromBankAndReturnAsChange(difference);
			} else if (isDueADimeOrMore(difference)) {
				difference = removeDimeFromBankAndReturnAsChange(difference);
			} else if (isDueANickelOrMore(difference)) {
				difference = removeNickelFromBankAndReturnAsChange(difference);
			} else if (isDueAPennyOrMore(difference)) {
				difference = removePennyFromBankAndReturnAsChange(difference);
			}	
		return coinsToReturn;
	}

	private double removePennyFromBankAndReturnAsChange(double difference) {
		pennyBank.remove(0);
		Penny penny = new Penny();
		coinsToReturn.add(penny);
		difference -= 0.05;
		return difference;
	}

	private double removeNickelFromBankAndReturnAsChange(double difference) {
		nickelBank.remove(0);
		Nickel nickel = new Nickel();
		coinsToReturn.add(nickel);
		difference -= 0.05;
		return difference;
	}

	private double removeDimeFromBankAndReturnAsChange(double difference) {
		dimeBank.remove(0);
		Dime dime = new Dime();
		coinsToReturn.add(dime);
		difference -= 0.1;
		return difference;
	}

	private double removeQuarterFromBankAndReturnAsChange(double difference) {
		quarterBank.remove(0);
		Quarter quarter = new Quarter();
		coinsToReturn.add(quarter);
		difference -= 0.25;
		return difference;
	}

	private boolean isDueAPennyOrMore(double difference) {
		return difference >= 0.01;
	}

	private boolean isDueANickelOrMore(double difference) {
		return difference >= 0.05;
	}

	private boolean isDueADimeOrMore(double difference) {
		return difference >= 0.1;
	}

	private boolean isDueAQuarterOrMore(double difference) {
		return difference >= 0.25;
	}

	private boolean changeIsDue(double difference) {
		return difference >= 0.001;
	}   
	
	public boolean isSufficientPayment(ArrayList<Coin> coins, Product product) {
		return calcValueOfCoinsInQueue(coins) >= product.getCost();
	}
	
	public String updateDisplay(ArrayList<Coin> coins, Product product) {
		if(buttonIsPressedAndProductIsOutOfStock(product)) {
			return "SOLD OUT";
		}
		if(paymentIsSufficientAndProductIsInStock(product)) {
			vendSelectedProduct(coins, product); 
			return "THANK YOU"; 
		} 
		if(productButtonIsPressed()) { 
			return "PRICE " + product.getCostAsString();
		}
		if(changeBankIsLow == true) {
			return "EXACT CHANGE ONLY";
		}
		if(coins.isEmpty() || coins == null) { 
			return "INSERT COIN";
		} else {   
			return "error"; 
		}       
	}   
	
	protected void checkIfBankChangeIsLow() {
		if(quarterBank.isStocked() && dimeBank.isStocked() && nickelBank.isStocked() && pennyBank.isStocked()) {
			changeBankIsLow = false;
		} else {
			changeBankIsLow = true;
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
