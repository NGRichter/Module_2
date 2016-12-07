package ss.week4.math;

public class Polynomial implements Function {
	
	public double[] a;
	public LinearProduct[] array;
	
	public Polynomial(double[] a) {
		this.a = a;
		array = new LinearProduct[a.length - 1];
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
		Sum temp;
		Sum perm;
		int o = 0;
		for (int i = 0; i < array.length / 2; i = i + 2) {
			temp = new Sum(array[i], array[i + 1]);
			perm = new Sum(temp, array[array.length - 1 - o]);
			o++;
		}
		
		return null;
	}

}
