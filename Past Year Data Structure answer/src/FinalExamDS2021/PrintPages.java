package FinalExamDS2021;

import java.util.Scanner;
import java.util.ArrayList;

public class PrintPages {
   public static void main(String[] args) {
       SpecialLL<Integer> bookPage = new SpecialLL<>();
       ArrayList<Integer> selectedList = new ArrayList<>();
       Scanner input = new Scanner(System.in);
       System.out.print("Enter the starting page: ");
       int start = input.nextInt();
       System.out.print("Enter number of pages: ");
       int page = input.nextInt();
       // add 2 lines of code here to
       // insert values to bookPage
       for (int i=start;i<start+page;i++){
           bookPage.addLast(i);
       }
       selectedList = bookPage.getEven();
       //insert multiple lines of code here
       bookPage.printOdd();
       System.out.println();
       for(int i=selectedList.size() - 1;i>=0;i--){
           if(i == selectedList.size() - 1){
               System.out.println(" "+selectedList.get(i)+" ");
           }
           else {
               System.out.println(selectedList.get(i)+" ");
           }
       }
   }
}
