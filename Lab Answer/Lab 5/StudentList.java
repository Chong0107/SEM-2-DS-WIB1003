import java.util.NoSuchElementException;
import java.util.Scanner;

public class StudentList<E>{
    public class StudentNode<E>{
        E element;
        StudentNode<E> next;

        public StudentNode() {
        }

        public StudentNode(E element) {
            this.element = element;
        }
    }

    private StudentNode<E> head;
    private StudentNode<E> tail;
    private int size;

    public StudentList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    // Append a new name at the end of the list.
    public void add(E e){
        StudentNode<E> newNode = new StudentNode<>(e);
        if(tail == null){
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
    }

    public void removeElement(E e){
        int index = indexOf(e);
        StudentNode<E> current = head;
        for(int i=1;i<index;i++){
            current = current.next;
        }
        StudentNode<E> temp = current.next;
        current.next = current.next.next;
        temp = null;
        size--;
    }

    public int indexOf(E e){
        int index = -1;
        StudentNode<E> current = head;
        for(int i=0;i < size;i++){
            if (current.element.equals(e)) {
                index = i;
                break;
            }
            current = current.next;
        }
        return index;
    }

    public boolean contains(E e){
        StudentNode<E> current = head;
        while(current != null){
            if(current.element.equals(e)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void replace (E e, E newE){
        StudentNode<E> current = head;
        for(int i=0;i<size;i++){
            if(current.element.equals(e)){
                current.element = newE;
                return;
            }
            current = current.next;
        }
        throw new NoSuchElementException(e + " is not existing in the list");
    }

    public void printList(){
        StringBuilder sb = new StringBuilder();
        StudentNode<E> current = head;
        while (current != null){
            sb.append(current.element);
            if(current.next != null){
                sb.append(", ");
            }
            current = current.next;
        }
        System.out.println(sb.append(".").toString());
    }
}

class StudentMS{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentList<String> studentList = new StudentList<>();

        System.out.println("Enter your student name list. Enter 'n' to end.....");
        String input = sc.nextLine();
        while(!input.equals("n")){
            studentList.add(input);
            input = sc.nextLine();
        }

        System.out.println("\nYou have entered the following students' name: ");
        studentList.printList();

        System.out.println("\nThe number of students entered is "+studentList.getSize());

        System.out.println("\nAll the names entered are correct? Enter 'r' to rename the student name, 'n' to proceed.");
        input = sc.nextLine();
        if(input.equals("r")){
            System.out.println("\nEnter the existing student name that you want to rename: ");
            input = sc.nextLine();
            System.out.println("\nEnter the new name:");
            String newName = sc.nextLine();
            studentList.replace(input, newName);
            System.out.println("\nThe new name list is: ");
            studentList.printList();
        }

        System.out.println("\nDo you have to remove any of your student name? Enter 'y' for yes, 'n' to proceed.");
        input = sc.nextLine();
        if(input.equals("y")){
            System.out.println("\nEnter a student name to remove: ");
            String name = sc.nextLine();
            studentList.removeElement(name);
            System.out.println("\nThe number of updated student is "+studentList.getSize());
            System.out.println("\nThe updated student list is: ");
            studentList.printList();
        }

        System.out.println("\nAll student data captured complete. Thank You !");
    }
}
