public class PriorityQ {

    /**
     * Priority Queue implemented on a heap.
     */

    private final int SIZE = 20;
    private Heap queHeap;
    private int size;

    /* Priority Queue
       Default Constructor
     */
    PriorityQ() {
        queHeap = new Heap(SIZE);
        size = 0;
    } // Constructor PriorityQ

    public void insert(Edge item) {
        /**
         * Insert item in
         * sorted order.
         */

        queHeap.addValue(item);
        size++;
    } // void insert(Edge)

    public Edge removeMin() {
        /**
         * Remove the minimum item.
         */
        size--;
        return queHeap.removeValue();
    } // Edge removeMin()

    public void removeN(int loc) {
        /**
         * Remove item at location.
         */

        size--;
        queHeap.removeN(loc);
    } // void removeN(int)

    public Edge peekMin() {
        /**
         * Return the minimum item.
         * No removal from queue.
         */
        return queHeap.peek();
    } // Edge peekMin()

    public int size() {
        /**
         * Return number of items.
         */

        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    } // boolean isEmpty()

    public Edge peekN(int distV) {
        /**
         * Return the item at location.
         * No removal from queue.
         */

        return queHeap.peekN(distV);
    } // Edge peekN(int)

    public int find(int findDestIndex) {
        /**
         * Find item with specified
         * destination Vertex.
         */

        // Look for distance in queHeap
        for (int j = 0; j < size; j++) {
            if (queHeap.getN(j).destVert == findDestIndex)
                return j; // found
        }

        return -1; // not found
    } // int find(int)

} // Class PriorityQ

class Edge {

    /**
     * Edge
     *
     * Define an edge specifying
     * the distance from starting vertex
     * to destination vertex.
     */

    public int srcVert; // index of a vertex starting edge
    public int destVert; // index of a vertex ending edge
    public int distance; // distance from src to dest

    /*
        Edge
        Default Constructor
     */
    Edge(int sv, int dv, int d) {
        srcVert = sv;
        destVert = dv;
        distance = d;
    } // Constructor Edge()


} // Class Edge

class Heap {

    /**********************************************************************
     * File: Heap.java
     * Author: Diego Kourchenko
     * Date: 05.21.2017
     *
     * Heap - Data Structure
     * - void addValue(int value)
     * - int removeValue()
     * - String display()
     * - int getParent(int index)
     * - int getLeft(int index)
     * - int getRight(int index)
     * - void trickleDown(int index)
     * - void bubbleUp(int index)
     *
     *
     * Catches:
     *
     * ArrayIndexOutOfBounds
     * - If the array reaches max capacity,
     * - it copies all values over to an array doubled in size.
     *
     *********************************************************************/

    /*
        Instance variables
     */

    private static int SIZE = 20; // Constant
    private Edge theArray[]; // Heap implemented on a heap
    private int counter; // Number of items

    /* Default Constructor */
    Heap() {
        counter = 0;
        theArray = new Edge[SIZE];
    }   // Default Constructor

    /* Overloaded Constructor */
    Heap(int size) {
        SIZE = size;
        counter = 0;
        theArray = new Edge[size];
    }   // Overloaded Constructor

    public void addValue(Edge item) {

        /**
         * Add to the top-most element in heap.
         * Restore the heap condition in the process.
         *
         * Return the integer.
         */

        // If array is full make a new one twice as  big, copy items to it
        if (counter == SIZE) {
            // create new temporary array, twice the size
            Edge[] temp = new Edge[SIZE*2];

            // Linear copy
            for (int i = 0; i < SIZE; i++) {
                temp[i] = theArray[i];

            }
            // point theArray variable
            // to point to the reference temp
            theArray = temp;
            SIZE *= 2;

        }

        // add item in the next spot
        theArray[counter++] = item;

        // restore heap condition
        bubbleUp(counter-1);

    }   // void addValue(value)

    public Edge peek() {
        /**
         * Return the minimum value.
         * No removal from heap.
         */
        return theArray[0];
    }   // Edge peek()

    public Edge peekN(int indexV) {
        /**
         * Peek at index vertex.
         */
        for (int i=0; i <counter; i++) {
            if (i == indexV) {
                return theArray[i];
            }
        }
        return null;
    }

