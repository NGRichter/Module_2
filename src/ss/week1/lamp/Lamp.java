package ss.week1.lamp;

public class Lamp {
	
	private int setting;
	public Lamp() {
		setting = 0;
	}
	
	public int getLightLevel() {
		return setting;
	}
	
	public void setLightLevel(int level) {
		setting = level % 4;
	}
	
	public void increaseLevel() {
		setting = (setting + 1) % 4;
	}
	
	public void decreaseLevel() {
		setting = (setting - 1) % 4;
	}
	
	
}
