package waitAndNotify;

import java.util.Scanner;

public class Processor {

    public void produse() throws InterruptedException{
        synchronized(this){
            System.out.println("Producer thread is running..");
            wait();
            System.out.println("Resumed.");
        }
    }

    public void consume() throws InterruptedException{
        Scanner scanner = new Scanner(System.in);
        Thread.sleep(2000);
        synchronized(this){
            System.out.println("Waiting for return key..");
            scanner.nextLine();
            System.out.println("Return key pressed..");
            notify();

        }
    }
}