public class PastYear2016S2Q3 {
    public static void main(String[] args) {
        Queue<Integer> number = new Queue<>();
        for(int i=1;i<10;i++){
            number.enqueue(i * 10);
        }
        System.out.println(number.toString());
        number.ChangeOrder(4);
        System.out.println(number.toString());
        System.out.println("Is the queue are empty ? "+number.isEmpty());
    }
}

class Queue<Item>{
    private java.util.LinkedList<Item> list = new java.util.LinkedList<>();

    public Queue() {
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public int size(){
        return list.size();
    }

    public Item peek(){
        return list.getFirst();
    }

    public void enqueue(Item item){
        list.addLast(item);
    }

    public Item dequeue(){
        return list.removeFirst();
    }

    @Override
    public String toString(){
        return list.toString();
    }

    public void ChangeOrder(int k){
        if(k > size() - 1)
            return;
        for(int i=0;i<k-1;i++){
            enqueue(dequeue());
        }
    }
}