
package Queue;

public class GenericQueue<E> {
    private java.util.LinkedList<E> list = new java.util.LinkedList<>();
    
    public void enqueue(E e){
        list.addLast(e);
    }
    
    public E dequeue(){
        return list.removeFirst();
    }
    
    public int getSize(){
        return list.size();
    }
    
    @Override
    public String toString(){
        return "Queue: "+ list.toString();
    }
}

class tester{
    public static void main(String[] args) {
        GenericQueue<String> queue = new GenericQueue<>();
        
        queue.enqueue("Tom");
        System.out.println("(1) "+queue);
        queue.enqueue("Susan");
        System.out.println("(2) "+queue);
        queue.enqueue("Kim");
        queue.enqueue("Micheal");
        System.out.println("(3) "+queue);
        
        System.out.println("(4) Deleted: "+queue.dequeue());
        System.out.println("(5) Deleted: "+queue.dequeue());
        System.out.println("(6) "+queue);
        
        
    }
}
