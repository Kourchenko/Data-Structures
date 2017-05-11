/**
 * Created by diegok on 5/2/17.
 */
public class BinarySearchTree {

    /**
     * 0      - root
     * /\      - link, edge, ptr
     * 0  0     - inner node
     * / \/ \    - link, edge, ptr
     * 0 0 0 0    - inner node
     * / / / /     - link, edge, ptr
     * 0 0 0 0      - leaf
     * root - string node, base of type
     * node per level = 2 ^ (n-1)
     * nodes total = (2^n) - 1
     * Rules:
     * 1. tree
     * 2. binary
     * 3. left smaller
     * 4. right bigger or equal
     * 20      - root
     * / \      - link, edge, ptr
     * 10  30     - inner node
     * \    \
     * 18    40
     * /
     * 33    - right of 30, left (smaller) of 40
     * find log(N)
     * add log(N)
     * remove
     */


    Node root;

    BinarySearchTree(Node r) {
        root = r;
    }

    public boolean insert(String value) {
        Node ptr = root;
        Node temp = new Node(value);

        while (ptr != null ){
            if (value.charAt(0) < ptr.getValue().charAt(0)) {
                // go left
                if (ptr.getLeft() == null) {
                    ptr.setLeft(temp);
                    return true;
                }
                ptr = ptr.getLeft();
            }

            if (value.charAt(0) > ptr.getValue().charAt(0)) {
                // go right
                if (ptr.getRight() == null) {
                    ptr.setRight(temp);
                    return true;
                }
                ptr = ptr.getRight();
            }
        }
        return false;
    }   // boolean add(value)

    public boolean linearFind(String value) {
        Node ptr = root;

        if (root == null) {
            return false;
        }

        while (ptr != null) {

            // IF lots of add
            // If few deletes
            // Doesn't check if it's at this node

            // Else
            // keep ptr1 as the parent

            if (ptr.getValue().charAt(0) == value.charAt(0) && (ptr.present)) {
                return true;
            }

            if (value.charAt(0) < ptr.getValue().charAt(0)) {
                // Go left
                ptr = ptr.getLeft();
            }
            if (value.charAt(0) > ptr.getValue().charAt(0)) {
                // Go right
                ptr = ptr.getRight();
            }
        }
        return false;           // Not found;
    }   // boolean linearFind(value)

    public boolean recFind(String value, Node ptr) {

        if (ptr == null) {
            return false;
        }

        if (value.charAt(0) == ptr.getValue().charAt(0)) {
            return true;
        }

        if (value.charAt(0) > ptr.getValue().charAt(0)) {
            // Go into right (bigger)
            return recFind(value, ptr.getRight());
        }

        if (value.charAt(0) < ptr.getValue().charAt(0)) {
            // Go into left (smaller)
            return recFind(value, ptr.getLeft());
        }
        return false;
    }   // boolean recFind(value, ptr)


    public void traversalInOrder(Node root) {
        String buffer = "";

        if (root == null) {
            return;
        }

        recInOrder(root, buffer);

    }

    private void recInOrder(Node root, String buff) {

        /*
            Traversal of a tree in the order: left, self, right
         */

        if (root == null) {
            System.out.println(buff);
            return;
        }

        if (root.getLeft() != null) {
            buff += root.getLeft().getValue() + "<-";
        }

        buff += "<>" + root.getValue() + "<>";

        if (root.getRight() != null) {
            buff += root.getRight().getValue() + "->";
        }

        // Traverse Left First, then Right
        if (root.getLeft() != null) {
            recInOrder(root.getLeft(), buff);
        } else {
            recInOrder(root.getRight(), buff);
        }

    }   // Node recInOrder(root, buffer)

    public static void main(String[] args) {
        Node root = new Node("middle");
        BinarySearchTree bSearch = new BinarySearchTree(root);

        bSearch.insert("grape");
        bSearch.insert("apple");
        bSearch.insert("house");
        bSearch.insert("pine");
        bSearch.insert("tree");
        bSearch.insert("never");

        System.out.println(bSearch.recFind("tree", root));

        bSearch.traversalInOrder(root);

    }   // void main()

}
