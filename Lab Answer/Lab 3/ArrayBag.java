import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayBag<T> implements BagInterface<T>{
    private T[] bag;
    private int DEFAULT_CAPACITY = 25;
    private int numberOfEntries;

    public ArrayBag() {
        this.bag = (T[]) new Object[this.DEFAULT_CAPACITY];
    }

    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean add(T newEntry) {
        if(numberOfEntries < bag.length){
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
            return true;
        }
        return false;
    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public boolean remove(T anEntry) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int count = 0;
        for(T i : bag){
            if(anEntry == i){
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean contains(T anEntry) {
        return false;
    }

    @Override
    public T[] toArray() {
        return bag;
    }

    @Override
    public BagInterface<T> union(BagInterface<T> bag2) {
        List<T> list = new ArrayList<>(Arrays.asList(bag));
        T[] item = bag2.toArray();
        int size = numberOfEntries;
        for (int i=0;i<item.length;i++){
            if(item[i] != null){
                list.set(size,item[i]);
                size++;
            }
        }
        BagInterface<T> everything = new ArrayBag<>();
        for(int i=0;i< list.size();i++){
            if(list.get(i) == null){
                break;
            }
            everything.add(list.get(i));
        }
        return everything;
    }

    @Override
    public BagInterface<T> intersection(BagInterface<T> item) {
        List<T> list = new ArrayList<>();
        T [] bag2 = item.toArray();
        for(int i=0;i< bag2.length;i++){
            int bag1Frequency = this.getFrequencyOf(bag2[i]);
            int bag2Frequency = item.getFrequencyOf(bag2[i]);
            int frequency = bag1Frequency > bag2Frequency ? bag2Frequency : bag1Frequency;
            int frequencyCounter = 0;
            boolean already = list.contains(bag2[i]);
            if(bag2[i] == null){
                break;
            }
            if(frequency > 0 && !already){
                while(frequencyCounter < frequency){
                    list.add(bag2[i]);
                    frequencyCounter++;
                }
            }
        }
        BagInterface<T> commonItems = new ArrayBag<>();
        for(int i=0;i<list.size();i++){
            commonItems.add(bag2[i]);
        }
        return commonItems;
    }

    @Override
    public BagInterface<T> difference(BagInterface<T> item) {
        List<T> list = new ArrayList<>();
        for(int i=0;i< bag.length;i++) {
            int bag1Frequency = this.getFrequencyOf(bag[i]);
            int bag2Frequency = item.getFrequencyOf(bag[i]);
            boolean afterMinusLeftObject = bag1Frequency - bag2Frequency > 0;
            int frequencyCounter = 0;
            boolean already = list.contains(bag[i]);
            if (bag[i] == null) {
                break;
            }
            if (afterMinusLeftObject && !already) {
                int frequency = bag1Frequency - bag2Frequency;
                while (frequencyCounter < frequency) {
                    list.add(bag[i]);
                    frequencyCounter++;
                }
            }
        }
        BagInterface<T> leftOver = new ArrayBag<>();
        for(int i=0;i< list.size();i++){
            leftOver.add(list.get(i));
        }
        return leftOver;
    }
}
