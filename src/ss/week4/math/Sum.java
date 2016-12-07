package ss.week4.math;

public class Sum implements Function {

	public Function a;
	public Function b;
	
	public Sum(Function a, Function b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public double apply(double d) {
		// TODO Auto-generated method stub
		return a.apply(d) + b.apply(d);
	}

	@Override
	public Function derivative() {
		// TODO Auto-generated method stub
		return new Sum(a.derivative(), b.derivative());
	}

}
