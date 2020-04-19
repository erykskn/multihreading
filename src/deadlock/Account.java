package deadlock;

public class Account {
    private int balance = 10000;

    public void deposite(int amount) {
        balance= balance + amount;
    }

    public void  withdraw(int amount) {
        balance = balance - amount;
    }

    public int getBalance() {
        return balance;
    }

    public static void trasfer(Account account1, Account account2, int amount){
        account1.deposite(amount);
        account2.withdraw(amount);
    }
}
