package ss.week1.test;

public class DollarsAndCentsCounter {
	
	private int dollars;
	private int cents;
	
	public DollarsAndCentsCounter() {
		dollars = 0;
		cents = 0;
	}
	
	public int dollars() {
		if (dollars >= 0) {
			return dollars; 
		} else {
			return 0;
		}
	}
	
	public int cents() {
		if (cents >= 0 && cents <= 99) {
			return cents;
		} else {
			return 0;
		}
	}
	
	public void add(int dollar, int cent) {
		this.dollars += dollar;
		this.cents += cent;
		while (this.cents >= 100) {
			this.dollars += 1;
			this.cents += -100;
		}
	}
	public void reset() {
		this.dollars = 0;
		this.cents = 0;
	}
	
	public void subtract(int dollar, int cent) {
		this.dollars -= dollar;
		this.cents -= cent;
		while (this.cents < 0) {
			this.dollars -= 1;
			this.cents += 100;
		}		
	}
}
		

