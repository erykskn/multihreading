package countExample;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicNumber {
	private static AtomicInteger number = new AtomicInteger(0);

	public static void main(String[] args) {
		long miliSecond = System.currentTimeMillis();
		for (int a = 1; a < 10; a++)
			work();
		System.out.println(System.currentTimeMillis() - miliSecond);
	}

	public static void work() {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int a = 0; a < 1000000; a++) {
					increment();
				}
			}
		});

		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int a = 0; a < 1000000; a++) {
					increment();
				}
			}
		});

		thread.start();
		thread2.start();

		try {
			thread.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(number);

	}

	public static void increment() {
		number.getAndAdd(1);
	}

}
