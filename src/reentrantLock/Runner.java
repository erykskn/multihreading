package reentrantLock;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

	private int count = 0;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	private void increment() {
		for (int i = 0; i < 10000; i++) {
			count++;
		}
	}

	public void firstThread() throws InterruptedException {
		lock.lock();
		System.out.println("Waiting...");
		
		System.out.println("Woken up!");
		try {
			increment();
		} finally {
			lock.unlock();
		}

	}

	public void secondThread() throws InterruptedException {

		Thread.sleep(2000);
		lock.lock();

		System.out.println("Press the return key..");
		try (Scanner s = new Scanner(System.in)) {
			s.nextLine();
		}
		System.out.println("Got return key..");
		
		try {
			increment();
		} finally {
			lock.unlock();
		}

	}

	public void finish() {
		System.out.println("Count is " + count);
	}
}