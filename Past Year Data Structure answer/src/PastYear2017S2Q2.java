import java.util.ArrayList;
import java.util.Scanner;

public class PastYear2017S2Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GenericStack<String> book = new GenericStack<>();
        System.out.println("isEmpty() returns "+book.isEmpty());
        System.out.println();
        System.out.println("Push 3 books to the pile: ");
        for(int i=0;i<3;i++){
            System.out.print("Enter book title "+(i+1)+": ");
            book.push(sc.nextLine());
        }
        System.out.println();
        System.out.println("The new books that you added are: "+book.toString());
        System.out.println();
        // Check whether the pile is empty or not
        System.out.println("The pile should not be empty:");
        System.out.println("isEmpty() returns "+book.isEmpty());
        System.out.println("The pile has "+book.size()+" books.");
        System.out.println();
        System.out.println("Get the top book and remove the top book: ");
        System.out.println();
        // The Da Vinci Code
        System.out.println(book.peek()+" is at the top of the pile.");
        System.out.println(book.pop()+" is removed from the pile.");
        System.out.println();
        // The Lord of the Rings
        System.out.println(book.peek()+" is at the top of the pile.");
        System.out.println(book.pop()+" is removed from the pile.");
        System.out.println();
        // The Hobbit
        System.out.println(book.peek()+" is at the top of the pile.");
        System.out.println(book.pop()+" is removed from the pile.");
        System.out.println();
        // Check again whether the pile is empty or not.
        System.out.println("The pile should be empty: ");
        System.out.println("isEmpty() returns "+book.isEmpty());
    }
}

interface StackInterface<E>{
    ArrayList list = new ArrayList<>();
    public int size();
    public E peek();
    public E pop();
    public void push(E o);
    public boolean isEmpty();
}

class GenericStack<E> implements StackInterface<E>{
    public GenericStack() {
        System.out.println("Create a new stack: an empty pile of books");
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public E peek() {
        return (E) list.get(size() - 1);
    }

    @Override
    public E pop() {
        E o = (E) list.get(size() - 1);
        list.remove(size() - 1 );
        return o;
    }

    @Override
    public void push(E o) {
        list.add(o);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString(){
        return list.toString();
    }
}