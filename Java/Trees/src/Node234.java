/**
 * Class Node234
 * File: Node234.java
 * Author: Diego Kourchenko
 * Date: 05.07.2017
 *
 *
 * Node234:
 *
 * Defines a class Node for a 2-3-4 Tree
 * Maximum children per node is 4; DEGREE = 4.
 *
 * Parent is a node of type Node234, with 4 children.
 * The children are stored in an array of nodes of type Node234.
 *
 */

public class Node234 {

    static final int DEGREE = 4;                                // MAX number of Children

    private Node234 parent;                                     // root node of children

    // Each node is an array of integer values
    private Node234[] children = new Node234[DEGREE];           // children nodes of root

    private int[] values = new int[DEGREE-1];                   // values at child node

    private int numValues;                                      // current number of values present

    Node234() {
        for (int i=0; i<DEGREE; i++) {
            children[i] = null;
        }
        numValues = 0;
    }   // Node234()

    public void addChild(int index, Node234 child) {

        children[index] = child;
        if (child != null) {
            child.parent = this;

        }

    }   // void addChild(index, child)

    public Node234 removeChild(int index) {

        /*
            Remove child node at index.
         */

        Node234 foundNode = children[index];
        children[index] = null;

        return foundNode;

    }   // removeChild(index)

    public Node234 getChild(int index) {
        /*
            Given an index, return that child pointer
         */

        return children[index];

    }   // Node234 getChild(index)

    public int getValue(int index) {

        /*
            Return the value the node at the index given.
         */

        return values[index];

    }   // int getValue()

    public Node234 getParent() {
        /*
            Return the parent Nod234
         */

        return parent;

    }   // Node234 getParent()

    public boolean isLeaf() {

        /*
            Are there any children?
            false if any elements in children array
            true if not one element in children array
         */

        return children[0] == null;

    }   // boolean isLeaf()

    public int getNumValues() {
        /*
            Number of values in node
         */
        return numValues;

    }   // int getNumValues()

    public boolean isFull() {
        /*
            Return true if node->children is full,
            if numValuesAtChild > DEGREE
         */

        return numValues == DEGREE-1;

    }   // boolean isFull()

    public int insertValue(int value) {
        /*
            Add a new value, return where it was stored.
         */

            if (numValues == 0) {
                values[numValues++] = value;
                return 0;
            }

            int index = numValues-1;
            while ((index >= 0) && (values[index] > value)) {
                values[index+1] = values[index];
                index--;
            }

            values[++index] = value;
            numValues++;

            return index;



    }   // int insertValue(value)

    public int removeValue() {

        /*
            Remove the largest value present in the current Node234.
         */

        try {
            return values[--numValues];

        } catch (NullPointerException e) {
            System.out.print(":underflow_error... Node234::removeValue()");
            return -1;

        }

    }   // int removeValue()

    public int findValue(int value) {
        /*
            Find an item at Node234
            return -1 if not present, index otherwise
         */

        // Loop through values at current node
        for (int i = 0; i < numValues; i++) {
            if (values[i] == value) {
                return i;                               // Found
            }
        }

        return -1;                                      // Not Found
    }   // int findValue(value)


    public int getDegree() {
        return DEGREE;
    }
}
