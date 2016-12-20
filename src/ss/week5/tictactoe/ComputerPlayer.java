package ss.week5.tictactoe;

public class ComputerPlayer extends Player {
	
	private static NaiveStrategy naive = new NaiveStrategy();
	private Strategy strategy;
	private Mark mark;
	
	public ComputerPlayer(Mark mark, Strategy strategy) {
		super(strategy.getName() + "-" + mark.toString(), mark);
		this.strategy = strategy;
		this.mark = mark;
	}
	
	public ComputerPlayer(Mark mark) {
		this(mark, naive);
	}

	@Override
	public int determineMove(Board board) {
		return strategy.determineMove(board, mark);	
	}
	
	public Strategy inspect() {
		return strategy;
	}
	
	public void update(Strategy strat) {
		strategy = strat;
	}
}
