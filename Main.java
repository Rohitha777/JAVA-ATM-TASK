import java.util.Scanner;
import java.util.ArrayList;

//define a class for atm
class ATM{
    private String accountnumber;
    private String pin;
    private double balance;
    private ArrayList<String> transcationhistory;
    int PIN=1234;


    // constructor to intialize atm with details
    ATM(String accountnumber,String pin,double balance)
    {
        this.accountnumber=accountnumber;
        this.pin=pin;
        this.balance=balance;
        this.transcationhistory=new ArrayList<String>();


    }
    // method to checkpin
    public void checkpin(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a PIN: ");
        int enteredpin=sc.nextInt();

        if(enteredpin==PIN){
            runATM();
        }
        else{
            System.out.println("Enter a Valid PIN ");
            checkpin();
        }
    }

    //method to check balance
    public void checkBalance()
    {
        System.out.println("current balance: $"+balance);
    }
    //method to withdraw cash
    public void withdrawCash(double amount)
    {
        if(amount > 0 && amount<=balance)
        {
            balance=balance-amount;
            System.out.println("withdrawal of cash is successful. Remaining Balance: $"+balance);
            transcationhistory.add("withdrawal: $"+amount);
        }
        else
        {
            System.out.println("Insufficient balance");
        }

    }
    //method to deposit cash
    public void depositCash(double amount)
    {
        if(amount>0)
        {
            balance=balance+amount;
            System.out.println("Cash deposited succesfully. New balance: $"+balance);
            transcationhistory.add("Deposit: $"+amount);
        }
        else
        {
            System.out.println("Insufficient amount to deposit cash");
        }


    }
    //method to change pin
    public void changePIN(String newPin)
    {
        this.pin=newPin;
        System.out.println("PIN changed successfully");
    }
    //method to display transcation history
    public void displayTransactionHistory()
    {
        System.out.println("Transcation History:");
        for (String transaction : transcationhistory) {
            System.out.println(transaction);
        }

    }
    //method for atm actions
    public void runATM() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        System.out.println("welcome to ATM");

        while (choice != 6) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Cash");
            System.out.println("3. Deposit Cash");
            System.out.println("4. Change PIN");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");
            
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    withdrawCash(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    depositCash(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter new PIN: ");
                    String newPin = scanner.next();
                    changePIN(newPin);
                    break;
                case 5:
                    displayTransactionHistory();
                    break;
                case 6:
                    System.out.println("Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid choice.");
                    break;
            }
        }
        scanner.close();
    }
}
// Main class
public class Main {
    public static void main(String[] args) {
        // Initialize ATM with account details
        ATM atm = new ATM("123456", "1234", 1000.0);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to ATM !! ");
        atm.checkpin();


    

        // Run the ATM 
        atm.runATM();
    }
}
