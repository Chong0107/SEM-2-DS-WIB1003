
package BinarySearchTree;

import java.util.Iterator;

public class BST <E extends Comparable<E>> extends AbstractTree<E>{
    protected TreeNode<E> root;
    protected int size = 0;

    public BST() {
    }

    public BST(E[] Object) {
        for(int i=0;i<Object.length;i++){
            insert(Object[i]);
        }
    }

    @Override
    public boolean search(E e) {
        TreeNode<E> current = root; //start from the root
        while(current != null){
            if(e.compareTo(current.element)<0){
                current = current.left; //go left
            }
            else if(e.compareTo(current.element)>0){
                current = current.right; //go right
            }
            else{ // Element matches current.element
                return true; // Element is found
            }
        }
        return false;
    }

    @Override
    public boolean insert(E e) {
        if(root == null){
            root = createNewNode(e); //Create a new root
        }
        else{
            //Locate the parent node
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while(current != null){
                if(e.compareTo(current.element)<0){
                    parent = current;
                    current = current.left;
                }
                else if(e.compareTo(current.element)>0){
                    parent = current;
                    current = current.right;
                }
                else{
                    return false; //Duplicate node not inserted
                }
            }
                
                //Create the new node and attach it to the parent node
                if(e.compareTo(parent.element)<0){
                    parent.left = createNewNode(e);
                }
                else{
                    parent.right = createNewNode(e);
                } 
        }
        size++;
        return true; //Element inserted successfully;
    }

    protected TreeNode<E> createNewNode(E e){
        return new TreeNode<E>(e);
    }

    @Override
    public void preorder() {
        preorder(root);
    }
    
    protected void preorder(TreeNode<E> root){
        if(root == null)
            return;
        System.out.print(root.element+" ");
        preorder(root.left);
        preorder(root.right);
    }

    @Override
    // Postorder traversal from the root
    public void postorder() {
        postorder(root);
    }
    
    // Postorder tranversal from a subtree
    protected void postorder(TreeNode<E> root){
        if(root == null)
            return;
        inorder(root.left);
        inorder(root.right);
        System.out.print(root.element+" ");
    }

    @Override
    // Inorder traversal from the root
    public void inorder() {
        inorder(root);
    }
    
    // Inorder tranversal from a subtree
    protected void inorder(TreeNode<E> root){
        if(root == null)
            return;
        inorder(root.left);
        System.out.print(root.element+" ");
        inorder(root.right);
    }
    
    public static class TreeNode<E extends Comparable<E>> {

        protected E element;
        protected TreeNode<E> left;
        protected TreeNode<E> right;

        public TreeNode(E e) {
            element = e;
        }

    }
    
    //Return the height of the BST
    public int height(){
        return height(root);
    }
    
    public int height(TreeNode<E> node){
        if(node == null){
            return -1;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
    
    public E minValue(){
        return minValue(root);
    }
    
    //Function to return least value recursively
    private E minValue(TreeNode<E> node){
        if(node.left == null){
            return node.element;
        }
        return minValue(node.left);
    }
    
    public E maxValue(){
        return maxValue(root);
    }
    
    //Function to return highest value recursively
    private E maxValue(TreeNode<E> node){
        if(node.right == null){
            return node.element;
        }
        return maxValue(node.right);
    }
    
    @Override
    // Delete an element from the binary tree
    // Return true if the element is deleted successfuly
    // Return false if the element is not in the tree
    public boolean delete(E e) {
        //Locate the node to be deleted and also locate its parent node
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while(current != null){
            if(e.compareTo(current.element)<0){
                parent = current;
                current = current.left;
            }
            else if(e.compareTo(current.element)>0){
                parent = current;
                current = current.right;
            }
            else{
                break; //Element is in the tree pointed at by current
            }
            
            if(current == null){
                return false; //Element is not in the tree
            }
            
            //Case 1: current has no left child
            if(current.left == null){
                //Connect the parent with the right child of the current node
                if(parent == null){
                    root = current.right;
                }
                else{
                    if(e.compareTo(parent.element)<0){
                        parent.left = current.right;
                    }
                    else{
                        parent.right = current.right;
                    }
                }
            }
            else{
                //Case 2: The current node has a left child
                //Locate the rightmost node in the left subtree of
                //the current node and also its parent
                TreeNode<E> parentOfRightMost = current;
                TreeNode<E> rightMost = current.left;
                
                while(rightMost.right != null){
                    parentOfRightMost = rightMost;
                    rightMost = rightMost.right; //Keep going to the right
                }
                
                //Replace the element in current by the element in rightMost
                current.element = rightMost.element;
                
                //Eliminate rightmost node
                if(parentOfRightMost.right == rightMost)
                    parentOfRightMost.right = rightMost.left;
                else
                    //Special case: parentOfRightMost == current
                    parentOfRightMost.left = rightMost.left;
            }
        }
        size--;
        return true; //Element deleted successfully
    }

    @Override
    public int getSize() {
        return size;
    }

    //Returns the root of the tree
    public E getRoot(){
        return root.element;
    }
    
    //Returns a path from the root leading to the specified element
    public java.util.ArrayList<TreeNode<E>> path(E e){
        java.util.ArrayList<TreeNode<E>> list = new java.util.ArrayList<TreeNode<E>>();
        TreeNode<E> current = root; //Start from the root
        while(current != null){
            list.add(current); //Add the node to the list
            if(e.compareTo(current.element)<0){
                current = current.left;
            }
            else if(e.compareTo(current.element)>0){
                current = current.right;
            }
            else{
                break;
            }
        }
        return list; //Return an array list of nodes
    }

    @Override
    public java.util.Iterator<E> iterator() {
        return new InorderIterator();
    }
    
    //Inner class InorderIterator
    private class InorderIterator implements java.util.Iterator<E>{
        //Store the elements in a list
        private java.util.ArrayList<E> list = new java.util.ArrayList<E>();
        private int current = 0; //Point to the current element in list

        public InorderIterator() {
            inorder(); // Traverse binary tree and store elements in list
        }
        
        //Inorder traversal from the root
        private void inorder(){
            inorder(root);
        }
        
        //Inorder traverasl from a subtree
        private void inorder(TreeNode<E> root){
            if(root == null){
                return;
            }
            inorder(root.left);
            list.add(root.element);
            inorder(root.right);
        }
        
        @Override
        //More elements for traversing
        public boolean hasNext(){
            if(current < list.size())
                return true;
            
           return false;
        }
        
        @Override
        //Get the current element and move to the next
        public E next(){
            return list.get(current++);
        }
        
        @Override
        //Remove the current element
        public void remove(){
            delete(list.get(current));
            list.clear();
            inorder();
        }
    }
   
    @Override
    //Remove all elements from the tree
    public void clear() {
        root = null;
        size = 0;
    } 
}
