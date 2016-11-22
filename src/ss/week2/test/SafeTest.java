package ss.week2.test;

import ss.week2.hotel.Password;
import ss.week2.hotel.Safe;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ss.week2.hotel.Safe;

public class SafeTest {
	private Safe safe;
	@Before
	public void setUp() {
		safe = new Safe();
		
	}
	
	@Test
	public void test() {
		assertFalse(safe.isActive());
		safe.activate("Hallo");
		safe.open("Hallo");
		safe.activate(Password.INITIAL);
		assertTrue(safe.isActive());
		assertFalse(safe.isOpen());
		safe.open(Password.INITIAL);
		assertTrue(safe.isOpen());
		safe.deactivate();
		assertFalse(safe.isOpen());
		assertFalse(safe.isActive());
	}

}
