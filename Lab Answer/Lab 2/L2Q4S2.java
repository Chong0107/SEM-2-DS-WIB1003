public class L2Q4S2 {
    public static <T extends Comparable<T>> String minmax(T [] arr){
        T min = arr[0];
        T max = arr[0];
        for(int i=0; i< arr.length;i++){
            if(arr[i].compareTo(max)>0){
                max = arr[i];
            }
            else if(arr[i].compareTo(min)<0){
                min = arr[i];
            }
        }
        return "Min: "+min+" Max: "+max;
    }
}
