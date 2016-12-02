package ss.week3.hotel;

import java.io.PrintStream;
import java.util.ArrayList;

import ss.week3.Format;

public class Bill {
	
	public static interface Item {
		public double getAmount();
		public String toString();
	}
	public PrintStream outStream;
	public ArrayList<Bill.Item> bill;
	
	public Bill(PrintStream outStream) {
		this.outStream = outStream;
		bill = new ArrayList<Bill.Item>();
	}
	
	public void close() {
		double total = 0;
		for (Bill.Item item : bill) {
			total += (double) item.getAmount();
		}
		String print = Format.printLine("Total: ", total);
		outStream.println(print);
	}
	
	public void newItem(Bill.Item item) {
		bill.add(item);
		String print = Format.printLine(item.toString(), item.getAmount());
		outStream.println(print);
	}
	
	public double getSum() {
		double total = 0;
		for (Bill.Item item : bill) {
			total += (double) item.getAmount();
		}
		return total;
	}
}
