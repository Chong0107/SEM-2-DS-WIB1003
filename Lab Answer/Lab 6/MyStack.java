import java.util.*;

public class MyStack<E> {
    private java.util.ArrayList<E> list = new java.util.ArrayList<>();

    public int getSize(){
        return list.size();
    }

    public void push(E o){
        list.add(o);
    }

    public E peek(){
        E o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }

    public E pop(){
        return list.remove(getSize() - 1);
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public boolean search(E o){
        return list.contains(o);
    }

    @Override
    public String toString() {
        return "stack: "+list.toString();
    }
}

class TestMyStack{
    public static void main(String[] args) {
        MyStack<Character> myStack = new MyStack<>();
        myStack.push('a');
        //System.out.println("(1) "+myStack);
        myStack.push('b');
        //System.out.println("(2) "+myStack);
        myStack.push('c');
        //System.out.println("(3) "+myStack);
        System.out.println(myStack.toString());
        System.out.println("Is element 'b' is in the list of the stack ? "+myStack.search('b'));
        System.out.println("Is element 'k' is in the list of the stack ? "+myStack.search('k'));
        System.out.println();
        MyStack<Integer> number = new MyStack<>();
        number.push(1);
        number.push(2);
        number.push(3);
        System.out.println(number.toString());
        System.out.println("Is number 6 in the list of the stack ? "+number.search(6));
    }
}

/*
class TestIntMyStack{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter integers ('-1' to stop): ");
        MyStack<Integer> integer = new MyStack<>();
        int input;
        int sum = 0;
        input = sc.nextInt();
        while(input != -1){
            integer.push(input);
            input = sc.nextInt();
            //sum += input;
        }
        System.out.println("Size of stack: "+integer.getSize());
        //System.out.println("Sum: "+sum);
        System.out.println("Contents of stacks: ");
        while (!integer.isEmpty()){
            System.out.print(integer.pop()+" ");
        }
    }
}
*/
/*
class Q4{
    public static void main(String[] args) {
        MyStack<Character> stack = new MyStack<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.next();
        String reversedStr = "";
        for (int i=0;i<str.length();i++){
            stack.push(str.charAt(i));
        }

        for (int i=0;i<str.length();i++){
            reversedStr += stack.pop();
        }

        if(str.equals(reversedStr)){
            System.out.println(str+" is palindrome.");
        }
        else {
            System.out.println(str+" is not palindrome.");
        }
    }
}
*/
/*
class TowerOfHanoi{
    // Creating stack array
    private static Stack<Integer> [] tower = new Stack[4];
    private static int N;

    public static void main(String[] args) {
        tower[1] = new Stack<Integer>();
        tower[2] = new Stack<Integer>();
        tower[3] = new Stack<Integer>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        N = sc.nextInt();
        System.out.println();
        initialize(N);
    }

    // Function to push disks into stack
    public static void initialize(int n){
        for(int i=n;i>0;i--){
            tower[1].push(i);
        }
        display();
        move(n,1,2,3);
    }

    // Recursive Function to move disks
    public static void move(int n,int a,int b,int c){
        if (n > 0) {
            move(n-1,a,c,b);
            int d = tower[a].pop();
            tower[c].push(d);
            display();
            move(n-1,b,a,c);
        }
    }

    //Function to display
    public static void display(){
        System.out.println("  A  |  B  |  C");
        System.out.println("------------------");
        for (int i=N-1;i>=0;i--){
            String d1 = " ",d2 = " ",d3 = " ";
            try{
                d1 = String.valueOf(tower[1].get(i));
            }
            catch (Exception e){
            }
            try {
                d2 = String.valueOf(tower[2].get(i));
            }
            catch (Exception e){
            }
            try {
                d3 = String.valueOf(tower[3].get(i));
            }
            catch (Exception e){
            }
            System.out.println("  "+d1+"  |  "+d2+"  |  "+d3);
        }
        System.out.println("\n");
    }
}
*/


