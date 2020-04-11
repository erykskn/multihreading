package countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Processor implements Runnable {
	private int number;
	private CountDownLatch latch;

	public Processor() {
	}

	public Processor(int number, CountDownLatch countDownLatch) {
		this.number = number;
		this.latch = countDownLatch;
	}

	@Override
	public void run() {
		System.out.println("Starting:" + getNumber());

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Ended:" + getNumber());
		latch.countDown();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public CountDownLatch getLatch() {
		return latch;
	}

	public void setLatch(CountDownLatch latch) {
		this.latch = latch;
	}

}