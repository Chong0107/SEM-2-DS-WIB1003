import java.util.ArrayList;
import java.util.Date;

public class Account1 {
    private int id;
    private double balance;
    private double annualInterestRate = 1.5;
    private String name;

    public Account1(int id, double balance, String name) {
        this.id = id;
        this.balance = balance;
        this.name = name;
    }

    ArrayList<Transactions> transactions = new ArrayList<Transactions>();

    public double getMonthlyInterestRate(){
        return (annualInterestRate / 100) / 12;
    }

    public double getMonthlyInterest(){
        return balance * getMonthlyInterestRate();
    }

    public void withdraw(int draw){
        balance -= draw;
        transactions.add(new Transactions(new Date(),'W',draw,balance,"Withdraw"));
    }

    public void deposit(int plus){
        balance += plus;
        transactions.add(new Transactions(new Date(),'D',plus,balance,"Deposit"));
    }
}

class Transactions{
    private Date date;
    private char type;
    private double amount;
    private double balance;
    private String description;

    Transactions(Date date, char type, double amount, double balance, String description){
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }
    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date.toString();
    }
}

class Tester2{
    public static void main(String[]args){
        Account1 acc = new Account1(1122, 1000, "George");
        acc.deposit(30);
        acc.deposit(40);
        acc.deposit(50);
        acc.withdraw(5);
        acc.withdraw(4);
        acc.withdraw(2);

        for(int i=0; i<acc.transactions.size(); i++){
            System.out.println("Date of this transaction : " + acc.transactions.get(i).getDate());
            System.out.println("Type of this transaction : " + acc.transactions.get(i).getType());
            System.out.println("Amount of this transaction : " + acc.transactions.get(i).getAmount());
            System.out.println("New Balance of this transaction : " + acc.transactions.get(i).getBalance()  );
            System.out.println("Description of this transaction : " + acc.transactions.get(i).getDescription());
            System.out.println();
        }
    }
}
