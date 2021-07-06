import java.util.Arrays;

public class PastYear2016S1Q3 {
    public static void main(String[] args) {
        int[] num = {82,54,71,86,43,99};
        theSort(num);
    }

    public static void theSort(int[] num){
        int numberOfRepetition = 0;
        for (int i=1;i<num.length;i++){
            int currentElement = num[i];
            int k;
            System.out.println("Insert element at "+i+" into sorted sublist "+ Arrays.toString(num));
            for(k=i-1;k>=0 && num[k] > currentElement;k--){
                num[k+1] = num[k];
                System.out.println("\tRearrange sorted sublist (" + 0 + "-" + i + ") " + Arrays.toString(num));
                numberOfRepetition++;
            }
            System.out.println("k: "+k);
            if (currentElement != num[k+1]) {
                num[k + 1] = currentElement;
                System.out.println("\tRearranging result (" + 0 + "-" + i + ") " + Arrays.toString(num));
            }
            numberOfRepetition++;
            System.out.println();
        }
        System.out.println("Total iteration needed: "+numberOfRepetition);
    }
}
