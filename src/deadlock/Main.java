package deadlock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Processor processor = new Processor();
        IProcessor iProcessor1 = () -> processor.firstThread();
        IProcessor iProcessor2 = () -> processor.secondThread();
        Thread thread1 = getThread(iProcessor1);
        Thread thread2 = getThread(iProcessor2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        processor.finish();
    }

    private static Thread getThread(IProcessor iProcessor) {

        return new Thread(new Runnable() {
            @Override
            public void run() {
                iProcessor.apply();
            }
        });

    }
}
