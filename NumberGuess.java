import java.util.Random;
import java.util.Scanner;

public class NumberGuess {

    public static Integer getRandom(int from , int to){
                Random r = new Random();

                int random = r.nextInt(from, to);
                return random;
    }

    public static Integer start(int randomNum){
        System.out.println("Guess the Number in only 5 attempts");
        int Attempts = 0;

            Scanner sc = new Scanner(System.in);
            int usernumber = 0;
            do {
                System.out.println("Enter your guessed number");

                boolean validnum = false;
                while (!validnum) {
                    String num = sc.next();
                    try {
                        usernumber = Integer.parseInt(num);
                        validnum = true;

                    } catch (Exception e) {
                        System.out.println("Enter Valid Number");
                    }
                }

                if (usernumber > randomNum) {
                    System.out.println("guess lower");
                    System.out.println("remaining Attempt =" +(5-Attempts));
                    Attempts++;
                } else if (usernumber == randomNum) {
                    Attempts++;
                    System.out.println("Guessed Corrct");
                    break;


                } else {
                    System.out.println("Guess Higher");
                    System.out.println("remaining Attempt =" +(5-Attempts));
                    Attempts++;
                }
                if(Attempts>5){
                    System.out.println("Out of Attempts. the Correct number is "+randomNum);
                    break;
                }
            }
            while (true);

        return Attempts;

        }

    public static void main(String[] args) {
        int highScore = Integer.MAX_VALUE;
        int attempts = 0;
        int ch = 0;
        do {
            System.out.println("***************** WEL-COME TO NUMBER GUESSING GAME *****************");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter The Range of Numbers (eg: 1 to 100)");
            System.out.println("From");
            int from = 0;

            boolean validFrom = false;
            boolean validTo = false;

            while (!validFrom) {

                System.out.println("Enter From Number = ");
                String input = sc.next();
                try {
                    from = Integer.parseInt(input);

                    validFrom = true;
                } catch (Exception e) {
                    System.out.println("Enter Valid Number");
                }

            }
            System.out.println("To");

            int to = 0;

            while (!validTo) {
                String input = sc.next();
                try {
                    to = Integer.parseInt(input);
                    if (to <= from) {
                        System.out.println("'To' number Should be greater than from");
                    } else {
                        validTo = true;
                    }
                } catch (Exception e2) {
                    System.out.println("Enter Valid Number");
                }
            }

            int Number = getRandom(from, to);

            attempts = start(Number);
            if(highScore==Integer.MAX_VALUE){
                highScore = attempts;
            }
            if(attempts<highScore) {
                highScore = attempts;
                System.out.println("Congrats you made a HighScore");
            }
            System.out.println("HighScore =  "+highScore );
            System.out.println("you Finished the game in " + attempts + " attempts");
            System.out.println("-------------------------------------------------------");
            System.out.println("Enter 0 To Exit to Play Again Enter Any number");
            ch = sc.nextInt();
        }while(ch!=0);

        System.out.println("Thanks For playing game");

    }
}
