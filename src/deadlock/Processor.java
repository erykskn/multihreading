package deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Processor {

    private Account account1 = new Account();
    private Account account2 = new Account();

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    private void acquireLock(Lock lock1, Lock lock2) {
        while (true) {
            boolean lock1Flag = false;
            boolean lock2Flag = false;

            try {
                lock1Flag = lock1.tryLock();
                lock2Flag = lock2.tryLock();
            } finally {
                if (lock1Flag && lock2Flag) {
                    return;
                }

                if (lock1Flag) {
                    lock1.unlock();
                }

                if (lock2Flag) {
                    lock2.unlock();
                }
            }

        }
    }

    public void firstThread() {
        calculate(account1, account2);
    }

    public void secondThread() {
        calculate(account2, account1);
    }

    public void finish() {
        System.out.println("Account 1 balance:" + account1.getBalance());
        System.out.println("Account 2 balance:" + account2.getBalance());
        System.out.println("Total balance:" + (account1.getBalance() + account2.getBalance()));
    }

    private void calculate(Account account1, Account account2) {
        for (int a = 1; a < 10000; a++) {
            acquireLock(lock1, lock2);
            Random random = new Random();

            try {
                Account.trasfer(account1, account2, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }
}
