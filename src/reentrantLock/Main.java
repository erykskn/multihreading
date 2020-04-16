package reentrantLock;

public class Main {

	public static void main(String[] args) {
		Runner runner = new Runner();

		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					runner.firstThread();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		});

		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					runner.secondThread();
				} catch (Exception e) {
					e.printStackTrace();
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

		runner.finish();

	}

}