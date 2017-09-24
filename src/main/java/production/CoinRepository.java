package production;
import java.util.ArrayList;

public class CoinRepository {
	ArrayList<Coin> coinRepo = new ArrayList<Coin>();

	public ArrayList<Coin> getPennyRepo() {
		return coinRepo;
	}
	
	public void remove(Object object) {
		coinRepo.remove(object);
	}
	
	public ArrayList<Coin> stockPenniesInBank(Coin... penniesAsArray) {
		for(int index = 0; index < penniesAsArray.length; index++) {
			coinRepo.add(penniesAsArray[index]);
		}
		return coinRepo;
	}

	protected boolean isStocked() {
		return coinRepo.size() > 8;
	}
}
