
package generic;

public class MyArray {
    public static void main(String[] args) {
        Integer[] numbers = {1,2,3,4,5};
        String[] names = {"Jane","Tom","Bob"};
        Character[] alphabet = {'a','b','c'};
        
        MyArray.<Integer>print(numbers);
        MyArray.<String>print(names);
        MyArray.<Character>print(alphabet);
    }
    
    public static <E> void print (E[] list){
        for(int i=0;i<list.length;i++){
            System.out.print(list[i]+" ");
        }
        System.out.println();
    }
}
