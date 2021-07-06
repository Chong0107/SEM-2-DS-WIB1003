
package DoublyLinkListed;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class StudentList <E>{
    public class Node<E>{
        E element;
        Node<E> next;

        public Node() {
        }

        public Node(E element) {
            this.element = element;
        }
    }
    
    private int size;
    private Node<E> head;
    private Node<E> tail;

    public StudentList() {
        size = 0;
        head = null;
        tail = null;
    }

    public int getSize() {
        return size;
    }
    
    public void add(E e){
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
    
    public int indexOf(E e){
        Node<E> current = head;
        for(int i=0;i<size;i++){
            if(current.element.equals(e)){
                return i;
            }
            current = current.next;
        }
        return -1;
    }
    
    public void removeElement(E e){
        int index = indexOf(e);
        Node<E> previous = head;
        for(int i=1;i<index;i++){
            previous = previous.next;
        }
        Node<E> current = previous.next;
        previous.next = current.next;
        size--;
    }
    
    public boolean contains(E e){
        Node<E> current = head;
        while(current != null){
            if(current.element.equals(e)){
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    public void replace(E e,E newE){
        Node<E> current = head;
        for(int i=0;i<size;i++){
            if(current.element.equals(e)){
                current.element = newE;
                return;
            }
            current = current.next;
        }
        throw new NoSuchElementException(e+" is not in the list.");
    }
    
    public void printList(){
        StringBuilder sb = new StringBuilder();
        Node<E> temp = head;
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

class tester{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentList<String> list = new StudentList<>();
        System.out.println("Enter your student name list. Enter 'n' to end...");
        String input = sc.nextLine();
        while(!input.equals("n")){
            list.add(input);
            input = sc.nextLine();
        }
        
        System.out.println("\nYou have entered the following students' name: ");
        list.printList();
        
        System.out.println("\nThe number of students entered is "+list.getSize());
        
        System.out.println("\nAll the names entered are correct? Enter 'r' to rename the student name, 'n' to proceed.");
        input = sc.nextLine();
        if(input.equals("r")){
            System.out.println("\nEnter the existing name that you want to rename:");
            input = sc.nextLine();
            System.out.println("\nEnter the new name:");
            String newName = sc.nextLine();
            list.replace(input, newName);
            System.out.println("\nThe new student list is: ");
            list.printList();
        }
        
        System.out.println("\nDo you have to remove any of your student name? Enter 'y' for yes, 'n' to proceed.");
        input = sc.nextLine();
        if(input.equals("y")){
            System.out.println("\nEnter a student name to remove: ");
            String name = sc.nextLine();
            list.removeElement(name);
            System.out.println("\nThe number of updated student is: "+list.getSize());
            System.out.println("\nThe updated students list is: ");
            list.printList();
        }
        
        System.out.println("\nAll student data captured complete. Thank You !");
    }
}