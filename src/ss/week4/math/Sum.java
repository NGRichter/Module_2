package ss.week4.math;

public class Sum implements Integrandable {

	public Function a;
	public Function b;
	
	public Sum(Function a, Function b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public double apply(double d) {
		return a.apply(d) + b.apply(d);
	}

	@Override
	public Function derivative() {
		return new Sum(a.derivative(), b.derivative());
	}

	@Override
	public Function integrand() {
		if (a instanceof Integrandable && b instanceof Integrandable) {
			return new Sum(((Integrandable) a).integrand(), ((Integrandable) b).integrand());
		}
		return null;
	}
	
	@Override
	public String toString() {
		String s = "";
		s += a.toString() + " + " + b.toString();
		return s;
	}

}
