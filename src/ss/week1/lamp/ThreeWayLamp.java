package ss.week1.lamp;

public class ThreeWayLamp {
	public static Lamp lamp = new Lamp();
	public static int a;
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
