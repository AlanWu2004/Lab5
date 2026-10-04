import java.util.Scanner;
import java.io.*;

/**
 * This program works ot read values from an input text file, analysing lines of numbers to assign a letter grade.
 * Afterwards, the code should return a numeric count of each letter, the lowest and highest score, and the average of all scores.
 * Finally, the outputs will be written to an output file accordingly.
 * @author Alan Wu, awu007@student.sdccd.edu
 * @since 10/4/2026
 * @version v1.0
 */
public class Grades{
    public static void main (String[] args) throws IOException{
        String inFile, outFile;
        inFile = getInFile();
        outFile = getOutFile();
        processFile(inFile, outFile);
    }

    /**
     * Uses Scanner to get and return input file name
     * @return name of file from Scanner  //NOTE - Description only for return
     */
    public static String getInFile(){
        File inputFile;
        String fileName;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the name of the input file (ie input.txt): ");
        fileName = keyboard.nextLine();
        inputFile = new File(fileName);
        while (!inputFile.exists()) {
            System.out.println("The input file can't be found or doesn't exist. Enter the name of the input file (ie input.txt): ");
            fileName = keyboard.nextLine();
            inputFile = new File(fileName);
        }
        return fileName;
    }
    
    /**
     * Uses Scanner to get and return output file name
     * @return name of file from Scanner
     */
    public static String getOutFile(){
        Scanner keyboard = new Scanner(System.in);
        String fileName;
        System.out.print("Enter the name of the input file (ie output.txt): ");
        fileName = keyboard.nextLine();
        return fileName;
    }
        
    /**
     * Reads each line of grades, calculating letter grade counts, minimum, maximum, and average.
     * In addition, writes the results into the requrested output file.
     * @param inInFile name of input file
     * @param inOutFile name of output file
     */    
    public static void processFile(String inInFile, String inOutFile) throws IOException {
        int number;
        int As, Bs, Cs, Ds, Fs, min, max;
        int total, count;
        double avg;
        int set = 1;
        
        File file = new File(inInFile);
        Scanner inStream = new Scanner(file);
        PrintWriter outStream = new PrintWriter(inOutFile);
        
        while (inStream.hasNextLine()) {
            As = Bs = Cs = Ds = Fs = count = 0;
            avg = 0.0;
            number = inStream.nextInt();
            min = max = number;
            total = count = 0;
            while (number!=-1) {
                if (number < min)
                    min = number;
                if (number > max)
                    max = number;
                count++;
                total+=number;
                
                if (number >= 90)
                    As++;
                else if (number >= 80)
                    Bs++;
                else if (number >= 70)
                    Cs++;
                else if (number >= 60)
                    Ds++;
                else
                    Fs++;
                number = inStream.nextInt();
            }
            outStream.println("Set " + set + " of grades calculated");
            set++;
            
            if (count==0)
            outStream.println("No grades to average\n");
            else{
                outStream.println("Number of As: " + As);
                outStream.println("Number of Bs: " + Bs);
                outStream.println("Number of Cs: " + Cs);
                outStream.println("Number of Ds: " + Ds);
                outStream.println("Number of Fs: " + Fs);
                outStream.println("The high score was: " + max);
                outStream.println("The low score was: " + min);
                avg = (double)total/count;
                outStream.printf("The avg score is: %.1f\n\n", avg);
            }   
        }
        System.out.println("Grade processing is completed");
        System.out.println("You can retrieve the output file at, " + inOutFile);
        inStream.close();
        outStream.close();
    }
}