public class PastYear2018S1Q3 {
    public static void main(String[] args) {
        /*
        StackWithGeneric<String> stack1 = new StackWithGeneric<String>(4);
        stack1.push("one");
        stack1.push("two");
        stack1.push("three");
        stack1.push("four");
        stack1.displayReverse();
        stack1.popAll();
        stack1.displayReverse();
         */

        StackWithGeneric<String> stack2 = new StackWithGeneric<>(4);
        stack2.push("one");
        stack2.push("two");
        stack2.push("three");
        stack2.push("four");
        System.out.println(stack2.peek());
        stack2.display();
        stack2.displayReverse();
        stack2.popAll();

        StackWithGeneric<Integer> stack3 = new StackWithGeneric<>(4);
        stack3.push(100);
        stack3.push(200);
        stack3.push(300);
        stack3.push(400);
        System.out.println(stack3.peek());
        stack3.display();
        stack3.displayReverse();
        stack3.popAll();
    }
}

class StackNode<E>{
    private E value;
    private StackNode<E> next;

    public StackNode(E value, StackNode<E> next) {
        this.value = value;
        this.next = next;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public StackNode<E> getNext() {
        return next;
    }

    public void setNext(StackNode<E> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}

class StackWithGeneric<E>{
    private StackNode<E> head;
    private int size;

    public StackWithGeneric(int size) {
        head = null;
        this.size = size;
    }

    public boolean isEmpty(){
        return head == null;
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
        System.out.println("Push item to stack: "+element);
        if(isEmpty()){
            head = new StackNode<>(element,null);
        }
        else {
            StackNode<E> current = head;
            while (current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(new StackNode<>(element,null));
        }
    }

    public E pop(){
        if(isEmpty()){
            return null;
        }
        else {
            StackNode<E> current = head.getNext();
            StackNode<E> previous = head;
            if(current == null){
                E temp = head.getValue();
                System.out.println("Removing "+temp+" ..");
                head = null;
                return temp;
            }
            while (current.getNext() != null){
                previous = current;
                current = current.getNext();
            }
            E temp = current.getValue();
            System.out.println("Removing "+temp+" ..");
            previous.setNext(null);
            return temp;
        }
    }

    public void popAll(){
        System.out.println("Pop all item in stack: ");
        while (!isEmpty()){
            pop();
        }
    }

    public void display(){
        System.out.println("Display stack: ");
        StackNode<E> current = head;
        for(int i=0; i<size;i++){
            System.out.println(current);
            if(current != null){
                current = current.getNext();
            }
        }
    }

    public void displayReverse(){
        System.out.println("Display stack in reverse: ");
        StackNode<E> current = head;
        StackNode[] arr = new StackNode[size];
        for (int i=0;i<size;i++){
            arr[i] = current;
            if (current != null){
                current = current.getNext();
            }
        }
        for (int i = size - 1;i>=0;i--){
            System.out.println(arr[i]);
        }
    }
}