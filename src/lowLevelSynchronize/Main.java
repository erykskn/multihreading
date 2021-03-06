package lowLevelSynchronize;

public class Main {

	public static void main(String[] args) {
		Processor processor = new Processor();

		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					processor.produse();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					processor.consume();
				} catch (InterruptedException e) {
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

	}

}
