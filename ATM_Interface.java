import java.util.Scanner;

class ATM_Interface {
    public static void main(String[] args) {
        System.out.println("<---------- Welcome To RBI ---------->");
        LoignAct la = new LoignAct();
        la.createAct();
        System.out.println("<---------- Welcome Back To RBI ---------->");
        System.out.println("+++++++++++++++++++++++++++++");
        System.out.println("<---------- Welcome to Secured Login ---------->");
        la.login();

        int ch;
        Scanner sc = new Scanner(System.in);
        TransactionHistory tr = new TransactionHistory();
        while (true) {
            System.out.println("\n");
            System.out.println("\n");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Previous Transaction");
            System.out.println("5. Transfer");
            System.out.println("6. Exit");

            System.out.println("+++++++++++++++++++++++++++++");
            System.out.println("Enter Your Choice: ");
            System.out.println("+++++++++++++++++++++++++++++");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    tr.check();
                    break;

                case 2:
                    tr.Display();
                    break;

                case 3:
                    tr.cash();
                    break;

                case 4:
                    tr.history();
                    break;

                case 5:
                    tr.forward();
                    break;
                case 6:
                    System.out.println("Thank you ! for using our service");
                    System.exit(ch);
                    break;

                default:
                    System.out.println("Enter valid choice!");
            } 
        }
    }
}

class Act{
    protected String usr_id;
    protected String usr_pwd;
    Scanner sc = new Scanner(System.in);
    
    void createAct() {
        System.out.println("Enter Username: ");
        usr_id = sc.nextLine();
        System.out.println("Enter Password: ");
        usr_pwd = sc.nextLine();
        System.out.println("Congratulation! Account Created Sucessfully");
    }
}

class LoignAct extends Act {
    private String id;
    private String pwd;

    void login() {
        do {
            System.out.println("Enter Username: ");
            id = sc.nextLine();
            if (usr_id.equals(id)) {
                do {
                    System.out.println("Enter Password: ");
                    pwd = sc.nextLine();
                    if (pwd.equals(usr_pwd)) {
                        System.out.println("Login Successful!");
                    }
                    else{
                        System.out.println("Please Enter Correct Password");
                    }
                }
                    while (pwd.equals(usr_pwd) == false);
                }
                else {
                    System.out.println("Please Enter Correct Password");
                }
            } while(usr_id.equals(id) == false);
        }
    }

class Deposit {
    int amount;
    int balance = 10000;
    int pretransaction = 0;
    String Transactionrecord = "";
    Scanner sc = new Scanner(System.in);

    void Display() {
        System.out.println("Enter Deposit Amount: ");
        amount = sc.nextInt();
        if (amount != 0) {
            pretransaction++;
            balance = balance + amount;
            pretransaction = amount;
            String str = amount + "Rs. Deposited\n";
            Transactionrecord = Transactionrecord.concat(str);
            System.out.println("Amount is Successfully Deposited!");
        }
    }
}

class Withdraw extends Deposit {
    void cash() {
        System.out.println("Enter Amount for Widrawing Cash: ");
        amount = sc.nextInt();
        if (balance > amount) {
            if (amount <= 10000) {
                pretransaction++;
                balance = balance - amount;
                pretransaction = pretransaction - amount;
                System.out.println("Amount Withdraw Successfully!");
                String str = amount + "Rs. Withdrawed Successfully!";
                Transactionrecord = Transactionrecord.concat(str);
            }
            else {
                System.out.println("Sorry ! Limit Reached(Rs:10000)");
            }
        }
            else {
                System.out.println("Insufficient Amount to Withdraw!");
            }
        }
    }
class Transfer extends Withdraw {
    void forward() {
        int bank_act;
        int act;
        int r_actbalance = 0;
        System.out.println("Enter Amount to Transfer: ");
        amount = sc.nextInt();
        if (balance < amount) {
            System.out.println("You have not Sufficient Balance for Transfering Amount");
        }
    else{
        System.out.println("Enter the Account No. of Receiver: ");
        act = sc.nextInt();
        this.balance = this.balance - amount;
        r_actbalance += amount;
        System.out.println("Your Account Balance is $ " + this.balance);
        System.out.println("Account Balance of Receiver is $ " + r_actbalance);
        String str = amount + "Rs Transfered";
        Transactionrecord = Transactionrecord.concat(str);
    }
}
}

class CheckBalance extends Transfer {
    void check() {
        System.out.println("\n Your Account Balance is " + balance + " Rs");
    }

}

class TransactionHistory extends CheckBalance {
    void history() {
        if (pretransaction == 0) {
            System.out.println("\n Empty");
        } else {

            System.out.println("\n" + Transactionrecord);
        }
    }
}

