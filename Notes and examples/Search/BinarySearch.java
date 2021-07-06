
package Search;

import java.util.Arrays;

public class BinarySearch {
    public static int binarySearch(int[] list,int key){
        int low = 0;
        int high = list.length - 1;
        while(high >= low){
            int mid = (low + high) / 2;
            if(key < list[mid])
                high = mid - 1;
            else if(key == list[mid])
                return mid;
            else
                low = mid + 1;
        }
        return -1 -low;
    }
    
    public static void main(String[] args) {
        int[] list = {-3,1,2,4,9,23};
        String listDisplay = Arrays.toString(list);
//        listDisplay = listDisplay.replace("[", " ");
//        listDisplay = listDisplay.replace("]", " ");
        System.out.println(listDisplay);
        System.out.println("2 in index of "+binarySearch(list,2));
    }
}

