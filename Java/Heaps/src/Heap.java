public class Heap {

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
    private int theArray[]; // Heap implemented on a heap
    private int counter; // Number of items

    /* Default Constructor */
    Heap() {
        counter = 0;
        theArray = new int[SIZE];
    }   // Default Constructor

    /* Overloaded Constructor */
    Heap(int size) {
        SIZE = size;
        counter = 0;
        theArray = new int[SIZE];
    }   // Overloaded Constructor

    public void addValue(int value) {

        /**
         * Add to the top-most element in heap.
         * Restore the heap condition in the process.
         *
         * Return the integer.
         */

        // If array is full make a new one twice as  big, copy items to it
        if (counter == SIZE) {
            // create new temporary array, twice the size
            int temp[] = new int[SIZE*2];

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
        theArray[counter++] = value;

        // restore heap condition
        bubbleUp(counter-1);

    }   // void addValue(value)

    public int removeValue() {
        /**
         * Remove the top-most element in heap.
         * Restore the heap condition in the process.
         *
         * Return the integer.
         */

        if (counter <= 0) {
            throw new IndexOutOfBoundsException("Removing from empty heap.");
        }

        // Save value fro later return
        int value = theArray[0];

        // move last item to root
        theArray[0] = theArray[--counter];

        // restore heap condition
        trickleDown(0);

        return value;

    }   // int removeValue()

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
            if (theArray[left] < theArray[index]) {
                // swap
                int temp = theArray[left];
                theArray[left] = theArray[index];
                theArray[index] = temp;

                // go on down left side
                trickleDown(left);
            }

        } else {
            // find out which one is smaller
            if (theArray[left] < theArray[right]) {
                if (theArray[left] < theArray[index]) {
                    // Replace left child with top index element
                    int temp = theArray[left];
                    theArray[left] = theArray[index];
                    theArray[index] = temp;

                    // Recursively move left child down
                    trickleDown(left);
                }

            } else {
                if (theArray[right] < theArray[index]) {
                    // swap
                    int temp = theArray[right];
                    theArray[right] = theArray[index];
                    theArray[index] = temp;
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
        if (theArray[parent] > theArray[index]) {
            int temp = theArray[parent];
            theArray[parent] = theArray[index];
            theArray[index] = temp;

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

}   // Class Heap
