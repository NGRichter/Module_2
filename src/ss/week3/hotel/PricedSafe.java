package ss.week3.hotel;

public class PricedSafe extends Safe implements Bill.Item {

	private double price;
	
	public PricedSafe(double price) {
		this.price = price;
	}
	
	@Override
	public double getAmount() {
		return price;
	}
	
	@Override
	public String toString() {
		return "Price is " + price + "€";
	}
	
}
