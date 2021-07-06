package generic;

public class StorePairGeneric <E extends Comparable<E>> implements Comparable<StorePairGeneric<E>>{
    private E first, second;
    
    public StorePairGeneric(E first, E second) {
        this.first = first;
        this.second = second;
    }   
    
    public E getFirst() {
        return first;
    }
    
    public E getSecond() {
        return second;
    }
    
    public void setPair(E first, E second) {
        this.first = first;
        this.second = second;
    }
    
    @Override
    public String toString() {
        return "first = " + first + " second = " + second;
    }
    
    @Override
    public boolean equals(Object obj){
        StorePairGeneric <E> other = (StorePairGeneric<E>) obj;
        return this.first.equals(other.first);
    } 
    
    @Override
    public int compareTo(StorePairGeneric<E> o){
        return this.first.compareTo(o.first);
    }
}

class tester{
    public static void main(String[] args) {
        StorePairGeneric<Integer> a = new StorePairGeneric(6,4);
        StorePairGeneric<Integer> b = new StorePairGeneric(2,2);
        StorePairGeneric<Integer> c = new StorePairGeneric(6,3);
        
        System.out.println("a. "+a);
        System.out.println("b. "+b);
        System.out.println("c. "+c);
        
        System.out.println("a compare to b ? "+a.compareTo(b));
        System.out.println("a compare to c ? "+a.compareTo(c));
        System.out.println("b compare to c ? "+b.compareTo(c));
        
        System.out.println("a equals to b ? "+a.equals(b));
        System.out.println("a equals to c ? "+a.equals(c));
        System.out.println("b equals to c ? "+b.equals(c));
    }
}
