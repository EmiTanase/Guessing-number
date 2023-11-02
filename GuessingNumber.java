import java.util.Scanner;

public class GuessingNumber {
    int numberOfTrials = 10;
    boolean guessed = false;
    int number = generateRandomNumber();
    public void guessingNumberGame() {

        Scanner sc = new Scanner(System.in);
        System.out.println("A number is chosen between 1 to 100. Guess the number within " + numberOfTrials +  " trials.");

        while (numberOfTrials > 0) {
            System.out.println("Guess the number:");
            int guess = sc.nextInt();

            if (number == guess) {
                displayCongratulations();
                guessed = true;
                break;
            } else {
                --numberOfTrials;
                displayHint(number, guess);
                System.out.println("You have " + numberOfTrials + " trials left");
            }
        }

        if (!guessed && isGameOver(numberOfTrials)) {
            displayGameOver(number);
        }
    }
    private int generateRandomNumber() {
        return 1 + (int) (100 * Math.random());
    }

    private void displayCongratulations() {
        System.out.println("Congratulations! You guessed the number.");
    }

    private void displayHint(int number, int guess) {
        if (number > guess) {
            System.out.println("The number is greater than " + guess);
        } else {
            System.out.println("The number is less than " + guess);
        }
    }

    private boolean isGameOver(int trials) {
        return this.numberOfTrials == trials;
    }

    private void displayGameOver(int number) {

        System.out.println("You have exhausted your lives.");
        System.out.println("The number was " + number);
    }
}

