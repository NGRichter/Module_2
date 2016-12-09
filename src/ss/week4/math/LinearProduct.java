package ss.week4.math;

public class LinearProduct extends Product implements Integrandable {

	public Function a;
	public Constant b;
	
	public LinearProduct(Function a, Constant b) {
		super(a, b);
		this.a = a;
		this.b = b;
	}
	
	public Function derivative() {
		return new Product(a.derivative(), b);
	}

	@Override
	public Function integrand() {
		if (a instanceof Integrandable && b instanceof Constant) {
			return new LinearProduct(((Integrandable) a).integrand(), (Constant) b);
		}
		return null;
	}
	
	public String toString() {
		return b + " * (" + a + ")";
	}

}
