package ss.week3.hotel;

import static org.junit.Assert.*;

import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class BillTest {
	private Bill.Item item1;
	private Bill.Item item2;
	private Bill.Item item3;
	private Bill bill;
	@Before
	public void setUp() throws Exception {
		item1 = new ItemTest("Cookie", 1.99);
		item2 = new ItemTest("Milk", 2.99);
		item3 = new ItemTest("Chocolate", 666.00);
		PrintStream outstream = System.out;
		bill = new Bill(outstream);
		bill.newItem(item1);
		bill.newItem(item2);
		bill.newItem(item3);
	}

	@Test
	public void priceIsRight() {
		assertEquals("Cookie should be 1.99", item1.getAmount(), 1.99, 0);
		assertEquals("Milk should be 2.99", item2.getAmount(), 2.99, 0);
		assertEquals("Chocolate should be 666.00", item3.getAmount(), 666.00, 0);
		
	}	
	
	@Test
	public void addToBill() {
		assertEquals("Total should be 670.98", bill.getSum(), 670.98, 0);	
	}
	
	@Test
	public void printBill() {
		bill.close();
		
	}

}
