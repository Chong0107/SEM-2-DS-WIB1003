public class PastYear2019S1Q1 {
    public static void main(String[] args) {
        GenericsStack<String> stack1 = new GenericsStack<>(5);
        stack1.push("one");
        stack1.display();
        stack1.pushMany("two,three four,five,six seven");
        stack1.display();
        stack1.pop();
        stack1.pop();
        stack1.display();
        System.out.println("-------------------------------------");
        GenericsStack<Integer> stack2 = new GenericsStack<>(5);
        stack2.push(1);
        stack2.push(2);
        stack2.pushMany("3 4,5,6 7");
        stack2.display();
        stack2.popAll();
        stack2.display();
    }
}


class GenericsStack<E>{
    private StackNode<E> head;
    private int maxSize;
    private int size;

    public GenericsStack(int maxSize) {
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
        else {
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
        E[] manyElements = (E[]) element.split(",");
        for (E manyElement : manyElements){
            push(manyElement);
        }
    }

    public E pop(){
        if (isEmpty()){
            return null;
        }
        else {
            size--;
            StackNode<E> current = head.getNext();
            StackNode<E> previous = head;
            if(current == null){
                E temp = head.getValue();
                System.out.println("Pop the top of stack....");
                head = null;
                return temp;
            }
            while (current.getNext() != null){
                previous = current;
                current = current.getNext();
            }
            E temp = current.getValue();
            System.out.println("Pop the top of stack....");
            previous.setNext(null);
            return temp;
        }
    }

    public void popAll(){
        System.out.println("\nThere are "+size+" items in the stack. Removing...");
        while (!isEmpty()){
            System.out.println("Removing "+pop()+"...");
        }
    }

    public void display(){
        if (isEmpty()){
            System.out.println("\nStack is empty, nothing to display.....");
        }
        System.out.println("\nThere are "+size+" items in the stack. Displaying...");
        // print reverse
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
        // print originally
        /*
        StackNode<E> current = head;
        for(int i=0; i<size;i++){
            System.out.println(current);
            if(current != null){
                current = current.getNext();
            }
        }
        */
    }
}
