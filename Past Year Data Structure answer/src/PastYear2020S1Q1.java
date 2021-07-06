public class PastYear2020S1Q1 {
    public static void main(String[] args) {
        StackWithGenerics<String> stack1 = new StackWithGenerics<>(7);
        stack1.push("apple");
        stack1.display();
        stack1.pushMany("broccoli,chicken sandwich,donut,french fries,juice,maruku");
        stack1.display();
        System.out.println("Pop the top of the stack: "+stack1.pop());
        System.out.println("Pop the top of the stack: "+stack1.pop());
        stack1.display();
        System.out.println();
        System.out.println("Pop middle of the stack: "+stack1.popMiddle());
        stack1.display();
        System.out.println();
        System.out.println("Pop middle of the stack: "+stack1.popMiddle());
        stack1.display();
        System.out.println("-------------------------------------------------");
        StackWithGenerics<Integer> stack2 = new StackWithGenerics<>(10);
        stack2.push(1);
        stack2.push(2);
        stack2.pushMany("3 4,5,6 7");
        stack2.display();
        stack2.popAll();
        stack2.display();
    }
}

class StackWithGenerics<E>{
    private StackNode<E> head;
    private int maxSize;
    private int size;

    public StackWithGenerics(int maxSize) {
        head = null;
        this.maxSize = maxSize;
        size = 0;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public boolean isFull(){
        return size >= maxSize;
    }

    public E peek(){
        if(isEmpty()){
            return null;
        }
        else {
            StackNode<E> current = head;
            while (current.getNext() != null){
                current = current.getNext();
            }
            return current.getValue();
        }
    }

    public void push(E element){
        if (isEmpty()){
            size++;
            System.out.println("Push: "+element);
            head = new StackNode<>(element,null);
        }
        else if(isFull()){
            System.out.println("Stack is full.");
        }
        else{
            size++;
            System.out.println("Push: "+element);
            StackNode<E> current = head;
            while (current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(new StackNode<>(element,null));
        }
    }

    public void pushMany(String element){
        System.out.println("Push many into stack...");
        E[] manyElements = (E[]) element.split(",");
        for (E manyElement : manyElements){
            push(manyElement);
        }
    }

    public E pop(){
        if(isEmpty()){
            return null;
        }
        else {
            size--;
            StackNode<E> current = head.getNext();
            StackNode<E> previous = head;
            if(current == null){
                E temp = head.getValue();
                head = null;
                return temp;
            }
            while (current.getNext() != null){
                previous = current;
                current = current.getNext();
            }
            E temp = current.getValue();
            previous.setNext(null);
            return temp;
        }
    }

    public E popMiddle(){
        int middle;
        if(size % 2 == 0){
            System.out.println("Current count of stack is even number, so no middle index.");
            return null;
        }
        else {
            middle = size / 2;
        }
        StackNode<E> current = head;
        for (int i = 0; i < middle - 1 ; i++) {
            current = current.getNext();
        }
        StackNode<E> temp = current.getNext();
        current.setNext(temp.getNext());
        size--;
        return temp.getValue();
    }

    public void popAll(){
        System.out.println("\nThere are "+size+" items in the stack. Pop all...");
        while (!isEmpty()){
            System.out.println("Removing "+pop()+"...");
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("\nStack is empty, nothing to display.....");
        }
        System.out.println("\nThere are " + size + " items in the stack. Displaying...");
        StackNode<E> current = head;
        int i=0;
        StackNode[] arr = new StackNode[size];
        while (current != null){
            arr[i] = current;
            i++;
            current = current.getNext();
        }
        for (int j=size - 1;j>=0;j--){
            System.out.println(arr[j]);
        }
        System.out.println();
    }
}