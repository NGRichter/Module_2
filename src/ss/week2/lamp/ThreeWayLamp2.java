package ss.week2.lamp;


public class ThreeWayLamp2 {
	public static int a = 0;
	public static Lamp2 lamp2;
	public static void main(String[] args) {
		turnLightON();

	}
	
	public static void turnLightON() {
		lamp2 = new Lamp2(Lamp2.Setting.OFF);
		while (a < 25) {
			System.out.println("Lamp is in the " + lamp2.setting + " state.");
			lamp2.increaseLightLevel();
			a++;
		}


	}
	

}
