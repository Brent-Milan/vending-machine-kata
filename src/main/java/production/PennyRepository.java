package production;
import java.util.ArrayList;

public class PennyRepository {
	ArrayList<Coin> pennyRepo = new ArrayList<Coin>();

	public ArrayList<Coin> getPennyRepo() {
		return pennyRepo;
	}
	
	public void remove(Object object) {
		pennyRepo.remove(object);
	}
	
	public ArrayList<Coin> stockPenniesInBank(Coin... penniesAsArray) {
		for(int index = 0; index < penniesAsArray.length; index++) {
			pennyRepo.add(penniesAsArray[index]);
		}
		return pennyRepo;
	}

	protected boolean isStocked() {
		return pennyRepo.size() > 8;
	}
}
