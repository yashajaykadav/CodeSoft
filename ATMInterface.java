import java.util.Scanner;

import static java.lang.System.exit;

public class ATMInterface {
    private static double balance = 1000.00;

    public static double getBal(){
        return balance;
    }
    public static double widthdraw(double cash){
        if(balance<cash){
            System.out.println("Balance is insufficient");
        }
        else if(cash<1){
            System.out.println("The withdrawal is greater than 1rs");

        }else{
            System.out.println("Withdrawal Cash is successful");
      return  balance -= cash;
        }
        return balance;
    }

    public static void deposite(double cash){
        balance+=cash;
        System.out.println("Amount is Deposited");
    }

    public static void main(String[] args) {
int ch;
        System.out.println("Welcome to ATM service");

        do {
            Scanner sc = new Scanner(System.in);

            System.out.println("1.Check Balance /n 2.withdrawal /n 3.deposite /n 0.exit");
            System.out.println("Enter Your Option");
             ch  = sc.nextInt();
            switch (ch){

                case 1:
                    System.out.println("The balance is "+getBal());
                    break;
                case 2:
                    System.out.println("Enter The Amount To withdraw");
                    double cash = sc.nextDouble();
                    widthdraw(cash);
                    System.out.println("The remaining balance is "+getBal());

                    break;
                case 3:
                    System.out.println("Enter Amount to deposite");
                    double Cash = sc.nextDouble();
                    deposite(Cash);
                    System.out.println("the New Balance is "+getBal());
                    break;

                case 0:
                    System.out.println("Thanks For Using Our Service");
                    exit(0);

                default:
                    System.out.println("Please enter Correct Option");
                    break;

            }
        } while (ch != 0);

    }
}