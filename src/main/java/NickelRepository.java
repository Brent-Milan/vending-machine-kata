import java.util.ArrayList;

public class NickelRepository {
	
	ArrayList<Nickel> nickelRepo = new ArrayList<Nickel>();

	public ArrayList<Nickel> getNickelRepo() {
		return nickelRepo;
	}

	public void remove(int indexOfElementToRemove) {
		for(int index = 0; index < nickelRepo.size(); index++) {
			if(index == indexOfElementToRemove) {
				nickelRepo.remove(index);
			} 
		}
	}

	public ArrayList<Nickel> stockNickelsInBank(Nickel... nickelsAsArray) {
		for(int index = 0; index < nickelsAsArray.length; index++) {
		nickelRepo.add(nickelsAsArray[index]);
		}
		return nickelRepo;
	}

	public boolean isStocked() {
		return nickelRepo.size() > 1;
	}
}
