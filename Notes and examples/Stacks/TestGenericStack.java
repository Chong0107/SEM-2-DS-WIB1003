
package Stacks;

public class TestGenericStack {
    public static void main(String[] args) {
        GenericStack<String> stack = new GenericStack<>();
        
        // Add elements to the stack
        stack.push("Tom"); // Push it to the stack
        System.out.println("(1) "+stack);
        
        stack.push("Susan"); // Push it to the stack
        System.out.println("(2) "+stack);
        
        stack.push("Kim"); // Push it to the stack
        stack.push("Micheal"); // Push it to the stack
        System.out.println("(3) "+stack);
        
        // Remove elements from the stack
        System.out.println("(4) "+stack.pop());
        System.out.println("(5) "+stack.pop());
        System.out.println("(6) "+stack);
    }
}
