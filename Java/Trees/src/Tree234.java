public class Tree234 {

    Node234 root;

    Tree234() {
        root = new Node234();

    }

    public void traversalInOrder() {

        String buff = "";

        buff = recInOrder(root);

        System.out.println(buff);

    }   // void traversalInOrder()

    private String recInOrder(Node234 node) {

        if (node == null) {
            return "";

        }

        String buffer = "";

        buffer += recInOrder(node.getChild(0));

        for (int i=0; i<node.getNumValues(); i++) {
            buffer += node.getValue(i) + " ";
            buffer += recInOrder(node.getChild(i+1));
        }

        return buffer;
    }   // void recInOrder(node, buffer)

    private void recDelete(Node234 ptr) {
        if (ptr == null) {
            return;
        }

        for (int i=0; i< ptr.getDegree(); i++) {
            recDelete(ptr.getChild(i));

        }

    }   // void recDelete(ptr)

    public void split(Node234 ptr) {

        /*
            If array is full, split the children,
            move middle child up,
            create new node, sorting the rest.
         */

        int valueB, valueC;
        Node234 parent, child2, child3;
        int valueIndex;

        // remove two largest values
        valueC = ptr.removeValue();
        valueB = ptr.removeValue();

        // remove two right-most children
        child2 = ptr.removeChild(2);
        child3 = ptr.removeChild(3);

        // create a new node
        // put rightmost stuff in it
        Node234 newRight = new Node234();
        newRight.insertValue(valueC);
        newRight.addChild(0, child2);
        newRight.addChild(1, child3);

        // Special case: root
        if (ptr == root) {
            // make a new node and attach this node to it
            root = new Node234();
            parent = root;
            root.addChild(0, ptr);
        } else {
            parent = ptr.getParent();

        }

        // modify parent
        // move second value up to it
        // and connect newRight appropriately
        valueIndex = parent.insertValue(valueB);

        for (int i=parent.getNumValues()-1; i > valueIndex; i--) {
            Node234 temp = parent.removeChild(i);
            parent.addChild(i + 1, temp);
        }

        // now add new link in remaining slot
        parent.addChild(valueIndex+1, newRight);

    }   // void split(ptr)

    public Node234 getNextChild(Node234 node, int value) {

        /*
            Helper function for insert.
            Return next child larger than value
         */

        for (int i=0; i<node.getNumValues(); i++) {
            if (value < node.getValue(i)) {
                return node.getChild(i);
            }

        }
        return node.getChild(node.getNumValues());

    }   // Node234 getNextChild(node, value)

    public void insert(int value) {

        // Add a value to the tree

        Node234 ptr = root;

        // Break when we find the proper leaf
        // to insert into
        while (true) {

            // children array is full
            if (ptr.isFull()) {
                // Split it up
                split(ptr);

                // go up to parent to start over
                ptr = ptr.getParent();

                // go back down proper branch
                ptr = getNextChild(ptr, value);

            } else if (ptr.isLeaf()) {                          // not full, see if leaf
                break;

            } else {
                ptr = getNextChild(ptr, value);

            }

        }

        ptr.insertValue(value);

    }   // void insert(value)

    public boolean find(int value) {
        /*
            Find value starting at the root.
         */

        if (root == null) {
            return false;
        }

        return recFind(value, root);

    }   // boolean find(value)

    private boolean recFind(int value, Node234 ptr) {

        /*
            Helper function for recursive find.
         */

        if (ptr == null) {
            return false;
        }

        int num = ptr.getNumValues();

        // Check all elements in list,
        // except the last element.
        for (int i=0; i<num; i++) {
            if (ptr.getValue(i) == value) {
                return true;
            }

            if (ptr.getValue(i) != value) {
                return recFind(value, ptr.getChild(i));

            }

        }

        // Check the last element in the list
        return recFind(value, ptr.getChild(num));

    }   // boolean recFind(value, ptr)

    public static void main(String[] args) {

        Tree234 tree234 = new Tree234();

        tree234.insert(50);
        tree234.insert(40);
        tree234.insert(60);
        tree234.insert(30);
        tree234.insert(70);
        tree234.insert(80);
        tree234.insert(90);
        tree234.insert(10);
        tree234.insert(20);

        tree234.traversalInOrder();

    }
}
