
package Sorting;

import java.util.Arrays;

public class selectionSort {
    public static void main(String[] args) {
        double[] list = {2,9,5,4,8,1,6};
        System.out.print("Selection Sort:");
        selectionSort(list);
        String listDisplay = Arrays.toString(list);
        listDisplay = listDisplay.replace("[", " ");
        listDisplay = listDisplay.replace("]", " ");
        System.out.println(listDisplay);
    }
    
    public static void selectionSort(double[] list){
        for(int i=0;i<list.length;i++){
            // select the smallest element in list[i..listSize-1]
            double currentMin = list[i];
            int currentMinIndex = i;
            for(int j = i+1; j<list.length;j++){
                if(currentMin > list[j]){
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
            
            // swap the smallest with list[i], if necessary
            if(currentMinIndex != i){
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }
}
