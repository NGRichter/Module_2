package ss.week4.math;

public class Product implements Function {

	public Function a;
	public Function b;
	
	public Product(Function a, Function b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public double apply(double d) {
		return a.apply(d) * b.apply(d);
	}

	@Override
	public Function derivative() {
		return new Sum(new Product(a.derivative(), b), new Product(a, b.derivative()));
	}

}
