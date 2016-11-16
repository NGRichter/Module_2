package ss.week1.test;


/**
 * Testprogram for Dollars and Cents Counter.
 * Lab Exercise SoftwareSystems
 * //author Jip Spel
 * //version $Revision: 1.0 $
 */
public class DollarsAndCentsCounterTest {
    /** Testvariabele for a <tt>DollarsAndCentsCounter</tt> object. */
    private static DollarsAndCentsCounter counter;
    private static boolean worked = true;

    /**
     * Sets the instance variable <tt>counter</tt> to a well-defined initial value.
     */
    //Before
    public static void main(String[] args) {
    	
    	setUp();
    	workedFine();
    	testDollars();
    	workedFine();
    	testReset();
    	workedFine();
    	testCents();
    	workedFine();
    	testReset();
    	workedFine();
    	testAdd();
    	workedFine();
    	
    	
    	
    }
    public static void setUp() {
        counter = new DollarsAndCentsCounter();
        counter.reset();
    }

    /**
     * Test the method <tt>dollars()</tt>
     */
    //Test
    public static void testDollars() {
        counter.add(5, 0);
        assertEquals(5, counter.dollars());
        counter.add(0, 100);
        assertEquals(6, counter.dollars());
    }

    /**
     * Test the method <tt>cents()</tt>
     */
    //Test
    public static void testCents() {
        counter.add(0, 5);
        assertEquals(5, counter.cents());
        counter.add(0, 95);
        assertEquals(0, counter.cents());
    }

    /**
     * Test the method <tt>add(dollars, cents)</tt>
     */
    //Test
    public static void testAdd() {
        counter.add(0, 10);
        assertEquals(0, counter.dollars());
        assertEquals(10, counter.cents());
        counter.add(2, 95);
        assertEquals(3, counter.dollars());
        assertEquals(5, counter.cents());
    }

    /**
     * Test the method <tt>reset()</tt>
     */
    //Test
    public static void testReset() {
        counter.add(22, 33);

        counter.reset();
        assertEquals(0, counter.dollars());
        assertEquals(0, counter.cents());
    }
    
    public static void assertEquals(int a, int b) {
    	if (a == b) {
    		int c = a;
    	} else {
    		worked = false;
    	}
    }
    
    public static void workedFine() {
    	if (worked) {
    		System.out.println("Worked fine");   		
    	} else {
    		System.out.println("Didn't work");
    	}

    }
}
