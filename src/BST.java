
import java.util.ArrayList;
import java.util.List;

/**
 * A Binary Search Tree (BST)
 *
 * Data inside the BST must have a compareTo method
 */
public class BST<T extends Comparable<T>> {
    private Node<T> root;

    /**
     * Constructs an empty BST
     */
    public BST(){
        this.root = null;
    }

    /**
     * Add data the the Binary Search tree via the ordering done
     * by the comparator
     * @param data the data to add
     */
    public void add( T data ){ //Time Complexity: O(n)
        //checks for empty tree
        if(root == null){
            root = new Node<T>();
            root.data = data;

            return;
        }
        else {
            Node<T> currentnode = root;
            Node<T> adding = new Node<>();
            adding.data = data;
            //iterates through tree to get to node and add node
            while (currentnode != null){

                if(currentnode.data.compareTo(data) <0){
                    if (currentnode.right == null) {
                        currentnode.right = adding;
                        return;
                    }else {
                        currentnode = currentnode.right;
                    }
                }else if(currentnode.data.compareTo(data) >= 0){
                    if (currentnode.left == null) {
                        currentnode.left = adding;
                        return;
                    }else {
                        currentnode = currentnode.left;
                    }
                }
            }

            return;
        }
    }



    /**
     * Removes a Node from the BST
     * @param curr the node to remove
     * @param parent the parent of curr
     * @return the exact data removed
     */

    private T removeNode( Node<T> curr, Node<T> parent ){ //Time Complexity: O(n)
        T returnData;
        //checks if there are two children
        if (curr.left != null && curr.right != null){
            Node<T> leftparent = curr;
            Node<T> RML = curr.left;
            //finds right most left node
            while ( RML.right != null){
                leftparent = RML;
                RML = RML.right;
            }
            returnData = curr.data;
            curr.data = RML.data;
            removeNode(RML, leftparent);
            return returnData;
        }else{
            //deals with 0 and 1 child
            Node<T> here = curr.left;
            if( here == null){
                here = curr.right;
            }
            if (parent == null){
                root = here;
            }else {
                if (curr == parent.left) {
                    parent.left = here;
                } else {
                    parent.right = here;
                }
            }
            returnData = curr.data;
        }



        return returnData;
    }

    /**
     * Removes the first element equal to data when using the comparator function
     * @param data the element to compare with
     * @return the exact data removed from the BST
     */
    public T remove( T data ){ //Time Complexity: O(n)
        if (root == null) {
            return  null;
        }
        Node<T> parent = null;
        T retrn = null;
        Node<T> curr = this.root;

        while(curr != null){
            if(curr.data.compareTo(data) == 0){
                retrn = removeNode(curr, parent);
                return  retrn;
            } else {
                parent = curr;
                if ( curr.data.compareTo(data)< 0){
                    curr = curr.right;
                }else{
                    curr = curr.left;
                }
            }
        }


        return retrn;

    }




    /**
     * Completes an inOrder traversal of the BST
     * @return Starting from the root, a list of the resulting inOrder traversal
     */
    public List<T> inOrder(){ //Time Complexity: O(1)
        List<T> list = new ArrayList<>();
        list = inOrder(root, list);
        return list;

    }

    /**
     * Completes an inOrder traversal of the BST
     * @param curr the node start at (null indicates stoppage)
     * @param list the list to add to
     * @return Starting at curr, a list of the resulting inOrder traversal
     */
    private List<T> inOrder(Node<T> curr, List<T> list ){ //Time Complexcity: O(n)
        if(curr == null) {
            return list;}
        inOrder(curr.left, list);
        list.add(curr.data);
        inOrder(curr.right, list);
        return list;
    }


    /**
     * Each element of the BST
     * @param <E> the type of data stored
     */
    private class Node<E extends Comparable<E>> {
        public E data;
        public Node<E> left;
        public Node<E> right;
    }
}