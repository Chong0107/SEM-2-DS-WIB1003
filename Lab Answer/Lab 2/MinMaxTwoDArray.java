public class MinMaxTwoDArray <E extends Comparable<E>> implements Comparable<MinMaxTwoDArray<E>>{
    private E item;

    public MinMaxTwoDArray(E item) {
        this.item = item;
    }

    public MinMaxTwoDArray() {
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public static <E extends Comparable<E>> E min(E[][] list){
        MinMaxTwoDArray<E> min = new MinMaxTwoDArray<>(list[0][0]);
        for(int i=0;i< list.length;i++){
            for(int j=0;j< list[i].length;j++){
                MinMaxTwoDArray<E> temp = new MinMaxTwoDArray<>(list[i][j]);
                if(temp.compareTo(min)<0){
                    min = new MinMaxTwoDArray<>(list[i][j]);
                }
            }
        }
        return min.getItem();
    }

    public static <E extends Comparable<E>> E max(E[][] list){
        MinMaxTwoDArray<E> max = new MinMaxTwoDArray<>(list[0][0]);
        for(int i=0;i< list.length;i++){
            for(int j=0;j< list[i].length;j++){
                MinMaxTwoDArray<E> temp = new MinMaxTwoDArray<>(list[i][j]);
                if(temp.compareTo(max)>0){
                    max = new MinMaxTwoDArray<>(list[i][j]);
                }
            }
        }
        return max.getItem();
    }

    @Override
    public int compareTo(MinMaxTwoDArray<E> o) {
        return item.compareTo(o.getItem());
    }
}

class TesterQ6{
    public static void main(String[] args) {
        Integer[][] elements = {{4,5,6},{1,2,3}};
        MinMaxTwoDArray<Integer> obj = new MinMaxTwoDArray<>();
        System.out.println(obj.<Integer>min(elements));
        System.out.println(obj.<Integer>max(elements));
    }
}
