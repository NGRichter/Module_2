package ss.week4.math;

public class Constant implements Integrandable {

	public double d;
	
	public Constant(double d) {
		this.d = d;
	}
	
	@Override
	public double apply(double b) {
		return d;
		
	}

	@Override
	public Function derivative() {
		return new Constant(0);
	}
	
	@Override
	public String toString() {
		String s = "";
		s += this.d;
		return s;
	}

	@Override
	public Function integrand() {

		return new LinearProduct(new Exponent(1), new Constant(d));
	}
}
