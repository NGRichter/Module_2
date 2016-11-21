package ss.week2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class RectangleTest {

    private Rectangle rec1;

    private Rectangle rec2;



    @Before
    public void setUp() {

        rec1 = new Rectangle(5, 6);
        rec2 = new Rectangle(2, 4);
    }

    @Test
    public void testInitialcondition() {
        assertEquals(5, rec1.length());
        assertEquals(6, rec1.width());
        assertEquals(30, rec1.area());
        assertEquals(22, rec1.perimeter());
    }
    @Test
    public void testInitialcondition2() {
        assertEquals(2, rec2.length());
        assertEquals(4, rec2.width());
        assertEquals(8, rec2.area());
        assertEquals(12, rec2.perimeter());
    }
}
