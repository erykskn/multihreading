package interruptingThreads;

import java.util.Random;

public class ThreadInterrupting {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Startings..");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();

                for (int i = 0; i < 1E8; i++) {

                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted!");
                        break;
                    }


                    Math.sin(random.nextDouble());
                }
            }
        });

        thread.start();

        Thread.sleep(500);
        thread.interrupt();
        thread.join();

        System.out.println("Finished!");

    }
}
