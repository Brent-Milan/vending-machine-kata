import java.util.ArrayList;

public class QuarterRepository {
	
	private ArrayList<Coin> quarterRepo = new ArrayList<Coin>();

	public ArrayList<Coin> getQuarterRepo() {
		return quarterRepo;
	}

	public void remove(int indexOfElementToRemove) {
		for(int index = 0; index < quarterRepo.size(); index++) {
			if(index == indexOfElementToRemove) {
				quarterRepo.remove(index);
			} 
		}
		
	}
}
