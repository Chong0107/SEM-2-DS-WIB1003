
package Queue;

import java.util.PriorityQueue;

public class PriorityQueue2 {
    public static void main(String... args) {
        PriorityQueueComparator pqc = new PriorityQueueComparator();
        PriorityQueue<String> pq = new PriorityQueue<String>(5, pqc);
        pq.add("Jason");
        pq.add("Ali");
        pq.add("Muhamad");
        for (String s : pq) {
            System.out.println(s);
        }
    }
}
