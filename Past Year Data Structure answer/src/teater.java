import java.util.Stack;

public class teater {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        Integer[] x = {4,5,6,2,9,5,1,4,1,3};
        for (int i=0;i<x.length;i++)
            st.push(x[i]);
        for (int j=0;j<3;j++)
            System.out.print(st.pop());
        System.out.println();
        System.out.println(st.peek());
        for(int k=0;k<3;k++){
            st.pop();
        }
        System.out.println(st.pop());
    }
}
