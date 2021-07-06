
package generic;

// Create a class that used to generate N number of non-duplicate integer in between 0 –
// 100. The class must display the number in sorted list. The class must be generic to
// support array and linked-list implementation.

import java.util.LinkedList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public abstract class Generator<E> {
    public abstract void generateNumbers(int n);
    public abstract void display();
}

class ArrayGenerator extends Generator<int []>{
    private int[] list;

    public ArrayGenerator(int n) {
        list = new int[n];
        generateNumbers(n);
    }
    
    public void generateNumbers(int n){
        Random r = new Random();
        for(int i=0;i<n;i++){
            int randomNumber = r.nextInt(101);
            list[i] = randomNumber;
            for(int j=0;j<i;j++){
                if(list[j] == randomNumber){
                    i--;
                    break;
                }
            }
        }
        Arrays.sort(list);
    }

    @Override
    public void display() {
        for(int i : list){
            System.out.print(i+" ");
        }
    }
}

class LinkedListGenerator extends Generator<LinkedList>{
    private LinkedList<Integer> list;

    public LinkedListGenerator(int n) {
        list = new LinkedList<>();
        generateNumbers(n);
    }

    @Override
    public void generateNumbers(int n) {
         Random r = new Random();
         for(int i=0;i<n;i++){
             int randomNumber = r.nextInt(101);
             if(list.size()>0){
                 while(list.contains(randomNumber)){
                     randomNumber = r.nextInt(101);
                 }
             }
             list.add(randomNumber);
         }
         Collections.sort(list);
    }

    @Override
    public void display() {
        for(Object i: list){
            System.out.print(i+" ");
        }
    }
}

class testGenerator{
    public static void main(String[] args) {
        System.out.println("Generate 20 non-duplicated integer within 0 - 100:");
        System.out.println("Linked List Implementation: ");
        LinkedListGenerator list1 = new LinkedListGenerator(20);
        list1.display();
        System.out.println(" ");
        System.out.println("Array Implementstion: ");
        ArrayGenerator list2 = new ArrayGenerator(20);
        list2.display();
        System.out.println(" ");
    }
}