import java.util.Random;
import java.util.Scanner;

public class Number_Game {

    public static void main(String[] args) {
        int secretNumber;
        int guess;
        int attempts = 0;
        int maxAttempts = 10;

        Random random = new Random();
        secretNumber = random.nextInt(50)+1;

        Scanner sc = new Scanner(System.in);
        System.out.println("Guess a Number between 1 to 50, You have only 10 guesses! \n");

        while(maxAttempts>=1) {
            System.out.println("Let's Start Game! \n Enter Number: ");
            guess = sc.nextInt();
            attempts++;
            maxAttempts--;

            if (guess < secretNumber) {
                System.out.println("Too low! Try Again.");
            }
            else if (guess > secretNumber) {
                System.out.println("Too high! Try Again.");
            }
            else {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
            }
        }
    }
}