package multipleLock;

import java.util.ArrayList;
import java.util.List;

public class Worker {

	private List<Integer> list1 = new ArrayList<>();
	private List<Integer> list2 = new ArrayList<>();

	private Object lock1 = new Object();
	private Object lock2 = new Object();

	public void incrementList1() {
		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list1.add(1);
		}

	}

	public void incrementList2() {
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list2.add(1);
		}

	}

	public void runMethods() {
		for (int a = 0; a < 1000; a++) {
			incrementList1();
			incrementList2();
		}

	}

	public void main(String[] args) {
		long time = System.currentTimeMillis();
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				runMethods();
			}
		});

		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				runMethods();
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

		System.out.println(System.currentTimeMillis() - time);
		System.out.println("list1 size:" + list1.size() + " \n list2 size: " + list2.size());

	}

}
