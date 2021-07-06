
package BinarySearchTree;

public interface TreeInterface<E> extends Iterable<E>{
    // Return true if the specified element is in the list
    public boolean search(E e);
    
    // Return true if the element is added successfully
    public boolean insert(E e);
    
    // Return true if the element is removed from the tree successfully
    public boolean delete(E e);
    
    // Prints the nodes in inorder traversal
    public void inorder();
    
    // Print the nodes in preorder tranversal
    public void preorder();
    
    // Prints the nodes in postorder tranversal
    public void postorder();
    
    // Returns the number of elements in the tree
    public int getSize();
    
    // Returns true if the tree is empty
    public boolean isEmpty();
    
    // Removes all elements from the tree
    public void clear();
}
