package ss.week2.lamp;

public class Lamp {
	
	public int setting;
	//@ public invariant setting >=ThreeWayLamp.OFF && setting <= ThreeWayLamp.HIGH;
	public Lamp() {
		setting = 0;
	}
	//@ensures \result >= 0 && \result <= 3;
	public int getLightLevel() {
		return setting;
	}
	//@requires level >= 0 && level <=3;
	public void setLightLevel(int level) {
		setting = level % 4;
	}
	//@ensures \old(setting == ThreeWayLamp.OFF) ==> setting == ThreeWayLamp.LOW;
	//@ensures setting == ThreeWayLamp.LOW ==> setting == ThreeWayLamp.MEDIUM;
	//@ensures setting == ThreeWayLamp.MEDIUM ==> setting == ThreeWayLamp.HIGH;
	//@ensures setting == ThreeWayLamp.HIGH ==> setting == ThreeWayLamp.OFF;
	public void increaseLevel() {
		setting = (setting + 1) % 4;
	}
	//@ensures setting == ThreeWayLamp.OFF ==> setting == ThreeWayLamp.HIGH;
	//@ensures setting == ThreeWayLamp.HIGH ==> setting == ThreeWayLamp.MEDIUM;
	//@ensures setting == ThreeWayLamp.MEDIUM ==> setting == ThreeWayLamp.LOW;
	//@ensures setting == ThreeWayLamp.LOW ==> setting == ThreeWayLamp.OFF;	
	public void decreaseLevel() {
		setting = (setting - 1) % 4;
	}
	
	
}