    public Edge getN(int n) {
        return theArray[n];
    } // Edge getN(int)

    public Edge removeValue() {
        /**
         * Remove the top-most element in heap.
         * Restore the heap condition in the process.
         *
         * Return the Edge.
         */

        try {

            if (counter <= 0) {
                throw new IndexOutOfBoundsException("Removing from empty heap.");
            }

            // Save value for later return
            Edge edge = theArray[0];

            // move last item to root
            theArray[0] = theArray[--counter];

            // restore heap condition
            trickleDown(0);

            return edge;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }

    }   // int removeValue()

    public void removeN(int loc) {
        /**
         * Remove value at location.
         * Restore the heap, using trickeDown(int)
         */

        // move last item to root
        theArray[loc] = theArray[--counter];

        // restore heap condition
        trickleDown(0);
    } // void removeN(int)

    /*
        Methods for
        Access to root and children.
     */

    // Root
    public int getParent(int index) {
        return (index-1)/2;
    }   // int getParent(index)

    // Left Child
    private int getLeft(int index) {
        return 2*index+1;
    }   // int getLeft(index)

    // Right child
    private int getRight(int index) {
        return 2*index+2;
    }   // int getRight(index)

    /*

     */
    private void trickleDown(int index) {
        /**
         * Recursively trickle down value
         * from root to proper place.
         */

        int left = getLeft(index);
        int right = getRight(index);

        // if no children, then a leaf node, quit
        if (left >= counter) {
            return;
        }

        // only a left child
        if (right >= counter) {

            // Do we need to swap?
            if (theArray[left].distance < theArray[index].distance) {
                // swap
                Edge tempEdge = theArray[left];
                theArray[left] = theArray[index];
                theArray[index] = tempEdge;

                // go on down left side
                trickleDown(left);
            }

        } else {
            // find out which one is smaller
            if (theArray[left].distance < theArray[right].distance) {
                if (theArray[left].distance < theArray[index].distance) {
                    // Replace left child with top index element
                    Edge tempEdge = theArray[left];
                    theArray[left] = theArray[index];
                    theArray[index] = tempEdge;

                    // Recursively move left child down
                    trickleDown(left);
                }

            } else {
                if (theArray[right].distance < theArray[index].distance) {
                    // swap
                    Edge tempEdge = theArray[right];
                    theArray[right] = theArray[index];
                    theArray[index] = tempEdge;
                    // go down right side
                    trickleDown(right);
                }

            }

        }

    }   // void trickleDown(index)

    private void bubbleUp(int index) {
        /**
         * Recursively bubble up from last to proper place.
         */

        // If we are at the root, no more work to do
        if (index == 0) {
            return;
        }

        // now see if we need to do a swap with parent
        int parent = getParent(index);

        // Keep the minimum value at the root
        if (theArray[parent].distance > theArray[index].distance) {
            Edge tempEdge = theArray[parent];
            theArray[parent] = theArray[index];
            theArray[index] = tempEdge;

            // Now go up the tree
            // moving the smaller value up
            bubbleUp(parent);

        } else {
            // Already in order
            return;
        }

    }   // void bubbleUp(index)

    public String display() {
        /**
         * Display the heap -- for debugging purposes.
         * Return a String containing all items in heap array.
         */

        String stringStream = "";
        for (int i = 0; i < counter; i++) {
            stringStream += theArray[i] + " ";
        }
        return stringStream;
    }   // String display()

    public static void main(String[] args) {
        PriorityQ pq = new PriorityQ();

        pq.insert(new Edge(0, 1, 6));
        pq.insert(new Edge(0, 2, 4));
        pq.insert(new Edge(0, 4, 10));
        pq.insert(new Edge(1, 3, 7));
        pq.insert(new Edge(1, 4, 7));

        System.out.println("Min: " + pq.removeMin().destVert);
        System.out.println("Min: " + pq.removeMin().destVert);
        System.out.println("Min: " + pq.removeMin().destVert);
        System.out.println("Min: " + pq.removeMin().destVert);
        System.out.println("Min: " + pq.removeMin().destVert);
    }

}
