package ss.week7;

public class IntCell {
    private int contents = 0;

    public void add(int amount) {
        contents = contents + amount;
    }
    public int get() {
        return contents;
    }

    public static void main(String[] args) {
        IntCell cell = new IntCell();
        Adder a1 = new Adder(cell, 1);
        Adder a2 = new Adder(cell, 2);
        a1.start();
        a2.start();
        try {
            a1.join();
            a2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(cell.get());
    }
}

class Adder extends Thread {
    private IntCell cell;
    private int amount;

    public Adder(IntCell cellArg, int amountArg) {
        this.cell = cellArg;
        this.amount = amountArg;
    }
    public void run() {
    	synchronized (cell) {
            cell.add(amount);    		
    	}

    }
    //7.20 1. The answer is either 1, 2 or 3.
    // Either a1 or a2 can run the method first and wants to access and rewrite the variable, 
    // the other thread wants to do the same but can access the already modified variable or the unmodified one.
    // and one method can overwrite the other.
    //2. If run is called no thread will be made but the code will be executed so if a1.run is called the thread will be busy
    //with executing and will only call a2.run when a1 has finished.
    //3. The result could be 0, 1, 2 or 3 because if the threads aren't finished yet but the call is made to print the value
    //the original value will be printed.
    //4. The result will always be 3 because the method can only be executed after the other thread is finished with it.
    //5. Usage of synchronized (this)
}
