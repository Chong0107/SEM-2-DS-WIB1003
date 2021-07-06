
package Queue;

import java.util.*;


public class Customer implements Comparable<Customer>{
    private Integer id;
    private String name;

    public Customer(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Customer c){
        return this.getId().compareTo(c.getId());
    }
    
    @Override
    public String toString() {
        String str = "Customer [ id = "+id+", name = "+name+" ]";
        return str;
    }
}

class PriorityQueueDemo2{
    public static void main(String[] args) {
        PriorityQueue<Customer> customerQueue = new PriorityQueue<>(Collections.reverseOrder());
        customerQueue.add(new Customer(3,"Donald"));
        customerQueue.add(new Customer(1,"Chong"));
        customerQueue.add(new Customer(2,"Ali"));
        customerQueue.add(new Customer(4,"Bala"));
        
        Customer c = customerQueue.peek();
        if(c != null){
            System.out.println(c.getName()+" is in queue.");
            while((c = customerQueue.poll())!= null){
                System.out.println(c);
            }
        }
        System.out.println();
    }
}
