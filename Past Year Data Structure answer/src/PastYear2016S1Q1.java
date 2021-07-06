import java.util.NoSuchElementException;
import java.util.Scanner;

public class PastYear2016S1Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList<String> food = new SinglyLinkedList<>();
        System.out.println("Enter your list of food to order. Enter 'n' to end.");
        String input = sc.nextLine();
        while(!input.equals("n")){
            food.add(input);
            input = sc.nextLine();
        }
        System.out.println("\nYou have ordered the following menu: ");
        food.printList();
        System.out.println("\nThe number of items ordered are: "+food.getSize());
        System.out.println("\nDo you want to change your order? Enter 'y' for yes, 'n' to proceed.");
        input = sc.nextLine();
        if(input.equals("y")){
            System.out.println("Enter the old menu item: ");
            input = sc.nextLine();
            System.out.println("\nEnter the new menu item: ");
            String newFood = sc.nextLine();
            if (food.contains(input)){
                food.replace(input,newFood);
            }
            System.out.println("\nThe new order list is: ");
            food.printList();
        }
        System.out.println("\nDo you want to remove any of your menu items? Enter 'y' for yes, 'n' to proceed.");
        input = sc.nextLine();
        if (input.equals("y")){
            System.out.println("Enter a menu item to remove: ");
            input = sc.nextLine();
            food.removeElement(input);
            System.out.println("\nThe number of updated order is: "+food.getSize());
            System.out.println("\nThe updated order is: ");
            food.printList();
        }
        else if(input.equals("n")){
            System.out.println("\nThe number of updated order is: "+food.getSize());
            System.out.println("\nThe updated order is: ");
            food.printList();
        }
        else{
            System.out.println("Please enter either 'y' or 'n' only.");
        }while(!input.equals("y")&&!input.equals("n"));
        System.out.println("\nYour order is complete. Thank you!");
    }
}

class SinglyLinkedList<E>{
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

    public SinglyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

//    public void addFirst(E e){
//        MyNode<E> newNode = new MyNode<>(e);
//        newNode.next = head; // Create pointer to current head
//        head = newNode; // new node created and assigned to new head
//        size++; // increase size
//        if(tail == null) // no node exists
//            tail = head;
//    }

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

//    public void add(int index,E e){
//        if(index == 0){
//            addFirst(e); // since requested to add at index 0
//        }
//        else if(index>=size){
//            addLast(e); // since requested to add at the last index
//        }
//        else{
//            MyNode<E> newNode = head; // set head to be a current node
//            for(int i=1;i<index;i++){ // traverse and stop before requested index
//                newNode = newNode.next;
//            }
//            MyNode<E> temp = newNode.next; // hold reference newNode.next
//            newNode.next = new MyNode<>(e); // newNode.next point to new node
//            (newNode.next).next = temp; // get the reference form temp
//            size++;
//        }
//    }

//    public E removeFirst(){
//        if(size == 0){
//            System.out.println("There is no elements to remove.");
//            return null; // no node in the list
//        }
//        else{
//            MyNode<E> temp = head; // copy head to temp node before delete
//            head = head.next; // set new head
//            size--; // reduce size
//            if(head == null){ // in case of head = null
//                tail = null;
//            }
//            return temp.element; // to know what we delete
//        }
//    }
//
//    public E removeLast(){
//        if(size == 0){
//            System.out.println("There is no elements to remove.");
//            return null;
//        }
//        else if(size == 1){ // only 1 node
//            MyNode<E> temp = head;
//            head = tail = null; // reset to know
//            size = 0;
//            return temp.element; // to know what we delete
//        }
//        else{
//            MyNode<E> current = head;
//            for(int i=0;i<size-2;i++){
//                current  = current.next;// stop 1 node before tail
//            }
//            MyNode<E> temp = tail; // copy tail to temp before delete
//            tail = current; // current become tail
//            tail.next = null; // reset the next for tail to be null
//            size--;
//            return temp.element;
//        }
//    }
//
//    public E remove(int index){
//        if(index < 0 || index >= size){
//            return null;
//        }
//        else if(index == 0){
//            return removeFirst();
//        }
//        else if(index == size - 1){
//            return removeLast();
//        }
//        else{
//            MyNode<E> previous = head; // set head to previous
//            for(int i=1;i<index;i++){
//                previous = previous.next; // stop before index that want to be deleted
//            }
//            MyNode<E> current = previous.next; // copy previous.next to current
//            previous.next = current.next; // set new point to from previous.next to current.next
//            size--; // reduce size
//            return current.element;
//        }
//    }


    public void removeElement(E e){
        MyNode<E> current = head;
        MyNode<E> prev = current;
        while(current != null){
            if(current.element.equals(e)){
                if(size == 1){
                    head = tail = null;
                }
                else if(current == head){
                    head = head.next;
                }
                else if(current == tail){
                    prev.next = null;
                    tail = prev;
                }
                else{
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
        System.out.println("Item you want to remove is not in the existing order list.");
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

    public void replace(E e, E newE) {
        if(!contains(e)){
            System.out.println("Item you want to replace is not in the existing order list.");
        }
        for(MyNode<E> x = head; x != null; x = x.next) {
            if(x.element.equals(e)) {
                x.element = newE;
                return;
            }
        }
    }

    // print list
    public void printList(){
//        StringBuilder sb = new StringBuilder("");
//        for(MyNode<E> x = head; x != null; x = x.next){
//            if(x.element != null){
//                sb.append(x.element.toString());
//            }
//            else{
//                sb.append("null");
//            }
//            if(x.next != null){
//                sb.append(", ");
//            }
//        }
//        sb.append(".").toString();
//        return sb.toString();
        StringBuilder sb = new StringBuilder();
        MyNode<E> temp = head;
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

