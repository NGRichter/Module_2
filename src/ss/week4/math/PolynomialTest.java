package ss.week4.math;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PolynomialTest {

    private static final double DELTA = 1e-15;
    private Polynomial poly;
    private double[] d = {1, 2, 4, 8};

    @Before
    public void setUp() {
        poly = new Polynomial(d);
        System.out.println(poly.integrand().toString());
    }

    @Test
    public void testApply() {
        assertEquals(1248, poly.apply(10), DELTA);
        assertEquals(5, poly.apply(-1), DELTA);

    }

    @Test
    public void testDerivative() {
        assertTrue(poly.derivative() instanceof Sum);
        assertEquals(11, poly.derivative().apply(1), DELTA);
    }
    
    @Test
    public void testIntegrand() {
        assertTrue(poly.integrand() instanceof Sum);
        assertEquals(10.92, poly.integrand().apply(1), 0.1);
    }
}
