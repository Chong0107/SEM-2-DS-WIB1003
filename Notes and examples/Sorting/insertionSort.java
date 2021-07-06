
package Sorting;

import java.util.Arrays;

public class insertionSort {
    public static void main(String[] args) {
        int[] list = {2,9,5,4,8,1,6};
        System.out.print("Insertion Sort:");
        insertionSort(list);
        String listDisplay = Arrays.toString(list);
        listDisplay = listDisplay.replace("[", " ");
        listDisplay = listDisplay.replace("]", " ");
        System.out.print(listDisplay);
        System.out.println("");
    }
    
    public static void insertionSort(int[] list){
        for(int i=0;i<list.length;i++){
            // insert list[i] into a sorted sublist list[0..i-1] so that
            // list[0..i] is sorted.
            int currentElement = list[i];
            int k;
            for(k=i-1;k>=0 && list[k]>currentElement;k--){
                list[k+1] = list[k];
            }
            // Insert the current element into list[k+1]
            list[k+1] = currentElement;
        }
    }
}
