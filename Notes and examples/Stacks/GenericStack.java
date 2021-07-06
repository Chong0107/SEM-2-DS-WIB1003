
package Stacks;

public class GenericStack<E> {
    private java.util.ArrayList<E> list = new java.util.ArrayList<>();
    
    public int getSize(){
        return list.size();
    }
    
    public void push(E o){
        list.add(o);
    }
    
    public E peek(){
        return list.get(getSize() - 1);
    }
    
    public E pop(){
        E o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }
    
    public boolean isEmpty(){
        return list.isEmpty();
    }
    
    @Override
    public String toString(){
        return "stack: "+list.toString();
    }
}
