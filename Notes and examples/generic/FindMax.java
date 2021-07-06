
package generic;

public class FindMax {
    public static <E extends Comparable<E>> E max(E[] list){
        E max = list[0];
        for(int i=0;i<list.length;i++){
            if(list[i].compareTo(max)>0){
                max = list[i];
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        Integer[] number = {1,2,3};
        String[] colour = {"red","green","blue"};
        Double[] radius = {3.0,2.9,5.9};
        
        System.out.println(max(number));
        System.out.println(max(colour));
        System.out.println(max(radius));
    }
}

class Circle implements Comparable<Circle>{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public int compareTo(Circle o){
        if(this.radius>o.radius){
            return 1;
        }
        else if(this.radius<o.radius){
            return -1;
        }
        else{
            return 0;
        }
    }
    
    @Override
    public String toString(){
        return String.format("Circle: %.2f",radius);
    }
}