
public class Candy extends Product {
	
	private double cost = 0.65;
	private String costAsString = "0.65";
	private int inventoryCount;
	
	
	public Candy() {
	}
	
	public Candy(int inventoryCount) {
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
