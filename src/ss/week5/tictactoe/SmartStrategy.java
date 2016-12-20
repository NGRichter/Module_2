package ss.week5.tictactoe;

public class SmartStrategy implements Strategy {

	@Override
	public String getName() {
		return "Smart";
	}

	@Override
	public int determineMove(Board b, Mark m) {
		int d = directWin(b, m);
		int o = opponentWin(b, m);
		Mark mid = b.getField(b.DIM / 2, b.DIM / 2);
		int middle = b.index(b.DIM / 2, b.DIM / 2);
		
		if (d != -1) {
			return directWin(b, m);
		}
		if (o != -1) {
			return opponentWin(b, m);
		}
		if (mid == Mark.EMPTY) {
			return middle;
		}
		NaiveStrategy naive = new NaiveStrategy();
		return naive.determineMove(b, m);
	}
	
	private int directWin(Board b, Mark m) {
		for (int i = 0; i < b.DIM*b.DIM; i++) {
			Board temp = b.deepCopy();
			if (temp.getField(i) == Mark.EMPTY) {
				temp.setField(i, m);
				if (temp.hasWinner()) {
					return i;
				}
			}
		}
		return -1;
	}
	
	private int opponentWin(Board b, Mark m) {
		for (int i = 0; i < b.DIM*b.DIM; i++) {
			Board temp = b.deepCopy();
			if (temp.getField(i) == Mark.EMPTY) {
				temp.setField(i, m.other());
				if (temp.hasWinner()) {
					return i;
				}
			}
		}
		return -1;		
	}

}
