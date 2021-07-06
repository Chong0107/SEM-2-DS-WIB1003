import com.sun.source.tree.WhileLoopTree;

import java.util.NoSuchElementException;

public class DoublyLinked <E>{
    public class Node<E>{
        E element;
        Node<E> next;
        Node<E> prev;

        public Node(E element, Node<E> next, Node<E> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public Node(E element) {
            this(element,null,null);
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DoublyLinked() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addFirst(E element){
        Node<E> temp = new Node<>(element,head,null);
        if(head != null){
            head.prev = temp;
        }
        head = temp;
        if(tail == null){
            tail = temp;
        }
        size++;
        System.out.println("adding: "+element);
    }

    public void addLast(E element){
        Node<E> temp = new Node<>(element,null,tail);
        if(tail != null){
            tail.next = temp;
        }
        tail = temp;
        if(head == null){
            head = temp;
        }
        size++;
        System.out.println("adding: "+element);
    }

    public void add(int index, E element){
        if(index < 0 || index > size){
            throw new NoSuchElementException(element+" is not in the list.");
        }
        else if(index == 0){
            addFirst(element);
        }
        else if(index == size){
            addFirst(element);
        }
        else {
            Node<E> temp = head;
            for(int i=0;i<index;i++){
                temp = temp.next;
            }
            Node<E> insert = new Node<>(element,temp,temp.prev);
            temp.prev.next = insert;
            temp.prev = insert;
            size++;
        }
    }

    public void iterateForward(){
        System.out.println("iterating forward.....");
        Node<E> temp = head;
        while (temp != null){
            System.out.print(temp.element+" ");
            temp = temp.next;
        }
    }

    public void iterateBackward(){
        System.out.println("iterating backward.....");
        Node<E> temp = tail;
        while (temp != null){
            System.out.print(temp.element+" ");
            temp = temp.prev;
        }
    }

    public E removeFirst(){
        if(size == 0){
            throw new NoSuchElementException("No node in the list");
        }
        Node<E> temp = head;
        head = head.next;
        head.prev = null;
        size--;
        System.out.println("deleted: "+temp.element);
        return temp.element;
    }

    public E removeLast(){
        if(size == 0){
            throw new NoSuchElementException("No node in the list");
        }
        Node<E> temp = tail;
        tail = tail.prev;
        tail.next = null;
        size--;
        System.out.println("deleted: "+temp.element);
        return temp.element;
    }

    public E remove(int index){
        E element = null;
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            removeFirst();
        }
        else if(index == size - 1){
            removeLast();
        }
        else{
            Node<E> temp = head;
            for(int i=0;i<index;i++){
                temp = temp.next;
            }
            element = temp.element;
            temp.next.prev = temp.prev;
            temp.prev.next = temp.next;
            temp.next = null;
            temp.prev = null;
            size --;
        }
        return element;
    }

    /*
    // Helper method to get the node at the current index faster
    private Node<E> getNode(int index){
        // Assume that :
        // - index is not out of bound
        // - index is not the first or the last node
        // - the list is not empty
        Node<E> desiredNode = null;
        if(index <= size / 2){
            desiredNode = head;
            for(int i=0; i<index;i++){
                desiredNode = desiredNode.next;
            }
        }
        else if(index> size / 2){
            desiredNode = tail;
            for(int i = size - 1; i> index;i--){
                desiredNode = desiredNode.prev;
            }
        }
        return desiredNode;
    }
     */

    public void clear(){
        Node<E> temp = head;
        while (temp != null){
            temp = head.next;
            head.prev = head.next = null;
            head = temp;
        }
        System.out.println("successfully clear "+size+" node(s).");
        temp = null;
        tail.prev = tail.next = null;
        size = 0;
    }

    /*
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        for (Node<E> current = head; current != null; current = current.next) {
            sb.append(current.element);
            if (current.next != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    */

    public static void main(String[] args) {
        DoublyLinked<Integer> doublyLinked = new DoublyLinked<>();
        doublyLinked.addFirst(1);
        doublyLinked.addFirst(10);
        doublyLinked.addLast(100);
        doublyLinked.add(2,2);
        doublyLinked.remove(3);
        doublyLinked.iterateForward();
        System.out.println();
        doublyLinked.iterateBackward();
        System.out.println();
        System.out.println("size of current Doubly Linked List: "+doublyLinked.size());
        doublyLinked.clear();
        System.out.println("size of current Doubly Linked List: "+doublyLinked.size());
    }
}
