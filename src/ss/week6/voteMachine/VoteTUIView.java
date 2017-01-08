package ss.week6.voteMachine;

import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class VoteTUIView implements Observer, VoteView {
	private VoteMachine voteMachine;
	
	public VoteTUIView(VoteMachine voteMachine) {
		this.voteMachine = voteMachine;
	}

	public void start() {
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println("What do you command? ");
			String[] input = in.nextLine().split(" ");
			if (input[0].equals("add") && input[1].equals("party")) {
				if (input.length == 3) {
					if (voteMachine.getParties().hasParty(input[2])) {
						showError("Name already exists.");						
					} else {
						voteMachine.addParty(input[2]);		
					}
				 
				} else {
					showError("Name of party is not valid.");
				}
			} else if (input[0].equals("vote")) {
				boolean error = true;
				for (String party : voteMachine.getParties().getParties()) {
					if (party.equalsIgnoreCase(input[1])) {
						voteMachine.vote(party);
						error = false;
						break;
					}
				}
				if (error) {
					showError("Party does not exist.");					
				}
			} else if (input[0].equals("votes")) {
				showVotes(voteMachine.getVotes().getVotes());
			} else if (input[0].equals("parties")) {
				showParties(voteMachine.getParties().getParties());
			} else if (input[0].equals("exit")) {
				break;
			} else if (input[0].equals("help")) {
				System.out.println("Commands:\n\"add party [party]\"\n\"vote [party]\"\n\"votes\"\n\"parties\"\n\"exit\"\n\"help\"");
			} else {
				System.out.println("Cannot understand: " + input[0]);
			}
		}
	}
	
	public void showVotes(Map<String, Integer> votes) {
		for (String party : votes.keySet()) {
			if (votes.get(party) == null) {
				System.out.println(party + " has 0 votes.");
			} else {
				System.out.println(party + " has " + votes.get(party) + " votes.");				
			}

		}
	}
	
	public void showParties(List<String> parties) {
		for (String party : parties) {
			System.out.println(party);
		}
	}
	
	public void showError(String error) {
		System.out.println("An error has occured: " + error);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof PartyList) {
			System.out.println(arg + " was added to party list");
		} else if (o instanceof VoteList) {
			System.out.println("Your vote went to " + arg);
		}
	}
	//Your code can be made smaller, because you don't have to type in what methods should be executed, you just let the observer know you did something and you let the observer deal with it.

}
