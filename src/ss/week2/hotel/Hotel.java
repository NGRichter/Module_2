package ss.week2.hotel;

import java.util.ArrayList;

public class Hotel {
	public static ArrayList<Room> rooms;
	public ArrayList<Guest> guests;
	public final Password pass;
	public String names;
	
	public static void main(String[] arg) {
		Hotel hotel = new Hotel("hotel");
		hotel.addRoom(102);
		hotel.addRoom(100);

		for (Room room : rooms) {
			System.out.println(room.getNumber());
		}
		hotel.checkIn(hotel.getPassword(), "Nick");
		System.out.println(hotel.toString());
		if (hotel.getRoom("Nick2") == null) {
			System.out.println("Nick2 does not have a room");
		} else {
			System.out.println("Nick2 does have a room");
		}
	}
	
	public Hotel(String names) {
		this.names = names;
		rooms = new ArrayList<Room>();
		guests = new ArrayList<Guest>();
		pass = new Password();
		pass.setWord(Password.INITIAL, "Bitgroup105");
	}
	
	public void addRoom(int number) {
		for (Room exist : rooms) {
			if (exist.getNumber() == number) {
				return;
			}
		}
		Room room = new Room(number);
		rooms.add(room);
	}
	
	public void addGuest(String name) {
		for (Guest exist : guests) {
			if (exist.getName() == name) {
				return;
			}
		}
		Guest guest = new Guest(name);
		guests.add(guest);
	}
	
	public Room checkIn(Password pw, String guest) {
		for (Guest existg : guests) {
			if (existg.getName() == guest) {
				return null;
			}
		}
		Room freeroom = getFreeRoom();
		if (freeroom != null) {
			if (pw == pass) {
				addGuest(guest);
				for (Guest existg : guests) {
					if (existg.getName() == guest) {
						if (existg.checkin(freeroom)) {
							return freeroom;
						}
					}
				}
			}			
		}
		return null;
	}
	
	public boolean checkOut(String name) {
		for (Guest existg : guests) {
			if (existg.getName() == name) {
				if (existg.checkout()) {
					return true;	
				}
			}
		}
		return false;
	}
	
	public Room getFreeRoom() {
		for (Room room : rooms) {
			if (room.getGuest() == null) { 
				return room;				
			} 
		}
		return null;
	}
	
	public Room getRoom(String name) {
		for (Room room : rooms) {
			if (room.getGuest() != null) {
				if (room.getGuest().getName() == name) {
					return room;					
				}

			}
		}
		return null;
	}
	
	public Password getPassword() {
		return pass;
	}
	
	public String toString() {
		String all = "The hotel consists of: ";
		for (Room existr : rooms) {
			all += "\nRoom " + existr.getNumber();
			if (existr.getGuest() != null) {
				all += " with guest " + existr.getGuest().getName();				
			}
			all += " with a safe that is ";
			if (existr.getSafe().isOpen()) {
				all += "open.";
			} else {
				all += "closed.";
			}
		}
		return all;
	}
	
	
}
