import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class L1Q2S2 {
    public static void main(String[] args) {
        int count = 0;
        try{
            Scanner input = new Scanner(new FileInputStream("text4.txt")); //change the text file name for other calculation
            // to display the character separated by comma and calculate the number of the characters
            // to display the numbers separated by comma and space and calculate the number of the integers
            while(input.hasNextLine()){
                String[] character = input.nextLine().split(",");
                for(String i : character){
                    System.out.print(i+" ");
                    count++;
                }
                System.out.println();
            }
            // to display the real numbers separated by semicolon and space and calculate the number of the real numbers
            while(input.hasNextLine()){
                String[] character = input.nextLine().split(";");
                for(String i : character){
                    System.out.print(i+" ");
                    count++;
                }
                System.out.println();
            }
            // to display the alphabets separated by numbers and calculate the number of the alphabets
            while(input.hasNextLine()){
                String[] character = input.nextLine().split("(?<=\\\\D)(?=\\\\d)|(?<=\\\\d)(?=\\\\D)");
                for(int i=0;i< character.length;i+=2){
                    System.out.print(character[i]+" ");
                    count++;
                }
                System.out.println();
            }
        }catch (FileNotFoundException e){
            System.out.println("File is not found.");
        }
        System.out.println("\nTotal number of character(s): "+count);
    }
}
