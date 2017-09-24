package production;
import java.util.ArrayList;

public class NickelRepository {
	
	ArrayList<Coin> nickelRepo = new ArrayList<Coin>();

	public ArrayList<Nickel> getNickelRepo() {
		return nickelRepo;
	}

	public void remove(Object object) {
		nickelRepo.remove(object);
	}

	public ArrayList<Coin> stockNickelsInBank(Coin... nickelsAsArray) {
		for(int index = 0; index < nickelsAsArray.length; index++) {
		nickelRepo.add(nickelsAsArray[index]);
		}
		return nickelRepo;
	}

	public boolean isStocked() {
		return nickelRepo.size() > 1;
	}
}
