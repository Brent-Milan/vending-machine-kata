package production;

public class Soda extends Product {
	
	private double cost = 1.00;
	private String costAsString = "1.00";
	
	private int inventoryCount;
	
	public Soda() {
	}
	
	public Soda(int inventoryCount) {
		this.inventoryCount = inventoryCount;
	}

	public double getCost() {
		return cost;
	}
	
	@Override
	public String getCostAsString() {
		return costAsString;
	}
	
	@Override
	public int getInventoryCount() {
		return inventoryCount;
	} 
	
	@Override
	public void vendItem() {
		inventoryCount -= 1;
	}
	
} 

