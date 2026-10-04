import java.util.Scanner;

/**
 * This program prompts the user to input a number, after which it will output whether it is considered a prime number or not.
 * The user will then be asked whether they wish to input another number, looping the cycle until "no" is inputted.
 * @author Alan Wu, awu007@student.sdccd.edu
 * @since 10/4/2026
 * @version v1.0
 */
public class Prime{
    public static void main (String[] args) {
        boolean isPrime;
        int number;
        String playAgain;

        do{
            System.out.print("Enter a whole number>2 (ie 19) to test if prime: ");
            Scanner keyboard = new Scanner(System.in);

            number = keyboard.nextInt();
            keyboard.nextLine();
            
            isPrime = testForPrime(number);
            
            if (isPrime) {
                System.out.println(number + " is prime");
            } else {
                System.out.println(number + " is not prime");
            }
            
            System.out.print("Enter yes to test another number, no to quit. ");
            playAgain = keyboard.nextLine();
        } while (playAgain.equalsIgnoreCase("yes"));
    }

    /**
     * The testForPrime javadocs works to see whether an inserted whole number is a prime number or not.
     * @param inNumber The whole number tested
     * @return true if inNumber is a prime number, and false otherwise
     */
    public static boolean testForPrime(int inNumber) {
        if (inNumber <= 1) {
            return false;
        }

        int inNumberSqRt = (int) Math.sqrt(inNumber);
        boolean isPrimeMeth = true;
        
        for(int i=2;isPrimeMeth&&i<=inNumberSqRt;i++){
           if (inNumber % i == 0) {
                isPrimeMeth = false;
           }
        }
        return isPrimeMeth;
    }
}