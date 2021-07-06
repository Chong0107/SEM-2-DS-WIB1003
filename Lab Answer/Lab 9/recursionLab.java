
package Recursion;

import java.util.Scanner;

public class recursionLab {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Factorial number
//        System.out.print("Enter a non-negative number: ");
//        int n = sc.nextInt();
//        System.out.println("Factorial of "+n+" ("+n+"!) is "+factorial(n));
        
        // Fibonacci number
//        System.out.print("Enter an index for a Fibonacci number: ");
//        int index = sc.nextInt();
//        System.out.println("Fibonacci number at index "+index+" is "+fibonacci(index));
        
        // Substitute "a" and "i"
//        System.out.print("Enter a string: ");
//        String str = sc.next();
//        System.out.println(substituteAI(str));
        
        // Permutation
//        System.out.print("Input String: 'ABC' "); 
//        System.out.println("\nOutput Permutation: ");
//        permuteString("","ABC");
        
        // Exponent
        System.out.print("Enter base number: ");
        int n1 = sc.nextInt();
        System.out.print("Enter power number: ");
        int n2 = sc.nextInt();
        System.out.println("Answer: "+exponent(n1,n2));
    }
    
    // Factorial number
    public static long factorial(int n){
        if(n==0){
            return 1;
        }
        else{
            return n * factorial(n - 1);
        }
    }
    
    // Fibonacci number
    public static long fibonacci(long n){
        if(n == 0){
            return 0;
        }
        else if(n == 1){
            return 1;
        }
        else{
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
    
    // Substitute "a" and "i"
    public static String substituteAI(String str){
        if(str.length() == 0){
            return str;
        }
        else if(str.charAt(0)=='a'){
            return 'i'+substituteAI(str.substring(1));
        }
        else{
            return str.charAt(0)+substituteAI(str.substring(1));
        }
    }
    
    // Permutation
    public static void permuteString(String begin,String end){
        // base case
        if(end.length() <= 1){
            System.out.println(begin + end);
        }
        // recursion case
        else{
            for(int i=0;i<end.length();i++){
                // fix position
                // "" + "BC" = "BC"
                // "" + "C" = "C"
                String newString = end.substring(0,i) + end.substring(i + 1);
                // left over
                permuteString(begin + end.charAt(i),newString);
            }
        }
    }
    
    // Exponent
    public static long exponent(int x, int m){
        if(m == 0){
            return 1;
        }
        else if(m == 1){
            return x;
        }
        else{
            return x * exponent(x,--m);
        }
    }
}
