package ss.week4.math;

public class Exponent implements Function {

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

}
