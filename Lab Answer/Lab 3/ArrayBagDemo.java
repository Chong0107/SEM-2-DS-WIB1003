public class ArrayBagDemo <T>{
    private static void testAdd(BagInterface<String> aBag, String[] content){
        System.out.println("Adding");
        for(String i : content){
            aBag.add(i);
            System.out.print(i+" ");
        }
        System.out.println();
    }
    private static <T> void displayBag(BagInterface<String> aBag){
        System.out.println("The bag contains "+aBag.getCurrentSize()+" string(s), as follows: ");
        T[]array = (T[]) aBag.toArray();
        for(T i : array){
            if(i == null){
                break;
            }
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[] contentsOfBag1 = {"A", "A", "B", "A", "C", "A"};
        String[] contentsOfBag2 = {"A", "B", "A", "C", "B", "C", "D", "another string"};
        BagInterface<String> bag1 = new ArrayBag<>();
        BagInterface<String> bag2 = new ArrayBag<>();
        System.out.println("bag1: ");
        ArrayBagDemo.testAdd(bag1,contentsOfBag1);
        displayBag(bag1);
        System.out.println();
        System.out.println("bag2: ");
        ArrayBagDemo.testAdd(bag2,contentsOfBag2);
        displayBag(bag2);
        System.out.println();
        System.out.println("bad3, test the method union of bag1 and bag2:");
        BagInterface<String> everything = bag1.union(bag2);
        displayBag(everything);
        System.out.println();
        System.out.println("bag4, test the method intersection of bag1 and bag2:");
        BagInterface<String> commonItems = bag1.intersection(bag2);
        displayBag(commonItems);
        System.out.println();
        System.out.println("bag5, test the method difference of bag1 and bag2:");
        BagInterface<String> leftOver = bag1.difference(bag2);
        displayBag(leftOver);
    }
}
