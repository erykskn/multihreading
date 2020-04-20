package semaphore;

import java.util.concurrent.Semaphore;

public class Connection {
    private int connections;
    private static Connection connection = new Connection();

    private Connection() {
    }

    private Semaphore semaphore = new Semaphore(10,true);

    public static Connection getInstance() {
        return connection;
    }

    public void connection() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            doConnection();
        } finally {
            semaphore.release();
        }
    }

    private void doConnection() {
        synchronized (this) {
            connections++;
            System.out.println("Current connections: " + connections);
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (this) {
            connections--;
        }
    }

}
