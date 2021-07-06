import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class MyQueue<E>{
    /*
    public class Node<E>{
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }

    private Node<E> head;
    private Node<E> tail;

    public MyQueue() {
        head = null;
        tail = null;
    }

    public MyQueue(E[] e){
        for(int i=0;i<e.length;i++){
            enqueue(e[i]);
        }
    }

    public void enqueue(E e){
        Node<E> newNode = new Node<>(e);
        if(head == null){
            head = tail = newNode;
        }
        else{
            Node<E> temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public E dequeue(){
        if(head == null){
            System.out.println("The Empty Queue cannot be dequeue.");
            return null;
        }
        else{
            E firstNode = head.element;
            head = head.next;
            return firstNode;
        }
    }

    public E getElement(int i){
        if(head == null){
            System.out.println("The Queue is empty");
            return null;
        }
        else {
            int count = 0;
            Node<E> temp = head;
            while (temp != null){
                if(count == i){
                    return temp.element;
                }
                count++;
                temp = temp.next;
            }
        }
        return null;
    }

    public E peek(){
        if(head == null){
            System.out.println("The queue is empty.");
            return null;
        }
        else {
            return head.element;
        }
    }

    public int getSize(){
        if(head == null){
            System.out.println("The queue is empty.");
            return 0;
        }
        else {
            Node<E> temp = head;
            int count = 0;
            while (temp != null){
                temp = temp.next;
                count++;
            }
            return count;
        }
    }

    public boolean contains(E e){
        if(head == null){
            System.out.println("The queue is empty.");
            return false;
        }
        else {
            Node<E> temp = head;
            while (temp != null){
                if(temp.element == e){
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }

    public boolean isEmpty(){
        if(head == null){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        if (head == null){
            return "[]";
        }
        else {
            StringBuilder sb = new StringBuilder("[");
            Node<E> temp = head;
            while (temp != null){
                sb.append(temp.element);
                if(temp.next != null){
                    sb.append(", ");
                }
                temp = temp.next;
            }
            return sb.append("]").toString();
        }
    }
    */
    private LinkedList<E> a;

    public MyQueue(E[] e){
        a = new LinkedList<>(Arrays.asList(e));
    }

    public MyQueue(){
        a = new LinkedList<>();
    }

    public void enqueue(E e){
        a.addLast(e);
    }

    public E dequeue(){
       E firstNode = a.getFirst();
       a.removeFirst();
       return firstNode;
    }

    public E getElement(int i){
        return a.get(i);
    }

    public E peek(){
        return a.getFirst();
    }

    public int getSize(){
        return a.size();
    }

    public boolean contains(E e){
        return a.contains(e);
    }

    public boolean isEmpty(){
        return a.isEmpty();
    }

    @Override
    public String toString() {
        return a.toString();
    }
}

class Q1Tester{
    public static void main(String[] args) {
        String[] a = {"Durian","Blueberry"};
        MyQueue<String> fruitQ = new MyQueue<>(a);
        fruitQ.enqueue("Apple");
        fruitQ.enqueue("Orange");
        fruitQ.enqueue("Grapes");
        fruitQ.enqueue("Cherry");
        System.out.println(fruitQ.toString());
        System.out.println("The top item is "+fruitQ.peek());
        System.out.println("The size is "+fruitQ.getSize());
        System.out.println("Deleting "+fruitQ.dequeue());
        System.out.println("The item in index position of 2 is "+fruitQ.getElement(2));
        System.out.println("Is 'Cherry' in the queue ? "+fruitQ.contains("Cherry"));
        System.out.println("IS 'Durian' in the queue ? "+fruitQ.contains("Durian"));
        while (fruitQ.isEmpty()){
            System.out.println(fruitQ.dequeue());
        }
    }
}

/*
class Palindrome{
    public static void main(String[] args) {
        MyQueue<Character> character = new MyQueue<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.next();
        for(int i = str.length() - 1; i>=0; i--){
            character.enqueue(str.charAt(i));
        }
        boolean reversed = false;
        for(int i=0;i<str.length();i++){
            reversed = character.dequeue() == str.charAt(i);
        }
        if(reversed){
            System.out.println(str+" is a palindrome.");
        }
        else {
            System.out.println(str+" is not a palindrome.");
        }
    }
}
*/
/*
class Shares{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyQueue<Integer> Share = new MyQueue<>();
        MyQueue<Integer> Price = new MyQueue<>();
        int total = 0;
        // infinite loop
        for(;;){
            System.out.println("Enter your query (In format 'Buy / Sell x shares at $y each'): ");
            String input = sc.nextLine();

            if (input == " ") {
                break;
            }
            // buy
            if(input.charAt(0) == 'B'){
                // get x and y
                String temp[] = input.split(" ");
                Share.enqueue(Integer.valueOf(temp[1]));
                String priceTemp = temp[4].substring(1);
                Price.enqueue(Integer.valueOf(priceTemp));

                System.out.println("Buying now......");
                System.out.println("Queue for Share: "+Share.toString());
                System.out.println("Queue for Price: "+Price.toString());
            }

            int gain = 0;
            int loss = 0;
            // sell
            if(input.charAt(0) == 'S'){
                // get x and y
                String temp[] = input.split(" ");
                int shareSell = Integer.valueOf(temp[1]);
                String priceTemp = temp[4].substring(1);
                int priceSell = Integer.valueOf(priceTemp);

                gain = shareSell * priceSell;
                // sell less than possess
                if(shareSell < Share.peek()){
                    loss =  shareSell * Price.peek();
                    // Enqueue back the (share left)
                    Share.enqueue(Share.dequeue() - shareSell);
                }
                // sell equal possess
                else if(shareSell == Share.peek()){
                    loss = Share.dequeue() * Price.dequeue();
                }
                // sell bigger than possess
                // borrow from next queue
                else if(shareSell > Share.peek()){
                    // ady last one
                    // cannot borrow
                    if(Share.getSize() == 1){
                        gain = Share.peek() * priceSell;
                        loss += Share.dequeue() * Price.dequeue();
                        total += (gain - loss);
                        System.out.println("Selling the shares now...");
                        System.out.println("Total Capital Gain / Loss: "+total);
                        System.out.println("No shares to sell!");
                        System.out.println("Queue for Share: "+Share.toString());
                        System.out.println("Queue for Price: "+Price.toString());
                        continue; // skip
                    }

                    // not sure how many queues have to borrow
                    // thus, borrow until enough
                    while (shareSell > Share.peek()){
                        shareSell -= Share.peek();
                        loss += Share.dequeue() * Price.dequeue();
                    }

                    // after enough on borrow
                    // check the share left whether is smaller or equal
                    if(shareSell < Share.peek()){
                        loss += shareSell * Price.peek();
                        Share.enqueue(Share.dequeue() - shareSell);
                    }
                    else if(shareSell == Share.peek()){
                        loss += Share.dequeue() * Price.dequeue();
                    }
                }
                total += (gain - loss);

                System.out.println("Selling the shares now...");
                System.out.println("Total Capital Gain / Loss: "+total);
                System.out.println("No shares to sell!");
                System.out.println("Queue for Share: "+Share.toString());
                System.out.println("Queue for Price: "+Price.toString());
            }
        }
        System.out.println("Final Capital Gain / Loss: "+total);
    }
 */

