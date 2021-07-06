public class CompareMax {
    public static <T extends Comparable<T>> T maximum (T a,T b,T c){
        T max = null;
        if(a.compareTo(b)>0 && a.compareTo(c)>0) {
            max = a;
        }
        else if(b.compareTo(a)>0 && b.compareTo(c)>0){
            max = b;
        }
        else if(c.compareTo(a)>0 && c.compareTo(b)>0){
            max = c;
        }
        return max;
    }
}
