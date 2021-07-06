package FinalExamDS2021;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q4 {
    public static void main(String[] args) {
        Comparator<Passenger> routeComparator = new Comparator<Passenger>() {
            @Override
            public int compare(Passenger o1, Passenger o2) {
                if(o1.getRoute() == o2.getRoute())
                    return 0;
                else if(o1.getRoute() > o2.getRoute())
                    return 1;
                else
                    return -1;
            }
        };
        PriorityQueue<Passenger> passengerQueue = new  PriorityQueue<>(routeComparator);
        passengerQueue.add(new Passenger("Susan","Road 0.9"));
        passengerQueue.add(new Passenger("Jack","Road 5.5"));
        passengerQueue.add(new Passenger("Benjamin","Road 1.6"));
        passengerQueue.add(new Passenger("Rachel","Road 3.8"));
        passengerQueue.add(new Passenger("Samuel","Road 4.1"));
        passengerQueue.add(new Passenger("Kenneth","Road 2.6"));

        System.out.println("Passenger Drop-off List");
        String[] busStop = {"A","B","C","D","E","F"};

        for (int i=0;i< busStop.length;i++){
            while (!passengerQueue.isEmpty()){
                Passenger current = passengerQueue.peek();
                if (current.getRoute() - (1.2 + i) <= 0.5){
                    System.out.println("Stop "+busStop[i]+":"+current.getName());
                    passengerQueue.remove();
                    continue;
                }
                break;
            }
        }
    }
}
