package ss.week2.hotel;

public class Hotel {
	public Room k101;
	public Room k102;
	public Guest job;
	public Guest klaas;
	public Safe safe;
	
	public Hotel() {
		k101 = new Room(101);
		k102 = new Room(102);
		job = new Guest("Job");
		klaas = new Guest("Klaas");
	}
	
	public boolean checkin(String pw, Guest guest, Room room) {
		if (guest.checkin(room) && pw == Password.INITIAL) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkOut(Guest guest) {
		if (guest != null) {
			guest.getRoom().getSafe().deactivate();
			guest.checkout(); 
			return true;	
			
		}
		return false;

	}
	
	public Room getFreeRoom() {
		if (k101.getGuest() == null) {
			return k101;
		} else if (k102.getGuest() == null) {
			return k102;
		} else {
			return null;
		}
	}
	
	public Room getRoom(String name) {
		if (job.getName() == name) {
			return job.getRoom();
		}
		if (klaas.getName() == name) {
			return klaas.getRoom();
		}
		return null;
	}
	
	
}
