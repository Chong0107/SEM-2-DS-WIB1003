public class Recursion {

    public static void main(String[] args) {
        System.out.println(substitution("assistant"));
        permuteString("ABC");
        System.out.println(exponent(10, 3));
    }

    //Q1
    public static String substitution(String str) {
//        if (str.length() == 0) {
//            return "";
//
//        } else {
//            String temp = str.charAt(str.length() - 1) == 'a' ? "i" : str.charAt(str.length() - 1) + "";
//            return substitution(str.substring(0, str.length() - 1)) + temp;
//        }
        if( str.length() == 0){
            return str;
        }
        else if(str.charAt(0) == 'a'){
            return 'i'+substitution(str.substring(1));
        }
        else {
            return str.charAt(0)+substitution(str.substring(1));
        }
    }

    //Q2
    public static void permuteString(String str) {
        String prefix = "";

        for (int i = 0; i < str.length(); i++) {    //0,1,2,3 parameter
            permute(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, str.length()));
        }
    }
    // "" + A    ,    "BC"     0
    // "" + B    ,    "AC"     1
    // "" + C    ,    "AB"     2

    public static void permute(String prefix, String str) {
        //Display
        if (str.length() == 0) {
            System.out.println(prefix);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            permute(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, str.length()));
        }
        //*Trace the first output*

        //Prefix    ,   str
        //A + B     ,   C
        //AB + C    ,   ""
        //str.length()==0, so display "ABC"
    }

    //Q3
    public static long exponent(int x, int m) {
        if (m == 0) {
            return 1;
        }
        if (m == 1){
            return x;
        }

        return x * exponent(x, --m);
    }
}
