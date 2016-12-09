package ss.week4.math;

public class Exponent implements Integrandable {

	public int e;
	
	public Exponent(int e) {
		this.e = e;
	}
	
	@Override
	public double apply(double d) {

		return Math.pow(d, e);
	}

	@Override
	public Function derivative() {
		return new LinearProduct(new Exponent(e - 1), new Constant(e));
	}

	@Override
	public Function integrand() {
		return new LinearProduct(new Exponent(e + 1), new Constant(1 / (e + 1)));
	}
	
	public String toString() {
		return "x^" + e;
	}

}
