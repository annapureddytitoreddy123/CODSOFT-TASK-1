import java.util.*;
import java.util.Random;

class Numbergame {
    public static void main(String[] args) {
        System.out.println("Welcome to number game");
        int totalRounds = 0;
        int totalAttempts = 0;
        int totalScore = 0;
        boolean playAgain = true;
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        while (playAgain) {
            System.out.println("Random number");
            int num = rand.nextInt(100) + 1; 
            int attempts = 0;
            int score = 0;
            System.out.println("Round\n" + (totalRounds + 1));

            while (true) {
                try {
                    System.out.println("Enter the guess number");
                    int guessNum = sc.nextInt();
                    attempts++;
                    if (guessNum > num) {
                        System.out.println("Too high");
                    } else if (guessNum < num) {
                        System.out.println("Too low");
                    } else if (guessNum == num) {
                        System.out.println("Congratulations, the number is correct");
                        totalAttempts += attempts;
                        score = 10 - attempts;
                        totalScore += score;
                        totalRounds++;
                        System.out.println("Score for this round is " + score);
                        break;
                    } else {
                        System.out.println("Invalid");
                    }
                    if (attempts >= 10) {
                        System.out.println("You reached the maximum number of attempts, and the number is " + num);
                        break;
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number between 1 and 100");
                    sc.nextLine();
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = sc.next();
            if (!playAgainInput.toLowerCase().equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Game over");
        System.out.println("Total rounds: " + totalRounds);
        System.out.println("Total score: " + totalScore);
        System.out.println("Total attempts: " + totalAttempts);
    }
}
