package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class MyThread extends Thread {

	private int number;

	public MyThread(int number) {
		this.number = number;
	}

	@Override
	public void run() {
		System.out.println("Starting... :" + number);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Ended... :" + number);
	}
}

public class Main {
	public static void main(String[] args) {

		ExecutorService service = Executors.newFixedThreadPool(3);

		for (int a = 0; a < 10; a++) {
			service.execute(new MyThread(a));
		}

		service.shutdown();

		System.out.println("All tasks submitted.");

		try {
			service.awaitTermination(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("All tasks complited.");
	}
}
