package ss.week2;

public class Rectangle {
    private int length;
    private int width;

    /**
     * Create a new Rectangle with the specified length and width.
     * @requires Length, Width > 0
     */
    public Rectangle(int theLength, int theWidth) {
    	length = theLength;
    	width = theWidth;
    	assert length > 0;
    	assert width > 0;
    }
    
    /**
     * The length of this Rectangle.
     * @ensures length > 0
     * @
     */
    public int length() {
    	assert length > 0;
    	return length;
    }

    /**
     * The width of this Rectangle.
     * @ensures width > 0
     */
    public int width() {
    	assert width > 0;
    	return width;
    }

    /**
     * The area of this Rectangle.
     * @ensures area > 0
     */
    public int area() {
    	assert length > 0;
    	assert width > 0;
    	return length * width;
    }

    /**
     * The perimeter of this Rectangle.
     * @ensures perimeter > 0
     */
    public int perimeter() {
    	assert length > 0;
    	assert width > 0;
    	return 2 * length + 2 * width;
    }
}
