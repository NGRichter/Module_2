package ss.week3.hotel;

public class ItemTest implements Bill.Item {

	public String description;
	public double amount;
	
	public ItemTest(String desc, double amount) {
		this.description = desc;
		this.amount = amount;
	}
	
	
	@Override
	public double getAmount() {
		return amount;
	}
	
	@Override
	public String toString() {
		return description;
	}
	
}
