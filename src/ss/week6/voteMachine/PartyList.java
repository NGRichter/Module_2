package ss.week6.voteMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class PartyList extends Observable {
	private List<String> parties; 
	
	public PartyList() {
		parties = new ArrayList<String>();
		parties.add("VVD");
		parties.add("PVV");
		parties.add("PvdA");
	}
	
	public void addParty(String party) {
		parties.add(party);
		setChanged();
		notifyObservers(party);
	}
	
	public boolean hasParty(String party) {
		for (String part : parties) {
			if (party.equalsIgnoreCase(part)) {
				return true;
			}
		}
		return false;
	}
	
	public List<String> getParties() {
		return parties;
	}
}
