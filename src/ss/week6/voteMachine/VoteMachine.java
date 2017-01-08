package ss.week6.voteMachine;

import ss.week6.voteMachine.gui.VoteGUIView;

public class VoteMachine {
	private PartyList partyList;
	private VoteList voteList;
	private VoteView voteView;
	
	public VoteMachine() {
		partyList = new PartyList();
		voteList = new VoteList();
		voteView = new VoteGUIView(this);
		partyList.addObserver(voteView);
		voteList.addObserver(voteView);
	}
	
	public static void main(String[] args) {
		VoteMachine voteMachine = new VoteMachine();
		voteMachine.start();
	}
	
	public void start() {
		voteView.start();
	}
	
	public void addParty(String party) {
		partyList.addParty(party);
	}
	
	public void vote(String party) {
		voteList.addVote(party);
	}
	
	public PartyList getParties() {
		return partyList;
	}
	
	public VoteList getVotes() {
		return voteList;
	}
}
