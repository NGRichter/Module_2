package ss.week5.tictactoe;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ss.week4.tictactoe.*;

public class NaiveStrategy implements Strategy {

	@Override
	public String getName() {
		return "Naive";
	}

	@Override
	public int determineMove(Board b, Mark m) {
		Set<Integer> empty = new HashSet<Integer>();
		for (int i = 0; i < Board.DIM * Board.DIM; i++) {
			if (b.getField(i) == Mark.EMPTY) {
				empty.add(i);
			}
		}
		Iterator<Integer> iterator = empty.iterator();
		int random = (int) (Math.random() * (double) empty.size() + 1);
		for (int i = 0; i < random - 1; i++) {
			iterator.next();
		}
		return iterator.next();
	}

}
