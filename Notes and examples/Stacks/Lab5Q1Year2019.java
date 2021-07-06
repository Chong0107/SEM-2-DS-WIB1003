
package Stacks;

import java.util.*;

public class Lab5Q1Year2019 {
    public static void main(String[] args) {
        //Q1
        GenericStack<String> container = new GenericStack<>();
        GenericStack<String> outside = new GenericStack<>();
        System.out.println("The candies in the container:");
        container.push("Orange");
        container.push("Red");
        container.push("Blue");
        container.push("Orange");
        container.push("Yellow");
        container.push("Yellow");
        container.push("Blue");
        container.display();
        System.out.println("\nAli takes all the candies one by one from the container and eats the blue ones.");
        while(!container.isEmpty()){
            if(container.peek().equals("Blue")){
                container.pop();
            }
            else{
                outside.push(container.pop());
            }
        }
        System.out.println("He puts back the rest of candies in the container.");
        while(!outside.isEmpty()){
            container.push(outside.pop());
        }
        System.out.println("The candies in the container: ");
        container.display();
        
        System.out.println();
        
       }
}

class StackNode<E>{
    private E element;
    private StackNode<E> next;

    public StackNode(E element, StackNode<E> next) {
        this.element = element;
        this.next = next;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public StackNode<E> getNext() {
        return next;
    }

    public void setNext(StackNode<E> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "<--"+element;
    }
}

class GenericStack<E>{
    private StackNode<E> head;

    public GenericStack() {
        head = null;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public int getSize(){
        int count = 0;
        StackNode<E> current = head;
        while(current != null){
            current = current.getNext();
            count++;
        }
        return count;
    }
    
    public void push(E element){
        head = new StackNode(element,head);
    }
    
    public E pop(){
        if(head == null){
            return null;
        }
        E temp = (E) head.getElement();
        head = head.getNext();
        return temp;
    }
    
    public E peek(){
        if(head == null){
            return null;
        }
        else{
            return (E) head.getElement();
        }
    }
    
    public void display(){
        if(isEmpty()){
            System.out.println("Empty Stack");
        }
        else{
            StackNode<E> current = head;
            while(current != null){
                System.out.print(current.toString());
                current = current.getNext();
            }
        }
    }
}

