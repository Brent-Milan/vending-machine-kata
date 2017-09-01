
public class Coin {

	private double sizeInMillimeters;
	private double weightInGrams;
	
	public Coin(double sizeInMillimeters, double weightInGrams) {
		this.sizeInMillimeters = sizeInMillimeters;
		this.weightInGrams = weightInGrams;
	}
	
	//getter methods:
	public double getSizeInMillimeters() {
		return sizeInMillimeters;
	}
	
	public double getWeightInGrams() {
		return weightInGrams;
	}


}
