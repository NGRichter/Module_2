package ss.week6.voteMachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class VoteList extends Observable {
	
	private Map<String, Integer> votes;

	public VoteList() {
		votes = new HashMap<String, Integer>();
	}
	public Map<String, Integer> getVotes() {
		return votes;
	}

	public void addVote(String party) {
		if (votes.get(party) == null) {
			votes.put(party, 1);
		} else {
			int amount = votes.get(party);
			votes.put(party, amount + 1);
		}
		setChanged();
		notifyObservers(party);
	}

}
