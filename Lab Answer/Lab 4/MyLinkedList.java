
package LinkedList;

import java.util.NoSuchElementException;

public class MyLinkedList<E> {
    public class MyNode<E>{
        E element;
        MyNode<E> next;

        public MyNode(E element) {
            this.element = element;
        }
    }
    
    private MyNode<E> head;
    private MyNode<E> tail;
    private int size;
    
    public MyLinkedList(){
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
    
    public void addFirst(E e){
        MyNode<E> newNode = new MyNode<>(e);
        newNode.next = head; // Create pointer to current head
        head = newNode; // new node created and assigned to new head
        size++; // increase size
        if(tail == null) // no node exists
          tail = head;
    }
    
    public void addLast(E e){
        if(tail == null){ // no node existe
            head = tail = new MyNode<>(e);
        }
        else{
            tail.next = new MyNode<>(e); // tail.next point to new Node
            tail = tail.next; // new tail updated from tail.next
        }
        size++;
    }
    
    public void add(int index,E e){
        if(index == 0){
            addFirst(e); // since requested to add at index 0 
        }
        else if(index>=size){
            addLast(e); // since requested to add at the last index
        }
        else{
            MyNode<E> newNode = head; // set head to be a current node
            for(int i=1;i<index;i++){ // traverse and stop before requested index
                newNode = newNode.next;
            }
            MyNode<E> temp = newNode.next; // hold reference newNode.next 
            newNode.next = new MyNode<>(e); // newNode.next point to new node 
            (newNode.next).next = temp; // get the reference form temp
            size++;
        }
    }
    
    public E removeFirst(){
        if(size == 0){
            System.out.println("There is no elements to remove.");
            return null; // no node in the list
        }
        else{
            MyNode<E> temp = head; // copy head to temp node before delete
            head = head.next; // set new head
            size--; // reduce size
            if(head == null){ // in case of head = null
                tail = null; 
            }
            return temp.element; // to know what we delete
        }
    }
    
    public E removeLast(){
        if(size == 0){
            System.out.println("There is no elements to remove.");
            return null;
        }
        else if(size == 1){ // only 1 node
            MyNode<E> temp = head;
            head = tail = null; // reset to know
            size = 0;
            return temp.element; // to know what we delete
        }
        else{
            MyNode<E> current = head;
            for(int i=0;i<size-2;i++){
                current  = current.next;// stop 1 node before tail
            }
            MyNode<E> temp = tail; // copy tail to temp before delete
            tail = current; // current become tail
            tail.next = null; // reset the next for tail to be null
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
            MyNode<E> previous = head; // set head to previous 
            for(int i=1;i<index;i++){
                previous = previous.next; // stop before index that want to be deleted
            }
            MyNode<E> current = previous.next; // copy previous.next to current
            previous.next = current.next; // set new point to from previous.next to current.next
            size--; // reduce size
            return current.element;
        }
    }
    
    // Return nothing, but adds an element to the list
    public void add(E e){
        addLast(e);
    }
    
    //Return true if list contains the element e
    public boolean contains (E e){
        if(isEmpty()){
            return false;
        }
        if(head.element.equals(e) || tail.element.equals(e)){
            return true;
        }
        MyNode<E> current = head;
        for(int i=1;i<size-1;i++){
            current = current.next;
            if(current.element.equals(e)){
                return true;
            }
        }
        return false;
    }
    
    // Return element at the specified index
    public E get(int index){
        if(index == 0){
            return getFirst();
        }
        else if(index == size - 1){
            return getLast();
        }
        else if(index > 0 && index < size){
            MyNode<E> current = head;
            for(int i=0;i<index;i++){
                current = current.next;
            }
            return current.element;
        }
        throw new IndexOutOfBoundsException();
    }
    
    // Return the value of the first item
    public E getFirst(){
        if(head != null){
            return head.element;
        }
        else{
            throw new NoSuchElementException();
        }
    }
    
    // Return the value of the last item
    public E getLast(){
        if(tail != null){
            return tail.element;
        }
        else{
            throw new NoSuchElementException();
        }
    }
    
    // Return the index of the head matching element in this list.
    // Return -1 of no match
    public int indexOf(E e){
        int index = 0;
        for(MyNode<E> x = head; x != null; x = x.next) {
            if(x.element.equals(e))
                return index;
            index++;
        }
        return -1;
    }
    
    // Return the index of the last matching element in this list.
    // Return -1 of no match
    public int lastIndexOf(E e){
        int index = 0;
        int target = -1;
        for(MyNode<E> x = head; x != null; x = x.next){
            if(x.element.equals(e)){
                target = index;
            }
            index++;
        }
        return target;
    }
    
    // Replace the element at the specified position in this
    // list with the specified element
    public E set(int index,E element){
        E returnElement = null;
        if(index>=0 && index<size){
            MyNode<E> current = head;
            for(int i=0;i<index;i++){
                current = current.next;
            }
            returnElement = current.element;
            current.element = element;
        }
        return returnElement;
    }
    
    // Clear this list
    public void clear(){
        for(MyNode<E> x = head; x != null; x = x.next){
            MyNode<E> next = x.next;
            x.element = null;
            x.next = null;
            x = next;
        }
        head = null;
        tail = null;
        size = 0;
    }
    
    // Print all the elements in the list
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for(MyNode<E> x = head; x != null; x = x.next){
            if(x.element != null){
                sb.append(x.element.toString());
            }
            else{
                sb.append("null");
            }
            if(x.next != null){
                sb.append(", ");
            }
        }
        sb.append("]").toString();
        return sb.toString();
    }
    
    // Print all elements in reverse order
    public void reverse(){
        StringBuilder sb = new StringBuilder("[");
        Object[] result = new Object[size];
        int i=0;
        for(MyNode<E> x = head; x != null; x = x.next){
            result[i] = x.element;
            i++;
        }
        for(int j=result.length-1;j>-1;j--){
            if(result[j] != null){
                sb.append(result[j].toString());
            }
            else{
                sb.append("null");
            }
            if(j != 0){
                sb.append(", ");
            }
        }
        System.out.println(sb.append("]").toString());
    }
}
