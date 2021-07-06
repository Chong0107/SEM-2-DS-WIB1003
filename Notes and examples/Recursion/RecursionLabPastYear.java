
package Recursion;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;

public class RecursionLabPastYear {
    public static void main(String[] args) {
        // Mesh Topology
        System.out.println("Mesh Topology");
        System.out.println("There are 4 switches in the campus.");
        System.out.println("The total number of connections required is "+numberOfConnection(4));
        System.out.println("There are 7 switches in the campus.");
        System.out.println("The total number of connections required is "+numberOfConnection(7));
        System.out.println("");
        
        // Permutation of an integer
        Scanner sc = new Scanner(System.in);
        Random rmd = new Random();
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] elements = new int[n];
        System.out.println("The elements of the array: ");
        for(int i=0;i<elements.length;i++){
            elements[i] = rmd.nextInt(10);
            System.out.print(elements[i]);
        }
        System.out.println("");
        permutationOfInteger(elements);
    }
    // Number of connections
    public static int numberOfConnection(int switches){
        return numberOfConnection(switches - 1, 0);
    }
    
    public static int numberOfConnection(int switches, int connections){
        if(switches == 0){
            return connections;
        }
        else{
            return numberOfConnection(switches - 1,connections += switches);
        }
    }
    
    // Permutations of an integer
    public static void permutationOfInteger(int[] elements){
        if(elements.length >= 1){
            LinkedHashSet<String> list = new LinkedHashSet<>();
            permutationOfInteger(elements,0,list);
            ArrayList<String> sortedList = new ArrayList<>(list);
            for(String temp : sortedList){
                System.out.print(temp);
                System.out.println("");
            }
        }
    }
    
    public static void permutationOfInteger(int[] elements,int index,LinkedHashSet<String> list){
        if(index == elements.length){
            String str = "";
            boolean zero = true;
            for(int i=0;i<elements.length;i++){
                if(elements[i] != 0){
                    zero = false;
                }
                if(zero == false){
                    str += elements[i];
                }
            }
            list.add(str);
        }
        else{
            for(int i=index;i<elements.length;i++){
                int temp = elements[index];
                elements[index] = elements[i];
                elements[i] = temp;
                
                permutationOfInteger(elements,index+1,list);
                
                temp = elements[index];
                elements[index] = elements[i];
                elements[i] = temp;
            }
        }
    }
}
