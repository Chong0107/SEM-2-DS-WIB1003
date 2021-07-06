import java.util.NoSuchElementException;
import java.util.Scanner;

public class PastYear2016S1Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyQueue<Character> lookUpQueue = new MyQueue<>();
        char[] alphabets = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','r','s','t','u','v','w','x','y','z','_'};
        for(char alp : alphabets){
            lookUpQueue.enqueue(alp);
        }
        System.out.println("Queue: "+lookUpQueue);
        System.out.print("Index: [");
        for(int i=0;i<lookUpQueue.getSize();i++){
            if(i != lookUpQueue.getSize() - 1){
                System.out.print(i+", ");
            }
            else {
                System.out.print(i);
            }
        }
        System.out.println("]");

        System.out.print("\nHow many times will you enter a number: ");
        int n = sc.nextInt();
        int[] indices = new int[n];
        System.out.println("(Please enter your number(s) between 0-26)");
        for (int i=0;i<n;i++){
            System.out.print("Enter number "+(i+1)+" >> ");
            indices[i] = sc.nextInt();
        }
        System.out.print("The entered numbers are [");
        for(int i=0;i<indices.length;i++){
            if (i != indices.length - 1) {
                System.out.print(indices[i]+", ");
            }
            else{
                System.out.print(indices[i]);
            }
        }
        System.out.println("]");

        System.out.print("The deciphered values are ");
        StringBuilder result = new StringBuilder();
        for(int index : indices){
            result.append(lookUpQueue.getElement(index));
        }

        if(result.isEmpty()){
            System.out.println("-Cannot decipher. No value was entered.-");
        }
        else {
            System.out.println(result);
        }
    }
}

class MyQueue<E>{
    public class NewNode<E>{
        E element;
        NewNode<E> next;

        public NewNode(E element) {
            this.element = element;
        }
    }

    private NewNode<E> head;
    private NewNode<E> tail;
    private int size;

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public MyQueue(E[] items){
        for (E item : items){
            enqueue(item);
        }
    }

    public MyQueue(){}

    public void enqueue(E e){
        if (isEmpty()){
            head = tail = new NewNode<>(e);
        }
        else {
            tail.next = new NewNode<>(e);
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

    public E getElement(int i){
        NewNode<E> current = head;
        for (int j=0;j<i;j++){
            current = current.next;
        }
        return current.element;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        NewNode<E> temp = head;
        while(temp != null){
            sb.append(temp.element);
            if(temp.next != null){
                sb.append(", ");
            }
            temp = temp.next;
        }
        System.out.println(sb.append("]").toString());
        return sb.toString();
    }
}
