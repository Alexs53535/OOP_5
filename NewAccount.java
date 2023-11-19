public abstract class Account {
    public int balance;
 
 
 
    public Account(int balance) {
        this.balance = balance;
    }
    public void getBalance(Account account) {
        System.out.println(account + ": "+ "Баланс " + balance);
    }
 
    public abstract void pay(int amount); // заплатить
 
    public abstract void transfer(Account account, int amount); //перевести
 
    public abstract void addMoney(int amount);//пополнить
 
 
}
 
public class SavingsAccount extends Account {
 
 
    public SavingsAccount(int balance) {
        super(balance);
 
    }
    @Override
    public void pay(int amount) {
        System.out.println("Данная операция не может быть совершена");
        return;
    }
 
    @Override
    public void transfer(Account account, int amount) {
        if (amount > balance) {
            System.out.println("Сумма перевода превышает остаток, введите сумму меньшую " + balance + " рублей");
        } else {
            System.out.println("Сумма в размере " + amount + " руб " + "переведена на " + account);
            balance -= amount;
            System.out.println("Баланс сберегательного счета составляет " + balance);
        }
    }
 
    @Override
    public void addMoney(int amount) {
        System.out.println("Ваш баланс пополнен на " + amount + " рублей");
        balance += amount;
        System.out.println("Баланс сберегательного счета составляет " + balance + " рублей");
 
    }
    public String toString() {
        return "Сберегательный счет";
    }
}
 
public class CreditAccount extends Account {
    private int limit = 50_000;
 
    public CreditAccount(int balance) {
        super(balance);
    }
 
    @Override
    public void pay(int amount) {
        if ((amount + Math.abs(balance)) > limit) {
            System.out.println("Вы превысили лимит по операциям");
            return;
        } else {
            System.out.println("Совершен платеж на " + amount + " рублей");
            balance -= amount;
            System.out.println("Баланс кредитного счета составляет " + balance + " рублей");
        }
    }
 
    @Override
    public void transfer(Account account, int amount) {
        System.out.println("Сумма в размере " + amount + " руб " + "переведена на " + account);
        balance -= amount;
        System.out.println("Баланс кредитного счета составляет " + balance);
    }
 
 
 
    @Override
    public void addMoney(int amount) {
        if (balance + amount > 0) {
            System.out.println("Сумма пополнения не должна превышать " + Math.abs(balance) + " рублей");
        } else {
            System.out.println("Ваш баланс пополнен на " + amount + " рублей");
            balance += amount;
            System.out.println("Баланс кредитного счета составляет " + balance + " рублей");
        }
 
    }
    public String toString() {
        return "Кредитный счет";
    }
}
 
 
public class Main {
 
        public static void main(String[] args) {
           
            SavingsAccount savingsAccount0 = new SavingsAccount(0);
            SavingsAccount savingsAccount1 = new SavingsAccount(0);
            CreditAccount creditAccount = new CreditAccount(0);
            CheckingAccount checkingAccount = new CheckingAccount(0);
 
            savingsAccount0.addMoney(10_000);
            creditAccount.pay(10_000);
            savingsAccount0.transfer(creditAccount, 1000);
            System.out.println();
            creditAccount.getBalance(creditAccount);
            savingsAccount0.getBalance(savingsAccount0);
        }
    }