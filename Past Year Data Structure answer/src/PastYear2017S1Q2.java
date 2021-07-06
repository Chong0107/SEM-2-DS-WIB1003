import java.util.Arrays;
import java.util.NoSuchElementException;

public class PastYear2017S1Q2 {
    public static void main(String[] args) {
        NewQueue<Integer> number = new NewQueue<>();
        System.out.print("Say input: ");
        for (int i=1;i<10;i++){
            number.enqueue(i*10);
        }
        number.toString();
        number.ChangeOrder(4);
        System.out.println("And value of k: 4,");
        System.out.print("Thus the output: ");
        number.toString();
    }
}
class NewQueue<E> {
    public class ManyNode<E>{
        E element;
        ManyNode<E> next;

        public ManyNode(E element) {
            this.element = element;
        }
    }

    private ManyNode<E> head;
    private ManyNode<E> tail;
    private int size;

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

//    public NewQueue(E[] items){
//        for (E item : items){
//            enqueue(item);
//        }
//    }

    public NewQueue(){}

    public void enqueue(E e){
        if (isEmpty()){
            head = tail = new ManyNode<>(e);
        }
        else {
            tail.next = new ManyNode<>(e);
            tail = tail.next;
        }
        size++;
    }

    public E dequeue(){
        if (isEmpty()){
            throw new NoSuchElementException("The queue is empty.");
        }
        else {
            E toRemove;
            toRemove = head.element;
            if (size == 1){
                head = tail = null;
            }
            else {
                head = head.next;
            }
            size--;
            return toRemove;
        }
    }

    public void ChangeOrder(int k){
        if(k > size - 1)
            return;
        for(int i=0;i<k-1;i++){
            enqueue(dequeue());
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("");
        ManyNode<E> temp = head;
        while(temp != null){
            sb.append(temp.element);
            if(temp.next != null){
                sb.append(", ");
            }
            temp = temp.next;
        }
        System.out.println(sb.append("").toString());
        return sb.toString();
    }
}