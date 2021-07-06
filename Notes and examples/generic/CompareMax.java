
package generic;

public class CompareMax {
    public static <E extends Comparable<E>> E max (E a,E b,E c){
        E max = a;
        if(max.compareTo(b)<0){
            max = b;
        }
        if(max.compareTo(c)<0){
            max = c;
        }
        return max;
    }
    
    public static void main(String[] args) {
        System.out.printf("Max of %d, %d and %d is %d. \n\n",3,4,5,max(3,4,5));
        System.out.printf("Max of %.1f, %.1f and %.1f is %.1f. \n\n",3.3,4.4,5.5,CompareMax.<Double>max(3.3,4.4,5.5));
        System.out.printf("Max of %s, %s and %s is %s. \n\n","pear","apple","orange",max("pear","apple","orange"));
    }
}
