package ss.week3.hotel;

import java.io.PrintStream;
import java.util.ArrayList;

public class Bill {
	
	public interface Item {
		public double getAmount();
	}
	public PrintStream outStream;
	public ArrayList<Bill.Item> bill;
	
	public Bill(PrintStream outStream) {
		this.outStream = outStream;
		bill = new ArrayList<Bill.Item>();
	}
	
	public void close() {
		double total;
		for (Bill.Item item : bill) {
			total += item.getAmount();
		}
		;
	}
	
	public double getSum(){
		
	}
}
