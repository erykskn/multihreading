package producerConsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

	private static BlockingQueue<Integer> blockingDeque = new ArrayBlockingQueue<Integer>(10);

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					producer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					consumer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		thread.start();
		thread2.start();
		
		thread.join();
		thread2.join();
	}

	private static void producer() throws InterruptedException {
		Random random = new Random();

		while (true) {
			blockingDeque.put(random.nextInt(100));
		}
	}

	private static void consumer() throws InterruptedException {
		Random random = new Random();

		while (true) {
			Thread.sleep(100);

			if (random.nextInt(10) == 0) {
				int value = blockingDeque.take();
				System.out.println("Taken value: " + value + "; Queue size is:" + blockingDeque.size());
			}
		}
	}

}
