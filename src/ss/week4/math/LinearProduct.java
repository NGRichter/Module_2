package ss.week4.math;

public class LinearProduct extends Product implements Integrandable {
	
	public LinearProduct(Function a, Constant b) {
		super(a, b);
	}
	
	public Function derivative() {
		return new LinearProduct(super.a.derivative(), (Constant) super.b);
	}

	@Override
	public Function integrand() {
		if (super.a instanceof Integrandable && super.b instanceof Constant) {
			return new LinearProduct(((Integrandable) super.a).integrand(), (Constant) super.b);
		}
		return null;
	}
	
	public String toString() {
		return super.b + " * (" + super.a + ")";
	}

}
