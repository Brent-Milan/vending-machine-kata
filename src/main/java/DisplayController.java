import java.util.ArrayList;

public class DisplayController {
	
	VendingMachine bankController = new VendingMachine();
	
	protected boolean sodaButtonIsPressed = false;
	protected boolean chipsButtonIsPressed = false;
	protected boolean candyButtonIsPressed = false;

	protected boolean changeBankIsLow;
	
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
		if(bankController.quarterBank.isStocked() && bankController.dimeBank.isStocked() && bankController.nickelBank.isStocked() && bankController.pennyBank.isStocked()) {
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
		if(bankController.isSufficientPayment(coins, product)) {
			product.vendItem();
		}
	} 
	
	/******************************
	 * Button-Related Booleans
	 *****************************/
	
	public boolean buttonIsPressedAndProductIsOutOfStock(Product product) {
		if( (sodaButtonIsPressed && product.getInventoryCount() == 0) || 
			(candyButtonIsPressed && product.getInventoryCount() == 0) ||
			(chipsButtonIsPressed && product.getInventoryCount() == 0) ) {
			return true;
		}
		return false;
	}
	
	public boolean paymentIsSufficientAndProductIsInStock(Product product) {
		if( (bankController.isSufficientPayment(bankController.getCoinsInserted(), product) && product.getInventoryCount() > 0 && sodaButtonIsPressed) ||
			(bankController.isSufficientPayment(bankController.getCoinsInserted(), product) && product.getInventoryCount() > 0 && candyButtonIsPressed)||
			(bankController.isSufficientPayment(bankController.getCoinsInserted(), product) && product.getInventoryCount() > 0 && chipsButtonIsPressed)) {
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
	
}