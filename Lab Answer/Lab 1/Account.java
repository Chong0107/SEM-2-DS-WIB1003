import java.util.Date;

public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated = new Date();

    public Account() {
    }

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterestRate(){
        return (annualInterestRate / 100) / 12;
    }

    public double getMonthlyInterest(){
        return balance * getMonthlyInterestRate();
    }

    public void withdraw(int draw){
        balance -= draw;
    }

    public void deposit(int plus){
        balance += plus;
    }
}

class tester{
    public static void main(String[] args) {
        Account acc = new Account(1122,20000,4.5);
        acc.withdraw(2500);
        acc.deposit(3000);
        System.out.printf("\nBalance: %.2f",acc.getBalance());
        System.out.printf("\nMonthly interest: %.2f",acc.getMonthlyInterest());
        System.out.println("Date: "+acc.getDateCreated().toString());
    }
}
