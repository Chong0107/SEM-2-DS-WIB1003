
package DoublyLinkListed;

import java.util.NoSuchElementException;

public class SList <E>{
    public class SNode<E>{
        E element;
        SNode<E> next;

        public SNode() {
        }

        public SNode(E element) {
            this.element = element;
        }
    }
    
    private int size;
    private SNode<E> head;
    private SNode<E> tail;

    public SList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    // Append a new element at the end of the list.
    public void appendEnd(E e){
        SNode<E> newNode = new SNode<>(e);
        if(tail == null){
            head = tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
    }
    
    // Eliminate the first element in the list.
    public E removeInitial(){
        if(size == 0){
            throw new NoSuchElementException();
        }
        SNode<E> temp = head;
        head = head.next;
        size--;
        return temp.element;
    }
    
    // Search for an element and returns true
    // if this list contains the searched element
    public boolean contains(E e){
        SNode<E> current = head;
        while(current != null){
            if(current.element.equals(e)){
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    // Empty all elements in the list and
    // return a statement that reports that the list is empty.
    public void clear(){
        SNode<E> temp = head;
        while(head != null){
            temp = head.next;
            head.next = null;
            head = temp;
        }
        temp = null;
        tail.next = null;
        size = 0;
    }
    
    // Display all values from the list in a successive order.
    public void display(){
        StringBuilder sb = new StringBuilder ();
        SNode<E> temp = head;
        while(temp != null){
            sb.append(temp.element);
            if(temp.next != null){
                sb.append(", ");
            }
            temp = temp.next;
        }
        System.out.println(sb.append(".").toString());
    }
}

class TestList{
    public static void main(String[] args) {
        SList<String> list = new SList<>();
        list.appendEnd("Linked list");
        list.appendEnd("is");
        list.appendEnd("easy");
        list.display();
        list.removeInitial();
        list.display();
        System.out.println("Is the word \"difficult\" in the list ? "+list.contains("difficult"));
        list.clear();
    }
}
