import java.io.*;
import java.util.Scanner;

public class ReadMyLetter_U2005284 {
    public static void main(String[] args) {
        String str = " ";
        try{
            Scanner input = new Scanner(new FileInputStream("C:\\Users\\D.Chong\\IdeaProjects\\Lab 8\\ChongJunYi_U2005284.txt"));
            while(input.hasNextLine()){
                str += input.nextLine() + "\n";
            }
            input.close();
        }catch (FileNotFoundException e){
            System.out.println("File not found.");
        }
        str += "\n\nThursday, 19 March 2021. \n\n";
        Scanner sc = new Scanner(System.in);
        str += sc.nextLine();
        System.out.println(str);
    }
}
