import java.util.ArrayList;

public class PennyRepository {
	ArrayList<Penny> pennyRepo = new ArrayList<Penny>();


	public ArrayList<Penny> getPennyRepo() {
		return pennyRepo;
	}
	
	public ArrayList<Penny> stockPenniesInBank(Penny... penniesAsArrays) {
		for(int index = 0; index < penniesAsArrays.length; index++) {
			pennyRepo.add(penniesAsArrays[index]);
		}
		return pennyRepo;
	}
}
