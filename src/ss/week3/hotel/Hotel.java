package ss.week3.hotel;

import java.util.ArrayList;

public class Hotel {
	public static ArrayList<PricedRoom> rooms;
	public static ArrayList<Guest> guests;
	public final Password pass;
	public String names;
	
	public static void main(String[] arg) {
		Hotel hotel = new Hotel("hotel");
		hotel.addRoom(102, 120, 50);
		hotel.addRoom(100, 50, 5);
		
		hotel.addGuest("Lars");
		hotel.addGuest("Lars2");
		hotel.addGuest("Lars3");

		for (PricedRoom room : rooms) {
			System.out.println(room.getNumber());
		}
		for (Guest guest : guests) {
			System.out.println(guest.getName());
		}
		hotel.addRoom(101, 100, 20);
		for (PricedRoom room : rooms) {
			System.out.println(room.getNumber());
		}
		hotel.checkIn(hotel.getPassword(), "Nick", 10);
		System.out.println(hotel.toString());
		if (hotel.getRoom("Nick2") == null) {
			System.out.println("Nick2 does not have a room");
		} else {
			System.out.println("Nick2 does have a room");
		}
		hotel.delGuest("Lars2");
		for (Guest guest : guests) {
			System.out.println(guest.getName());
		}
		hotel.getBill("Nick").close();
		
	}
	/**
	 * Makes an hotel with no rooms or guests.
	 * @param Name of the hotel
	 */
	public Hotel(String names) {
		this.names = names;
		rooms = new ArrayList<PricedRoom>();
		guests = new ArrayList<Guest>();
		pass = new Password();
		pass.setWord(Password.INITIAL, "Bitgroup105");
	}
	
	public Bill getBill(String name) {
		Bill bill = new Bill(System.out);
		for (Guest gexists : guests) {
			if (gexists.getName().equals(name)) {
				for (int i = 1; i <= gexists.getNights(); i++) {
					Bill.Item room = new PricedRoom(gexists.getRoom().getNumber(), 
							gexists.getRoom().getAmount(), 
							gexists.getRoom().getSafe().getAmount());
					bill.newItem(room);
				}
			}
		}
		return bill;
	}
	
	/**
	 * Add a room to the hotel.
	 * @param Roomnumber, price, safeprice
	 */
	public void addRoom(int number, double price, double safeprice) {
		for (PricedRoom exist : rooms) {
			if (exist.getNumber() == number) {
				return;
			}
		}
		PricedRoom room = new PricedRoom(number, price, safeprice);
		if (rooms.size() == 0) {
			rooms.add(room);
		} else {
			int i = 0;
			for (PricedRoom exist : rooms) {
				if (exist.getNumber() > room.getNumber()) {
					rooms.add(i, room);
					return;
				}
				i++;
			}
			rooms.add(room);
		}
	}
	/**
	 * Add a guest to the hotel.
	 * @param Name of guest
	 */
	public void addGuest(String name) {
		for (Guest exist : guests) {
			if (exist.getName().equals(name)) {
				return;
			}
		}
		Guest guest = new Guest(name);
		guests.add(guest);
	}
	/**
	 * Removes a guest from the hotel.
	 * @param Name of guest
	 */
	public void delGuest(String name) {
		for (Guest exist : guests) {
			if (exist.getName().equals(name)) {
				guests.remove(exist);
				return;
			}
		}
	}
	
	/**
	 * Checks a new guest into a room (guest must not yet exist).
	 * @param Password of hotel
	 * @param Guest name
	 * @return The room the guest is renting
	 */
	public PricedRoom checkIn(Password pw, String guest, int nights) {
		for (Guest existg : guests) {
			if (existg.getName().equals(guest)) {
				return null;
			}
		}
		PricedRoom freeroom = getFreeRoom();
		if (freeroom != null) {
			if (pw == pass) {
				addGuest(guest);
				for (Guest existg : guests) {
					if (existg.getName().equals(guest)) {
						if (existg.checkin(freeroom, nights)) {
							return freeroom;
						}
					}
				}
			}			
		}
		return null;
	}
	/**
	 * Check a guest out of a room.
	 * @param Name of guest
	 * @return true if succeeded
	 * @return false if not succeeded
	 */
	public boolean checkOut(String name) {
		for (Guest existg : guests) {
			if (existg.getName().equals(name)) {
				if (existg.checkout()) {
					delGuest(existg.getName());
					return true;	
				}
			}
		}
		return false;
	}
	/**
	 * Returns a free room if there is any.
	 * @return a free room
	 * @return if no free room returns null
	 */
	public PricedRoom getFreeRoom() {
		for (PricedRoom room : rooms) {
			if (room.getGuest() == null) { 
				return room;				
			} 
		}
		return null;
	}
	/**
	 * Get the room when given a guest name.
	 * @param name of guest
	 * @return room of guest
	 * @return if no guest with that name exist return null
	 */
	public PricedRoom getRoom(String name) {
		for (PricedRoom room : rooms) {
			if (room.getGuest() != null) {
				if (room.getGuest().getName().equals(name)) {
					return room;					
				}

			}
		}
		return null;
	}
	/**
	 * Get hotel password.
	 * @return password
	 */
	public Password getPassword() {
		return pass;
	}
	/**
	 * Prints the object.
	 */
	public String toString() {
		String all = "The hotel consists of: ";
		for (PricedRoom existr : rooms) {
			all += "\n Room " + existr.getNumber();
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
	/**
	 * Returns name of hotel.
	 * @return name of hotel
	 */
	public String getName() {
		return names;
	}
}
