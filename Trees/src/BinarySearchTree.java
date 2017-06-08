public class BinarySearchTree {

    /**
     * Binary Search Tree - Integer
     *
     * Implements:
     * - void insertItem(value) - add new element
     * - boolean findItem(value) - find element
     * - void inOrder() - traversal: self, left right
     * - void displayTree() - traversal in order
     * - int findNext(value) - find value, or smallest element, larger than value
     * - boolean findDelete(value) - finds and deletes the value
     */

    private Node root;

    BinarySearchTree()
    {
        root = null;
    }   // Constructor BinarySearchTree()

    public void insertItem(int value) {

        /**
         * Insert the integer value.
         * Due to the nature of the tree structure, findNext, findDelete...
         * Cannot insert values less than -1;
         */
        if (value < 0) {
            System.out.println(value + ": Cannot insert values greater than 0..." );
            return;
        }
        // Empty Tree
        if (root == null) {
            root = new Node(value);
            return;
        }

        Node ptr = root;
        Node temp = new Node(value);

        // Find proper location to put the value
        while (ptr != null) {
            if (value < ptr.getValue()) {
                // Go Left
                if (ptr.getLeft() == null) {
                    ptr.setLeft(temp);
                    return;
                }
                ptr = ptr.getLeft();
            } else {
                // Go Right
                if (ptr.getRight() == null) {
                    ptr.setRight(temp);
                    return;
                }
                ptr = ptr.getRight();
            }
        }
    }   // boolean add(value)

    public boolean findItem(int val) {

        /**
         * Find the integer value.
         */

        // No tree
        if (root == null) {
            return false;
        }

        // Call helper, recursive method
        return recFind(val, root);

    }   // boolean findItem(val)

    private boolean recFind(int value, Node ptr) {

        /*
            Recursively find the integer value, starting at Node ptr.
         */

        if (ptr == null) {
            return false;
        }

        if (value == ptr.getValue()) {
            return true;
        }

        if (value > ptr.getValue()) {
            // Go into right (bigger)
            return recFind(value, ptr.getRight());
        }

        if (value < ptr.getValue()) {
            // Go into left (smaller)
            return recFind(value, ptr.getLeft());
        }
        return false;

    }   // boolean recFind(value, ptr)

    public void displayTree() {

        /*
            Displays the each node in the tree,
            in order traversal.
         */

        if (root == null) {
            return;
        }

        recInOrder(root);

    }   // void traversalInOrder()

    private void recInOrder(Node node) {

        /*
            Helper function.
            Traversal of a tree in the order: left, self, right.
         */

        if (node == null) {
            return;
        }
        // Self
        System.out.print(node.getValue() + " ");

        // Left
        recInOrder(node.getLeft());

        // Right
        recInOrder(node.getRight());


    }   // Node recInOrder(root, buffer)


    public int findNext(int val) {

        /*
            Find the value in the tree.
            If not found, see if there is a larger value passed.
         */

        // Abandon all hope, all ye who enter the void
        if (root == null) {
            return -1;
        }

        return recFindNext(val, root, root);

    }   // int findNext(val)

    private int recFindNext(int val, Node localNode, Node localParent) {

        /*
            Helper recursive function.
            Find value, if present.
            If not present, return the smallest element larger than value.
         */

        // No Value found.
        if (localNode == null) {
            // Check Parent
            if (localParent.getValue() > val) {
                return localParent.getValue();
            }

            // Not ptr,
            // Not parent.
            return -1;
        }

        // Found value at ptr
        if (localNode.getValue() == val) {
            if (localNode.isPresent()) {                    // Value is not deleted.
                return val;

            // Check Parent
            } else if (localParent.isPresent()) {
                if (localParent.getValue() > val) {         // Is the parent bigger? A fix for unbalanced trees...
                    return localParent.getValue();

                }

            } else {

                // Not ptr,
                // Not parent.
                return -1;                                  // Worst Case: How did we get here?
            }

        }

        if (val > localNode.getValue()) {
            return recFindNext(val, localNode.getRight(), localNode);
        } else {
            localParent = localNode;
            return recFindNext(val, localNode.getLeft(), localParent);
        }

    }   // recFindNext(val, ptr, parent)

    public boolean findDelete(int val) {
        /*
            Find the integer value and set the node to not present.
         */
        if (root == null) {
            return false;

        }

        return recDelete(val, root, root);

    }   // findDelete(val)

    private boolean recDelete(int val, Node ptr, Node parent) {
        /*
            Helper delete function,
            set node to not present if found,
            else return -1, NOT FOUND.
         */

        if (ptr == null) {
            return false;

        }

        // Found value
        if (val == ptr.getValue()) {
            if (ptr.isPresent()) {
                // Delete the node
                ptr.setNotPresent();
                return true;
            }
            return false;

        }
        // Found larger
        if (ptr.getValue() > val) {
            if (ptr.isPresent()) {
                ptr.setNotPresent();
                return true;
            }
            return false;
        }

        if (ptr.getValue() < val) {
            return false;
        }

        if (val < ptr.getValue()) {
            parent = ptr;
            return recDelete(val, ptr.getLeft(), parent);

        }

        if (val > ptr.getValue()) {
            return recDelete(val, ptr.getRight(), parent);

        }

        // Not found
        return false;

    }   // boolean recDelete(val, ptr, parent)

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();


        bst.insertItem(5);
        bst.insertItem(4);
        bst.insertItem(3);
        bst.insertItem(2);
        bst.insertItem(1);

        bst.insertItem(6);
        bst.insertItem(7);

        bst.displayTree();
    }

}   // BinarySearchTree()
