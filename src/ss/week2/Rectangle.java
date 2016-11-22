package ss.week2;

public class Rectangle {
    private int length;
    private int width;
    //@private invariant length > 0;
    //@private invariant width > 0;
    
    /**
     * Create a new Rectangle with the specified length and width.
     * @requires that the length and the width be more than 0;
     */
    
    //@requires theLength > 0 && theWidth > 0;
    public Rectangle(int theLength, int theWidth) {
    	length = theLength;
    	width = theWidth;
    	assert length > 0;
    	assert width > 0;
    }
    
    /**
     * The length of this Rectangle.
     * @ensures that length is more than 0;
     */
    
    //@ensures \result > 0;
    public int length() {
    	assert length > 0;
    	return length;
    }

    /**
     * The width of this Rectangle.
     * @ensures that width is more than 0;
     */
    
    //@ ensures \result > 0;
    public int width() {
    	assert width > 0;
    	return width;
    }

    /**
     * The area of this Rectangle.
     * @ensures that area is more than 0;
     */
    
    //@ensures \result > 0;
    public int area() {
    	assert length > 0;
    	assert width > 0;
    	return length * width;
    }

    /**
     * The perimeter of this Rectangle.
     * @ensures that perimeter is more than 0;
     */
    
    //@ensures \result > 0;
    public int perimeter() {
    	assert length > 0;
    	assert width > 0;
    	return 2 * length + 2 * width;
    }
}
