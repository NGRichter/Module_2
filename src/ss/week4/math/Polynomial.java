package ss.week4.math;

public class Polynomial implements Function, Integrandable {
	
	public double[] a;
	public LinearProduct[] array;
	
	public Polynomial(double[] a) {
		this.a = a;
		array = new LinearProduct[a.length];
		int i = 0;
		for (double b : a) {
			array[i] = new LinearProduct(new Exponent(a.length - 1 - i), new Constant(b));
			i++;
		}
	}
	
	@Override
	public double apply(double d) {
		double y = 0;
		for (LinearProduct product : array) {
			y += product.apply(d);
		}
		return y;
	}

	@Override
	public Function derivative() {
		Function cont = new Constant(0);
		int e = 0;
		for (int i = a.length - 2; i >= 0; i--) {
			double d = a[i];
			Function temp = new LinearProduct(new LinearProduct(new Exponent(e), new Constant(d)), 
					new Constant(e + 1));
			cont = new Sum(temp, cont);
			e++;
		}
		
		return cont;
	}

	@Override
	public Function integrand() {
		Function cont = new Constant(0);
		int e = 1;
		for (int i = a.length - 1; i >= 0; i--) {
			double d = a[i];
			Function temp = new LinearProduct(new LinearProduct(new Exponent(e), 
					new Constant((double) 1 / e)), new Constant(d));
			cont = new Sum(temp, cont);
			e++;
		}
		return cont;
	}
	
	public String toString() {
		String tostring = "";
		for (Function func : array) {
			tostring += func.toString();
		}
		return tostring;
	}

}
