package ss.week1.lamp;

public class Lamp {
	
	private int setting;
	
	/** A lamp is made in the OFF mode.*/
	public Lamp() {
		setting = 0;
	}
	/**Get the light level.*/
	public int getLightLevel() {
		return setting;
	}
	/**Sets the light level.*/
	//@requires level >= 0 && level <= 3;
	public void setLightLevel(int level) {
		setting = level % 4;
	}
	/** Increase the level by 1.*/
	public void increaseLevel() {
		setting = (setting + 1) % 4;
	}
	/** Decrease the level by 1.*/
	public void decreaseLevel() {
		setting = (setting - 1) % 4;
	}
	
	
}
