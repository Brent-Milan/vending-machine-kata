package production;

public class Penny extends Coin {
	
	private final double sizeInMillimeters = 19.05;
	private final double weightInGrams = 2.5;
	
	public double getSizeInMillimeters() {
		return sizeInMillimeters;
	}
	public double getWeightInGrams() {
		return weightInGrams;
	}
}