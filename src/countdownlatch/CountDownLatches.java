package countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatches {

	public static void main(String[] args) {

		CountDownLatch countDownLatch = new CountDownLatch(3);

		ExecutorService executorService = Executors.newFixedThreadPool(3);

		for (int a = 0; a < 3; a++) {
			executorService.submit(new Processor(a, countDownLatch));
		}

		try {
			countDownLatch.await(); //main thread is waiting
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Finish...");

	}

}
