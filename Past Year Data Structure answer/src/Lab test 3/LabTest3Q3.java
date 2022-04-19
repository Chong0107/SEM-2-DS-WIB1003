import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author U2005284 Chong Jun Yi
 */
public class LabTest3Q3 {
    public static void main(String[] args) {
        // Creates an integer array with 5 elements
        int [] arrays = new int[5];
        // Display all the integers entered by the user
        createArray(arrays,0);
    }

    public static void createArray(int [] Array,int i){
        Scanner input = new Scanner (System.in);
        try{
            // Accepts user input for the elements of the array
            System.out.print("Enter an Integer: ");
            Array[i] = input.nextInt();
            createArray(Array,++i);
        // Exception handling to detect improper inputs
        }catch(InputMismatchException f){
            System.out.println("Invalid input type");
            createArray(Array,i);
        // The program will stop if ArrayIndexOutOfBoundsException is encountered.
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("The array of integers is");
            for(int j : Array)
                System.out.print(j + " ");
        }
    }
}
