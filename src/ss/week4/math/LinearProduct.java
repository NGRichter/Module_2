package ss.week4.math;

public class LinearProduct extends Product {

	public Function a;
	public Constant b;
	
	public LinearProduct(Function a, Constant b) {
		super(a, b);
		this.a = a;
		this.b = b;
	}
	
	public Function derivative() {
		return new LinearProduct(new Product(a.derivative(), b), new Constant(0));
	}

}
