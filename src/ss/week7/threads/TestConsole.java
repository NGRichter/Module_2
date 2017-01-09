package ss.week7.threads;

public class TestConsole extends Thread {
	
	public TestConsole(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		sum();
	}
	
	private void sum() {
		String sum = getName() + ": Sum equals " + (Console.readInt(getName() + ": First number: ") + Console.readInt(getName() + ": Second number: "));
		Console.println(sum);
	}
	
	public static void main(String[] args) {
		Thread test = new TestConsole("Thread A");
		Thread test2 = new TestConsole("Thread B");
		test.start();
		test2.start();
	}
}
//7.9 Both threads try to get the value that they are asking, if one of the two is just a little bit faster he gets it and the other does not.
/*
Thread A: First number: Thread B: First number: 5
Thread A: Second number: 10
Thread B: Second number: 7
Thread A: Sum equals 12
Thread B: Second number: 122
Thread B: Sum equals 132
*/