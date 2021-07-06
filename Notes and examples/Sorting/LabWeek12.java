
package Sorting;

import java.util.Arrays;

public class LabWeek12 {
    public static void main(String[] args) {
        int[] arr = {45, 7, 2, 8, 19, 3};
        System.out.print("Selection Sort (smallest): ");
        selectionSortSmallest(arr);
        String arr1Display = Arrays.toString(arr);
        arr1Display = arr1Display.replace("["," ");
        arr1Display = arr1Display.replace("]"," ");
        System.out.println(arr1Display);
        
        System.out.print("Selection Sort (largest): ");
        selectionSortLargest(arr);
        String arr2Display = Arrays.toString(arr);
        arr2Display = arr2Display.replace("["," ");
        arr2Display = arr2Display.replace("]"," ");
        System.out.println(arr2Display);
        
        System.out.print("Insertion Sort: ");
        insertionSort(arr);
        String arr3Display = Arrays.toString(arr);
        arr3Display = arr3Display.replace("["," ");
        arr3Display = arr3Display.replace("]"," ");
        System.out.println(arr3Display);
    }
    
    public static void selectionSortSmallest(int[] arr){
        for(int i=0;i<arr.length;i++){
            int currentMin = arr[i];
            int currentMinIndex = i;
            for(int j=i+1;j<arr.length;j++){
                if(currentMin>arr[j]){
                    currentMin = arr[j];
                    currentMinIndex = j;
                }
            }
            
            if(currentMinIndex != i){
                arr[currentMinIndex] = arr[i];
                arr[i] = currentMin;
            }
        }
    }
    
    public static void selectionSortLargest(int[] arr){
        for(int i=0;i<arr.length;i++){
            int currentMin = arr[i];
            int currentMinIndex = i;
            for(int j=i+1;j<arr.length;j++){
                if(currentMin<arr[j]){
                    currentMin = arr[j];
                    currentMinIndex = j;
                }
            }
            
            if(currentMinIndex != i){
                arr[currentMinIndex] = arr[i];
                arr[i] = currentMin;
            }
        }
    }
    
    public static void insertionSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int currentElement = arr[i];
            int k;
            for(k=i-1;k>=0 && arr[k]>currentElement;k--){
                arr[k+1] = arr[k];
            }
            arr[k+1] = currentElement;
        }
    }
}
