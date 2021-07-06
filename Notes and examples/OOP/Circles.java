
package OOP;

public class Circles extends GeometricObject{
    private double radius;

    public Circles() {
    }

    public Circles(double radius) {
        this.radius = radius;
    }

    public Circles(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    public double getArea(){
        double area = Math.PI * Math.pow(2, radius);
        return area;
    }
    
    public double getPerimeter(){
        double perimeter = 2 * Math.PI * radius;
        return perimeter;
    }
    
    public double getDiameter(){
        double diameter = 2 * radius;
        return diameter;
    }
    
    public void printCircle(){
        System.out.println(toString());
        System.out.println("Radius: "+getRadius());
        System.out.printf("Circle Area: %.2f",getArea());
        System.out.printf("\nCircle Perimeter: %.2f",getPerimeter());
        System.out.printf("\nCircle Diameter: %.2f",getDiameter());
    }
}
