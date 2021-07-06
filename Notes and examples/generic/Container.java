package generic;

public class Container <T>{
    private T t;

    public Container() {
    }
    
    public void add(T t){
        this.t = t;
    }
    
    public T retireve(){
        return this.t;
    }
    
    public static void main(String[] args) {
        Container<Integer> a = new Container();
        Container<String> b = new Container();
        
        a.add(50);
        b.add("Java");
        
        System.out.println(a.retireve());
        System.out.println(b.retireve());
    }
}
