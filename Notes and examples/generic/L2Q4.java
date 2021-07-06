package generic;

public class L2Q4 {
    public static <T extends Comparable<T>> String minmax(T[] array){
        T max = array[0];
        T min = array[0];
        for(int i=0;i<array.length;i++){
            if(array[i].compareTo(max)>0){
                max = array[i];
            }
            else if(array[i].compareTo(min)<0){
                min = array[i];
            }
        }
        return "Max: "+max+" Min: "+min;
    }
    public static void main(String[] args) {
        Integer[] intArray = {5,3,7,1,4,9,8,2};
        String[] strArray = {"red", "blue", "orange", "tan"};
        
        String intStr = minmax(intArray);
        System.out.println(intStr);
        
        String strStr = minmax(strArray);
        System.out.println(strStr);
    }
}
