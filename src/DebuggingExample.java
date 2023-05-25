import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class DebuggingExample.
 */
public class DebuggingExample {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		int min = 1;
		int max = 20;
		
		boolean flag = true;
		
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Welcome to the number guessing game!");
		int guessNum = generateRandomNum(min, max);

		int guessCount = 0;

		while(flag) {
			
			System.out.println("Please make a selection:");
			System.out.println("1) Guess the number");
			System.out.println("2) Print number of guesses");
			System.out.println("3) Reset Game");
			System.out.println("4) Exit Game");

			int selection = scnr.nextInt();
			
			switch(selection) {
				
				case 1:
					System.out.println("Enter number to guess");
					int guess = scnr.nextInt();
					int answer = checkGuess(guess, guessNum);
					printStatus(answer, guess, guessCount);
					break;
				case 2:
					System.out.println("You have guessed " + guessCount + " times");
					break;
				case 3:
					generateRandomNum(min, max);
					break;
				case 4:
					flag = false;
					break;
				default:
					System.out.println("Wrong selection. Please try again");
			}
		}
		
		scnr.close();
	}
	
	/**
	 * Generate random num.
	 *
	 * @param min the min
	 * @param max the max
	 * @return the int
	 */
	public static int generateRandomNum(int min, int max) {
		
		System.out.println("A number between " + min + " and " + max + " has been generated.");
		
        int rand = (int)(Math.random() * max) + min;

        return rand;
	}
	
	/**
	 * Check guess.
	 *
	 * @param guess the guess
	 * @param guessNum the guess num
	 * @return the int
	 */
	public static int checkGuess(int guess, int guessNum) {
		
		if(guess > guessNum) {
			
			return 1;

		}else if(guess < guessNum) {
			
			return -1;

		}else {
			
			return 0;
		}
	}
	
	/**
	 * Prints the status.
	 *
	 * @param answer the answer
	 * @param guess the guess
	 * @param guessCount the guess count
	 */
	public static void printStatus(int answer, int guess, int guessCount) {
		
		if(answer == -1) {
			
			System.out.println("Your guess was " + guess + " which is less than the random number");
			
		}else if(answer == 1) {
			
			System.out.println("Your guess was " + guess + " which is greater than the random number");

		}else {
			
			System.out.println("Your guess was " + guess + " which is the random number");
			System.out.println("Congratulations!");
		}
		
		System.out.println("You have guessed " + guessCount + " times");
	}

}
