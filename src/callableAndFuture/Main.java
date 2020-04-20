package callableAndFuture;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();

        Future<Integer> future = service.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int duration = 0;
                Random random = new Random();
                duration = random.nextInt(4000);
                if (duration > 2000) {
                    throw new IOException("Sleeping for too long!");
                }
                System.out.println("Starting...");

                Thread.sleep(duration);

                System.out.println("Finish...");
                return duration;
            }
        });
        service.shutdown();

        try {
            System.out.println("Duration is: " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            IOException ioException = (IOException) e.getCause();
            System.out.println(ioException.getMessage());
        }

    }
}
