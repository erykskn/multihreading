package yield;

public class Main {
    public static void main(String[] args) {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        producer.setPriority(Thread.MIN_PRIORITY);
        consumer.setPriority(Thread.MAX_PRIORITY);

        producer.start();
        consumer.start();
    }
}

class Producer extends Thread{
    @Override
    public void run() {
        for(int a = 0; a < 10; a++){
            System.out.println("Producer thread running, i: " + a);
            Thread.yield();
        }
    }
}

class Consumer extends Thread{
    @Override
    public void run() {
        for(int a = 0; a < 10; a++){
            System.out.println("Consumer thread running, i: " + a);
            Thread.yield();
        }
    }
}
