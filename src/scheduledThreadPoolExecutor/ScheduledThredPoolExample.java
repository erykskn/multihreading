package scheduledThreadPoolExecutor;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThredPoolExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        MyTask myTask1 = new MyTask("MyTask 1");
        MyTask myTask2 = new MyTask("MyTask 2");

        System.out.println("The time is : " + new Date());

        scheduledExecutorService.schedule(myTask1, 5, TimeUnit.SECONDS);
        scheduledExecutorService.schedule(myTask2, 10, TimeUnit.SECONDS);
        try {
            scheduledExecutorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scheduledExecutorService.shutdown();
        System.out.println("Finished!");
    }
}

