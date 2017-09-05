
public class Soda extends Product {
	
	private double cost = 1.00;
	private String costAsString = "1.00";
	
	public Soda() {
	}
	
	public double getCost() {
		return cost;
	}
	
	@Override
	public String getCostAsString() {
		return costAsString;
	}
	
} 

