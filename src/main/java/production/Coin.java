package production;

public class Coin {

	private double sizeInMillimeters;
	private double weightInGrams;
	
	public Coin() {
		
	}
	
	public Coin(double sizeInMillimeters, double weightInGrams) {
		this.sizeInMillimeters = sizeInMillimeters;
		this.weightInGrams = weightInGrams;
	}
	
	public double getSizeInMillimeters() {
		return sizeInMillimeters;
	}
	
	public double getWeightInGrams() {
		return weightInGrams;
	}

	public Coin createQuarter() {
		return new Coin(24.26, 5.67);
	}

	public Coin createDime() {
		return new Coin(17.91, 2.268);
	}

	public Coin createNickel() {
		return new Coin(21.21, 5.0);
	}

	public Coin createPenny() {
		return new Coin(19.05, 2.5);
	}  
	
	

}
