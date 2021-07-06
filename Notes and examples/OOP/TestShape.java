
package OOP;

public class TestShape {
    public static void main(String[] args) {
        System.out.println("-------------------Circle-------------------");
        Circles circle = new Circles(1.5,"Red",true);
        circle.printCircle();
        System.out.println("\n");
        
        System.out.println("-------------------Rectangle-------------------");
        Rectangle rectangle = new Rectangle(4.5,5.5);
        System.out.println("Width: "+rectangle.getWidth());
        System.out.println("Height: "+rectangle.getHeight());
        System.out.printf("Rectangle Area: %.2f",rectangle.getArea());
        System.out.printf("\nRectangle Perimeter: %.2f",rectangle.getPerimeter());
        System.out.println("");
    }
}
