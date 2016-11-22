package ss.week2.lamp;

public class Lamp2 {
	
	public enum Setting {
		OFF, LOW, MEDIUM, HIGH;
	}
	
	public Setting setting;
	
	public Lamp2(Setting setting) {
		this.setting = setting;
	}
	
	public Setting getLightLevel() {
		return setting;
	}
	
	public void increaseLightLevel() {
		switch (setting) {
			case OFF:
				setting = Setting.LOW;
				break;
			case LOW:
				setting = Setting.MEDIUM;
				break;
			case MEDIUM:
				setting = Setting.HIGH;
				break;
			case HIGH:
				setting = Setting.OFF;
				break;
		}

			
	}
}
