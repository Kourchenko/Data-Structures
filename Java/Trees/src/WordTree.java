public class WordTree {

    NodeS root;


    WordTree() {
        root = null;

    }

    public boolean addValue(String value) {

        NodeS ptr = root;
        NodeS temp = new NodeS(value);

        if (root == null) {
            root = new NodeS(value);
            return true;
        }

        while (ptr != null) {
            if (value.charAt(0) < ptr.getValue().charAt(0)) {
                // Go left
                if (ptr.getLeft() == null) {
                    ptr.setLeft(temp);
                    return true;
                }

                // Else keep going left to insert at correct location
                ptr = ptr.getLeft();
            }

            if (value.charAt(0) > ptr.getValue().charAt(0)) {
                // Go right
                if (ptr.getRight() == null) {
                    ptr.setRight(temp);
                    return true;
                }

                ptr = ptr.getRight();
            }
        }

        return false;

    }   // boolean insert(value)

    public boolean find(String value) {
        if (root == null) {
            return false;
        }

        return recFind(root, value);
    }   // boolean find(value)

    public boolean recFind(NodeS ptr, String value) {
        if (ptr == null) {
            return false;

        }

        if (value == ptr.getValue()) {
            return true;

        }

        if (value.charAt(0) < ptr.getValue().charAt(0)) {
            // Go Left
            return recFind(ptr.getLeft(), value);

        }

        if (value.charAt(0) > ptr.getValue().charAt(0)) {
            // Go Right
            return recFind(ptr.getRight(), value);

        }

        return false;

    }   // boolean recFind(ptr, value)

    public void inOrder() {
        if (root == null) {
            return;
        }

        recInOrder(root);

    }   // void inOrder()

    private void recInOrder(NodeS ptr) {
        if (ptr == null) {
            return;

        }

        recInOrder(ptr.getLeft());

        System.out.print(ptr.getValue() + " ");

        recInOrder(ptr.getRight());

    }   // void recInOrder(ptr)


    public void preOrder() {
        if (root == null) {
            return;

        }

        recPreOrder(root);

    }   // void preOrder()

    private void recPreOrder(NodeS ptr) {

        /*
            Helper recursive function.
         */

        if (ptr == null) {
            return;

        }

        System.out.print(ptr.getValue() + " ");

        recPreOrder(ptr.getLeft());

        recPreOrder(ptr.getRight());

    }   // void recPreOrder(ptr)


    public void postOrder() {

        /*
            Traversal of a Binary Tree in the order:
            Left Node
            Right Node
            Self
         */
        if (root == null) {
            return;

        }

        recPostOrder(root);

    }   // void postOrder()

    private void recPostOrder(NodeS ptr) {

        if (ptr == null) {
            return;

        }

        recPreOrder(ptr.getLeft());

        recPreOrder(ptr.getRight());

        System.out.print(ptr.getValue() + " ");

    }   // void recPostOrder(ptr)

}   // WordTree


