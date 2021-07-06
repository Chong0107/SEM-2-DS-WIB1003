
package OOP;

// Create a class that represents a Polynomial. The class is able to compute any
// polynomial function. Create a Tester class to test the program, given output below.
// Example Polynomial a =new Polynomial(degree, coefficientInArray).
        
public class Polynomial {
    private int degree;
    private double[] coefficientInArray;

    public Polynomial(int degree, double[] coefficientInArray) {
        this.degree = degree;
        this.coefficientInArray = coefficientInArray;
    }
    
    public void compute(double x){
        System.out.println("when x = "+x);
        double answer = coefficientInArray[0] * Math.pow(x,coefficientInArray.length - 1);
        System.out.print(coefficientInArray[0]+"x^"+(coefficientInArray.length - 1)+" ");
        // assume the coefficient array is arrange from higher order to lower order
        for(int i=1;i<coefficientInArray.length;i++){
            int power = coefficientInArray.length - i - 1;
            
            if(coefficientInArray[i]>0)
                System.out.print("+");
            System.out.print(coefficientInArray[i]);
            
            if(power>0){
                System.out.print("x");
                if(power>1){
                    System.out.print("^"+power);
                }
                System.out.print(" ");
                answer += coefficientInArray[i] * Math.pow(x,coefficientInArray.length - i - 1);
            }
        }
        System.out.println("= "+answer);
    }
}

class testPolynomial{
    public static void main(String[] args) {
        double [] coefficient = {4.0,2.0,-0.5,-20.0};
        Polynomial eq = new Polynomial(3,coefficient);
        eq.compute(2.0);
        eq.compute(-3.5);
        System.out.println();
    }
}