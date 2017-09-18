import java.util.ArrayList;

public class QuarterRepository {
	
	ArrayList<Quarter> quarterRepo = new ArrayList<Quarter>();

	public ArrayList<Quarter> getQuarterRepo() {
		return quarterRepo;
	}

	public void remove(int indexOfElementToRemove) {
		for(int index = 0; index < quarterRepo.size(); index++) {
			if(index == indexOfElementToRemove) {
				quarterRepo.remove(index);
			} 
		}
	}

	public ArrayList<Quarter> stockQuartersInBank(Quarter... quartersAsArray) {
		for(int index = 0; index < quartersAsArray.length; index++) {
		quarterRepo.add(quartersAsArray[index]);
		}
		return quarterRepo;
	}

	protected boolean isStocked() {
		return quarterRepo.size() > 4;	
	}
}
