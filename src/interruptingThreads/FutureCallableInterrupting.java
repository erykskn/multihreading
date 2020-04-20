package interruptingThreads;

import java.util.Random;
import java.util.concurrent.*;

public class FutureCallableInterrupting {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();

        Future<?> future = service.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                Random random = new Random();
                System.out.println("Starting...");

                for (int i = 0; i < 1E8; i++) {

                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Interrupted!");
                        break;
                    }

                    Math.sin(random.nextDouble());
                }
                return null;
            }
        });

        service.shutdown();
        Thread.sleep(500);
        service.shutdownNow(); // or future.cancel(true);

        service.awaitTermination(1, TimeUnit.DAYS);
        System.out.println("Finished!");
    }
}
