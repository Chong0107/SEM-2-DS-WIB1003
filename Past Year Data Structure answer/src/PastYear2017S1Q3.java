import java.util.Scanner;

public class PastYear2017S1Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Say input: ");
        String word = sc.next();
        stack reverse = new stack();
        for(int i=0; i<word.length();i++){
            reverse.push(word.charAt(i));
        }
        System.out.print("Thus, the output: ");
        while (!reverse.isStackEmpty()){
            System.out.print(reverse.pop());
        }
        System.out.println(" ");
    }
}
class stack<Character>{
    private java.util.ArrayList<Character> list = new java.util.ArrayList<>();

    public int getSize(){
        return list.size();
    }

    public void push(Character o){
        list.add(o);
    }

    public Character peek(){
        return list.get(getSize() - 1);
    }

    public Character pop(){
        Character o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }

    public boolean isStackEmpty(){
        return list.isEmpty();
    }

    public boolean isStackFull(){
        return false;
    }

    @Override
    public String toString(){
        return list.toString();
    }
}