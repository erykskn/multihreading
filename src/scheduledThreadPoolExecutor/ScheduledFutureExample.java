package scheduledThreadPoolExecutor;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledFutureExample {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        MyTask myTask = new MyTask("MyTask 1");
        System.out.println("The time is: " + new Date());

        ScheduledFuture<?> scheduledFuture = service.scheduleAtFixedRate(myTask, 3, 4, TimeUnit.SECONDS);

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }

}
