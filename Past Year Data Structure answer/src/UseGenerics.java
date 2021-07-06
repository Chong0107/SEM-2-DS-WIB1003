public class UseGenerics <T extends Comparable<T> >{
    private T a;

    public void compareMax(T p,T q){
        if(p.compareTo(q)>0)
            a = p;
        else
            a = q;
    }

    public T getA(){
        return a;
    }

    public static void main(String[] args) {
        int x = 3;
        int y = 5;
        UseGenerics<Integer> run1 = new UseGenerics<>();
        System.out.println("Max is "+run1.getA());
//        System.out.println(new UseGenerics<>("Hello","World"));
    }
}
