
package DoublyLinkListed;

import java.util.NoSuchElementException;

public class DoublyLinkedList<E>{
    public class Node<E>{
        E element;
        Node<E> next;
        Node<E> prev;

        public Node(E element, Node<E> next, Node<E> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
        
        public Node(E element){
            this(element,null,null);
        }
    }
    
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DoublyLinkedList() {
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
    
    public void addFirst(E element){
        // create object temp and set pointer of the new node
        Node<E> temp = new Node(element,head,null);
        // set head.prev of current head to be linked to the new node
        if(head != null){
            head.prev = temp;
        }
        // now temp become head
        head = temp;
        // if no tail, then temp set to be a tail
        if(tail == null){
            tail = temp;
        }
        // increase the number of node
        size++;
        System.out.println(element);
    }
    
    public void addLast(E element){
        // create object temp and set pointer of the previous node
        Node<E> temp = new Node(element,null,tail);
        // set tail.next point to object temp
        if(tail != null){
            tail.next = temp;
        }
        // now temp become tail
        tail = temp;
        // if no head, then temp set to be a head
        if(head == null){
            head = temp;
        }
        // increase the number of node
        size++;
        System.out.println(element);
    }
    
    public void add(int index, E element){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            addFirst(element);
        }
        else if(index == size){
            addLast(element);
        }
        else{
            /* set from head and begin traverse
             stop on required position */
            Node<E> temp = head;
            for(int i=0;i<index;i++){
                temp = temp.next;
            }
            /* create object insert and set pointer of the next pointer
            to the temp node and also set pointer of the prev pointer
            to the temp.prev node
            */
            Node<E> insert = new Node(element,temp,temp.prev);
            //set pointer 'next' of the node temp.prev to new node insert
            temp.prev.next = insert;
            //set pointer 'prev' of the node temp to new node insert
            temp.prev = insert;
            size++;
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
    
    public void iterateBackward(){
        System.out.println("iterating backward......");
        Node<E> temp = tail;
        while(temp != null){
            System.out.print(temp.element+" ");
            temp = temp.prev;
        }
    }
    
    public E removeFirst(){
        if(size == 0) {
            throw new NoSuchElementException();
        }
        // copy head to node temp
        Node<E> temp = head;
        // head.next become a head
        head = head.next;
        // set pointer of prev of new head to be null
        head.prev = null;
        //reduce number of node
        size--;
        System.out.println("Deleted: "+temp.element);
        return temp.element;
    }
    
    public E removeLast(){
        if(size == 0) {
            throw new NoSuchElementException();
        }
        // copy tail to node temp
        Node<E> temp = tail;
        // tail.prev become a tail
        tail = tail.prev;
        // set pointer of next of new tail to be null
        tail.next = null;
        //reduce number of node
        size--;
        System.out.println("Deleted: "+temp.element);
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
    
    public void clear(){
        Node<E> temp = head;
        while(head != null){
            temp = head.next;
            head.prev = head.next = null;
            head = temp;
        }
        temp = null;
        tail.prev = tail.next = null;
        size = 0;
    }
    
    public E set(int index, E e) {
        if (index < 0)
            throw new IndexOutOfBoundsException();
        else if (index >= size) {
            this.addLast(e);
            return null;
        } else if (index == 0) {
            E temp = head.element; // should make a copy of the value and not the reference
            head.element = e;
            return temp;
        } else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        E temp = current.next.element;
        current.next.element = e;
        return temp;
   }
}

    public static void main(String a[]) {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<Integer>();
        doublyLinkedList.addFirst(1);
        doublyLinkedList.addFirst(0);
        doublyLinkedList.addLast(3);
        doublyLinkedList.addLast(4);
        doublyLinkedList.set(2,100);
        doublyLinkedList.iterateForward();
        System.out.println("");
        /*
        doublyLinkedList.add(2,1000);
        doublyLinkedList.remove(3);
        doublyLinkedList.iterateForward();
        System.out.println();
        doublyLinkedList.iterateBackward();
        System.out.println();
        System.out.println("Size: "+doublyLinkedList.size());
        doublyLinkedList.removeFirst();
        doublyLinkedList.removeLast();
        doublyLinkedList.iterateForward();
        System.out.println();
        */
    }
}
