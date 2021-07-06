public class Circle extends Shape{
    private double diameter;

    public Circle(double diameter) {
        this.diameter = diameter;
    }

    public Circle(String name, double diameter) {
        super(name);
        this.diameter = diameter;
    }

    public void acceptDiameter(double diameter){
        this.diameter = diameter;
    }

    public void computePerimeter(){
        this.perimeter = Math.PI * diameter;
    }

    public void computeArea(){
        this.area = Math.PI * Math.pow((diameter/2),2);
    }
}
