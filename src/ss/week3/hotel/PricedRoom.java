package ss.week3.hotel;

public class PricedRoom extends Room implements Bill.Item {
	
	public double price;
	public double safeprice;
	public Safe safe;
	
	public PricedRoom(int number, double price, double safeprice) {
		super(number);
		this.price = price;
		this.safeprice = safeprice;
		safe = new PricedSafe(safeprice);
	}

	@Override
	public double getAmount() {
		return price + safeprice;
	}
	
	@Override
	public String toString() {
		return "Room " + getNumber() + price;
	}
}
