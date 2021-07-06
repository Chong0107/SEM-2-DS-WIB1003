
package LinkedList;

public class LinkedList<E> {
    public class Node<E>{
        E element;
        Node<E> next;

        public Node() {
        }

        public Node(E element) {
            this.element = element;
        }
    }
    
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedList() {
        size = 0;
        head = null;
        tail = null;
    }
    
    public int size(){
        return size;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public void addFirst(E e){
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;
        size++;
        if(tail == null){
            tail = head;
        }
    }
    
    public void addLast(E e){
        Node<E> newNode = new Node<>(e);
        if(tail == null){
            head = tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
    }
    
    public void add(int index, E e){
        if(index == 0){
            addFirst(e);
        }
        else if(index >= size){
            addLast(e);
        }
        else{
            Node<E> current = head;
            for(int i=1;i<index;i++){
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<>(e);
            (current.next).next = temp;
            size++;
        }
    }
    
    public E removeFirst(){
        if(size == 0){
            return null;
        }
        else{
            Node<E> temp = head;
            head = head.next;
            size--;
            if(head == null){
                tail = null;
            }
            return temp.element;
        }
    }
    
    public E removeLast(){
        if(size == 0){
            return null;
        }
        else if(size == 1){
            Node<E> temp = tail;
            head = tail = null;
            size--;
            return temp.element;
        }
        else{
            Node<E> current = head;
            for(int i=0;i<size - 2;i++){
                current = current.next;
            }
            // stop 1 node before tail
            Node<E> temp = tail;
            // copy tail to temp before delete
            tail = current;
            // current become tail
            tail.next = null;
            // reset the next for tail
            // to be null
            size--;
            return temp.element;
        }
    }
    
    public E remove(int index){
        if(index < 0 || index >= size){
            return null;
        }
        else if(index == 0){
            return removeFirst();
        }
        else if(index == size - 1){
            return removeLast();
        }
        else{
            Node<E> prev = head;
            for(int i=1;i<index;i++){
                prev = prev.next;
            }
            Node<E> current = prev.next;
            prev.next = current.next;
            size--;
            return current.element;
        }
    }
    
    public void iterateForward(){
        System.out.println("iterating forward......");
        Node<E> temp = head;
        while(temp != null){
            System.out.print(temp.element+" ");
            temp = temp.next;
        }
    }
}

class tester{
    public static void main(String[] args) {
        LinkedList<String> name = new LinkedList<>();
        name.addFirst("Chong");
        name.addFirst("Lim");
        name.addLast("Lew");
        name.add(2, "Ahmad");
        name.iterateForward();
        System.out.println();
        name.removeFirst();
        name.removeLast();
        name.remove(1);
        name.iterateForward();
        System.out.println();
    }
}
