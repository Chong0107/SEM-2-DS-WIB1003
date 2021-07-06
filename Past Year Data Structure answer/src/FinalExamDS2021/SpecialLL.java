package FinalExamDS2021;

import java.util.ArrayList;

public class SpecialLL<E> {
    Node<E> head, tail;
    int size = 0;
     
    public SpecialLL() {}  
      
    public int getSize() {
        return size;
    }

    public void addFirst(E e) {
      Node<E> newNode = new Node<E>(e); 
      newNode.next = head; 
      head = newNode; 
      size++; 
      if (tail == null) 
        tail = head;
    }
    
    public void addLast(E e) {
      Node<E> newNode = new Node<E>(e); 
      if (tail == null) {
        head = tail = newNode; 
      }
      else {
        tail.next = newNode; 
        tail = tail.next; 
      }
      size++; 
    }

    public void print() {
        Node<E> current = head;
        for(int i=0; i<size; i++) {
            System.out.print(current.element + " ");   
             current=current.next;
        }
        System.out.println();
    }

    public void printOdd(){
        Node<E> current = head;
        int i = 1;
        while(current!=null){
            if(i % 2 == 1){
                System.out.print(current.element+" ");
            }
            current = current.next;
            i++;
        }
        System.out.println("");
    }

    public ArrayList<E> getEven(){
        ArrayList<E> temp = new ArrayList();
        Node<E> current = head;
        int i = 1;
        while(current!=null){
            if(i % 2 == 0){
                temp.add(0, current.element);
            }
            current = current.next;
            i++;
        }
        return temp;
    }
}
