import java.util.Scanner;

/**
 * This program prompts the user to input an amount of time in seconds, returning the distance traveled of an object
 * falling using the equation d=0.5*g*t^2, where g representing gravity = 9.8.
 * @author Alan Wu, awu007@student.sdccd.edu
 * @since 10/4/2026
 * @version v1.0
 */

public class FallingDistance{
    public static final double ACCELERATION = 9.8;  
    public static void main (String[] args) {
        Scanner keyboard = new Scanner(System.in);
        double distance;
        int numOfSecs;

        System.out.print("Please enter how many seconds to compute: ");
        numOfSecs = keyboard.nextInt();

        System.out.println("Time(secs)\tDistance(m)");
        System.out.println("=========\t===========");

        for (int second = 1; second <= numOfSecs; second++) {
            distance = getDistance(second);
            System.out.printf("%d\t\t%.1f%n", second, distance);
        }
    }
    /**
     * The getDistance javadocs calculates the distance the object falls after a set number of seconds.
     * @param secs Number of seconds the object has been falling for.
     * @return distance fallen in meters based on the number of seconds falling.
     */
    public static double getDistance(int secs) {
        return 0.5 * ACCELERATION * Math.pow(secs, 2);
    }
}