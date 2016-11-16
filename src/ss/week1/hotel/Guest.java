package ss.week1.hotel;

/**
 * Guest with name and possibly a room.
 * @author Julian Flapper and Nick Richter
 * @version 1.0
 */

public class Guest {
    // ------------------ Instance variables ----------------
	private String guest;
	private Room room;

    // ------------------ Constructor ------------------------

    /**
     * Creates a <code>Guest</code> with a given name, without a room.
     * @param guest string of the new <code>Guest</code>
     */
	
	public Guest(String guest) {
		this.guest = guest;
	}
    // ------------------ Queries --------------------------

    /**
     * Checks the <code>Guest</code> into the room.
     */	
	public boolean checkin(Room r) {
		if (r.getGuest() == null && (room == null)) {
			r.setGuest(this);
			room = r;
			return true;
		} else {
			return false;
		}
	}
    /**
     * Checks the <code>Guest</code> out of the room.
     */		
	public boolean checkout() {
		if (room != null) {
			room.setGuest(null);
			room = null;
			return true;
		} else {
			return false;
		}

	}
    /**
     * Returns the name of the <code>Guest</code>.
     * @return the name of the <code>Guest</code>;
     */		
	public String getName() {
		return guest;
	}
    /**
     * Returns the room of the <code>Guest</code>.
     * @return the room of this <code>Guest</code>;
     *         <code>null</code> if this <code>Guest</code> 
     *         is not currently checked in
     */		
	public Room getRoom() {
		return room;
	}
	/**
	 * Returns a string with the variables
	 * @return a string with variables of the object;
	 */
	public String toString() {
		if (room != null) {
			return "Name of guest: " + guest + "/nRoom of the customer: " + room;			
		} else {
			return "Name of guest: " + guest;
		}

	}

}
