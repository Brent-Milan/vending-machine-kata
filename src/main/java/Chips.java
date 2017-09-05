
public class Chips extends Product  {
	
	private double cost = 0.50;
	private String costAsString = "0.50";
	
	public Chips() {
	}

	public double getCost() {
		return cost;
	}
	
	@Override
	public String getCostAsString() {
		return costAsString;
	}
}
