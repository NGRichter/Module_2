package ss.week2.lamp;

public class ThreeWayLamp {
	public static Lamp lamp = new Lamp();
	public static int a;
	public static final int OFF = 0;
	public static final int LOW = 1;
	public static final int MEDIUM = 2;
	public static final int HIGH = 3;
	public static void main(String[] args) {
		turnLightON();

	}
	
	public static void turnLightON() {

		while (a <= 24) {
			System.out.println(lamp.getLightLevel());
			lamp.increaseLevel();
			a++;
		}

	}
	

}
