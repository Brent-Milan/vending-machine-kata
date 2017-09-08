
public class Chips extends Product  {
	
	private double cost = 0.50;
	private String costAsString = "0.50";
	private int inventoryCount;
	
	public Chips() {
	}

	public Chips(int inventoryCount) {
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
}
