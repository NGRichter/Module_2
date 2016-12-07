package ss.week4.math;

public class Constant implements Function {

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
	
}
