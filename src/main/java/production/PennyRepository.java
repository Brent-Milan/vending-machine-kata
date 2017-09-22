package production;
import java.util.ArrayList;

public class PennyRepository {
	ArrayList<Penny> pennyRepo = new ArrayList<Penny>();


	public ArrayList<Penny> getPennyRepo() {
		return pennyRepo;
	}
	
	public void remove(int indexOfElementToRemove) {
		for(int index = 0; index < pennyRepo.size(); index++) {
			if(index == indexOfElementToRemove) {
				pennyRepo.remove(index);
			} 
		}
	}
	
	public ArrayList<Penny> stockPenniesInBank(Penny... penniesAsArrays) {
		for(int index = 0; index < penniesAsArrays.length; index++) {
			pennyRepo.add(penniesAsArrays[index]);
		}
		return pennyRepo;
	}

	protected boolean isStocked() {
		return pennyRepo.size() > 8;
	}
}
