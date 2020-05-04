package scheduledThreadPoolExecutor;

import java.util.Date;

public class MyTask implements Runnable {
    private String name;

    public MyTask(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println("Doing a task  during: " + getName() + "- Time: " + new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}