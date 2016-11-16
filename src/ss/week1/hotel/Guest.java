package ss.week1.hotel;

public class Guest {
	private String guest;
	private Room room;
	
	public Guest(String guest) {
		this.guest = guest;
	}
	
	public boolean checkin(Room r) {
		if (r.getGuest() == null && (room == null)) {
			r.setGuest(this);
			room = r;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkout() {
		if (room != null) {
			room.setGuest(null);
			room = null;
			return true;
		} else {
			return false;
		}

	}
	
	public String getName() {
		return guest;
	}
	
	public Room getRoom() {
		return room;
	}
	
	public String toString() {
		if (room != null) {
			return "Name of guest: " + guest + "/nRoom of the customer: " + room;			
		} else {
			return "Name of guest: " + guest;
		}

	}

}
