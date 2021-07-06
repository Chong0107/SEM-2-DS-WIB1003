
package Stacks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class TestHTML {
    public static void main(String[] args) {
        String str = " ";
        try {
            Scanner sc = new Scanner(new FileInputStream("C:\\Users\\D.Chong\\Documents\\NetBeansProjects\\Generic\\src\\Stacks\\testing.html"));
            while(sc.hasNextLine()){
                str+=sc.nextLine();
            }
            sc.close();
            System.out.println(str);
            System.out.println(isHTMLMatched(str));
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        }
    }
    
    public static boolean isHTMLMatched(String html) {
        Stack<String> buffer = new Stack<>( );
        int j = html.indexOf('<'); // find first ’<’ character (if any)
        while (j != -1) {
            int k = html.indexOf('>', j+1); // find next ’>’ characterif (k == -1)
            if (k == -1)
                return false; // invalid tag
            String tag = html.substring(j+1, k); // strip away < >
            if (!tag.startsWith("/")) // this is an opening tag
                buffer.push(tag);
            else { // this is a closing tag
                if (buffer.isEmpty( ))
                    return false; // no tag to match
                if (!tag.substring(1).equals(buffer.pop( )))
                    return false; // mismatched tag
            }
            j = html.indexOf('<', k+1); // find next ’<’ character (if any)
        }
        return buffer.isEmpty( ); // were all opening tags matched?
    }
}
