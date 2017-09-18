import java.util.ArrayList;

public class DimeRepository {
	
	ArrayList<Dime> dimeRepo = new ArrayList<Dime>();

	public ArrayList<Dime> getQuarterRepo() {
		return dimeRepo;
	}
	
	public void remove(int indexOfElementToRemove) {
		for(int index = 0; index < dimeRepo.size(); index++) {
			if(index == indexOfElementToRemove) {
				dimeRepo.remove(index);
			} 
		}
	}

	public ArrayList<Dime> stockDimesInBank(Dime... dimesAsArray) {
		for(int index = 0; index < dimesAsArray.length; index++) {
		dimeRepo.add(dimesAsArray[index]);
		}
			return dimeRepo;
	}

	protected boolean isStocked() {
		return dimeRepo.size() >= 2;
	}
}
