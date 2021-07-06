
package Sorting;

import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        int[] list = {2,9,5,4,8,1,6};
        System.out.print("Bubble Sort: ");
        bubbleSort(list);
        String listDisplay = Arrays.toString(list);
        listDisplay = listDisplay.replace("[", " ");
        listDisplay = listDisplay.replace("]", " ");
        System.out.println(listDisplay);
    }
    
    public static void bubbleSort(int[] list){
        boolean needNextPass = true;
        for(int k=1; k<list.length && needNextPass;k++){
            for(int i=0;i<list.length-k;i++){
                // swap list[i] with list[i+1] 
                if(list[i]>list[i+1]){
                    int temp = list[i];
                    list[i] = list[i+1];
                    list[i+1] = temp;
                    needNextPass = true;
                }
            }
        }
    }
}
