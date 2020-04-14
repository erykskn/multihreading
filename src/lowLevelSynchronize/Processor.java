package lowLevelSynchronize;

import java.util.LinkedList;
import java.util.Random;

public class Processor {

	private LinkedList<Integer> list = new LinkedList<Integer>();
	private final int LIMIT = 10;
	private Object lockObject = new Object();

	public void produse() throws InterruptedException {
		int number = 0;

		while (true) {

			synchronized (lockObject) {
				
				while (list.size() == LIMIT) {
					lockObject.wait();
				}

				list.add(number++);
				lockObject.notify();
			}
		}

	}

	public void consume() throws InterruptedException {
		Random random = new Random();
		while (true) {
			synchronized (lockObject) {

				while (list.size() == 0) {
					lockObject.wait();
				}

				System.out.print("List size is: " + list.size());
				int value = list.removeFirst();
				System.out.println(", value is: " + value);
				lockObject.notify();

				Thread.sleep(random.nextInt(1000));
			}

		}
	}
}
