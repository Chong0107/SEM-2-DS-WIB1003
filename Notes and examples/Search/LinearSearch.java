
package Search;

import java.util.Arrays;

public class LinearSearch {
    public static int linearSearch(int[] list,int key){
        for(int i=0;i<list.length;i++){
            if(key == list[i]){
                return i;
            } 
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] list = {4, 5, 1, 2, 9, -3};
        String listDisplay = Arrays.toString(list);
        System.out.println(listDisplay);
        System.out.println("2 in index of "+linearSearch(list, 2));
    }
}
