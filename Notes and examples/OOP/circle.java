
package OOP;
// Example 1
// A class called circle is designed as shown in the following class diagram. It contains:
// * One private instance variables: 
// radius (of the type double) with default value of 1.0 
// * Two overloaded constructors :
// a default constructor with no argument, and a constructor which takes a double argument for radius.
// * Two public methods: 
// getRadius() and getArea(), which return the radius and area of this instance, respectively.

public class circle {
    private double radius;

    public circle() {
        radius = 1.0;
    }

    public circle(double radius) {
        this.radius = radius;
    }
    
    public double getRadius() {
        return radius;
    }
    
    public double getArea(){
        double area = Math.PI * (Math.pow(2,radius));
        return area;
    }
}

class testCircle{
    public static void main(String[] args) {
        // non argument constructor
        circle c1 = new circle();
        System.out.println("The radius of the circle is "+c1.getRadius()+" cm.");
        System.out.print("The area of the circle with the radius value of "+c1.getRadius()+" cm is ");
        System.out.printf("%.2f",c1.getArea());
        System.out.print(" cm^2.");
        // constructor which takes a double argument for radius
        circle c2 = new circle(2.0);
        System.out.println("\nThe radius of the circle is "+c2.getRadius()+" cm.");
        System.out.print("The area of the circle with the radius value of "+c2.getRadius()+" cm is ");
        System.out.printf("%.2f",c2.getArea());
        System.out.print(" cm^2.");
        System.out.println();
    }
}
