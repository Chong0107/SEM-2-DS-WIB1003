import java.util.Scanner;

/**
 *
 * @author U2005284 Chong Jun Yi
 */
public class LabTest3Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<4;i++){
            String code = sc.next();
            while(!checkValid(code)){
                code = sc.next();
            }
        }

    }

    // To check whether the syntax is true or not
    public static boolean checkValid(String code){
        int count = 0;
        if(code.length()>0){
            for (int i = 0; i < code.length(); i++) {
                if(code.charAt(i)=='*'){
                    count++;
                }
                if(count==2 && i == code.length()-1){
                    System.out.print("——> correct");
                    return true;
                }
                else if(count==2 && i != code.length()-1){
                    return checkValid(code.substring(i+1));
                }
            }
        }
        System.out.print("——> Please put the digits between two stars");
        return false;
    }
}
