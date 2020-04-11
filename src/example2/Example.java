package example2;

import java.util.Scanner;

class MyThread extends Thread {

	private volatile boolean running = true;

	@Override
	public void run() {

		while (running) {
			System.out.println(this.getName());

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void shotdown() {
		running = false;
	}
}

public class Example {
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		myThread.setName("MyThread is running!");
		myThread.start();
		
		System.out.println("Enter to stop thread...");
		try (Scanner scanner = new Scanner(System.in)) {
			scanner.nextLine();
		}
		myThread.shotdown();

	}
}
