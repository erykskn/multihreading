package basicExample;

public class Example {

	public static void main(String[] args) {
		System.out.println("---Thread Imlp---");
		MyThread myThread = new MyThread();
		MyThread myThread2 = new MyThread();
		myThread.setName("MyThread 1");
		myThread2.setName("MyThread 2");
		myThread.start();
		myThread2.start();
	
		waiting(2000);
		
		System.out.println("---Runner Imlp---");
		Thread thread = new Thread( new Runner());
		Thread thread2 = new Thread( new Runner());
		thread.start();
		thread2.start();
		
	}
	public static void waiting(long milisecond) {
		try {
			Thread.sleep(milisecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
