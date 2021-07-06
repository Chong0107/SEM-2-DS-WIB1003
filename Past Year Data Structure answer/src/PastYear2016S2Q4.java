public class PastYear2016S2Q4 {
    public static void main(String[] args) {
    LinkedList s1 = new LinkedList();
    s1.add(10);
    s1.add(20);
    s1.add(30);
    s1.add(40);
    s1.add(50);
    s1.addAfter(11,10);
    s1.addAfter(21,20);
    s1.addAfter(31,30);
    s1.addAfter(41,40);
    s1.addAfter(51,50);
    s1.traverse();
    s1.deleteFront();
    s1.deleteFront();
    s1.traverse();
    s1.deleteAfter(40);
    s1.deleteAfter(40);
    s1.deleteAfter(31);
    s1.deleteAfter(40);
    s1.traverse();
    }
}

class Node<E extends Comparable<E>>{
    private E value;
    private Node next;

    public Node(E value, Node next) {
        this.value = value;
        this.next = next;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return value+" ";
    }
}

class LinkedList<E extends Comparable<E>>{
    private Node<E> head;

    public LinkedList() {
        head = null;
    }

    public void add(E element){
        System.out.println("Adding: "+element);
        if(head == null){
            head = new Node<>(element,null);
        }
        else {
            Node<E> current = head;
            while(current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(new Node(element,null));
        }
    }

    public boolean addAfter(E newElement,E element){
        System.out.println("Adding "+newElement+" after "+element);
        Node<E> current = head;
        while (current != null){
            if(current.getValue() == element){
                Node<E> temp = current.getNext();
                current.setNext(new Node(newElement,temp));
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public boolean deleteFront(){
        if(head == null){
            System.out.println("\nThe list is empty, no element to be deleted.");
            return false;
        }
        else {
            System.out.println("\nDeleting front: "+head);
            head = head.getNext();
            return true;
        }
    }

    public boolean deleteAfter(E element){
        System.out.println("\nTesting deleteAfter: ");
        Node<E> current = head;
        while (current != null){
            if(current.getValue() == element){
                Node<E> temp = current.getNext();
                if(temp == null){
                    System.out.println("After "+element+" is "+temp+".");
                }
                else {
                    System.out.println("After "+element+" is "+temp+". Deleting "+temp);
                }
                current.setNext(current.getNext().getNext());
                return true;
            }
            current = current.getNext();
        }
        System.out.println("Element ("+element+") not found......");
        return false;
    }

    public void traverse(){
        System.out.println("\nShowing content of my linked list:");
        Node<E> temp = head;
        while (temp != null){
            System.out.print(temp+" ");
            temp = temp.getNext();
        }
        System.out.println("\n");
    }
}