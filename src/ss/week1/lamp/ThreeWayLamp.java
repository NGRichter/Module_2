package ss.week1.lamp;

public class ThreeWayLamp {

	public static int a;
	public static void main(String[] args) {
		turnLightON();

	}
	
	public static void turnLightON() {
		Lamp lamp = new Lamp();
		while (a <= 25) {
			System.out.println(lamp.getLightLevel());
			lamp.increaseLevel();
			a++;
		}

	}
	

}
