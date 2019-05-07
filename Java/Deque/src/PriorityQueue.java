public class PriorityQueue {

    // FIELDS
    private int[] priorityQ;
    private int size;
    private int nElems;

    /*
     * Priority queue holds integers
     *
     * different from example in the book
     *
     * it should have insertions O(1)
     * it should have removals O(N)
     *
     * ( the book does insertions O(N); removals O(1) )
     *
     * - isEmpty()
     * - isFull()
     * - insert(n)
     * - remove()
     *
     * Priority should return the smallest item in queue
     */


    PriorityQueue() {

        /*
         * Default Constructor initialize to 100 elements.
         */

        size = 100;
        priorityQ = new int[size];
        nElems = 0;

    }   // Constructor PriorityQueue()

    PriorityQueue(int N) {

        /*
         * Overloaded Constructor initialize to n elements.
         */

        size = N;
        priorityQ = new int[size];
        nElems = 0;

    }   // Constructor PriorityQueue(int n)

    public boolean insert(int value) {

        /*
         * Insert element to queue array
         * O(1) insertions
         */

        try {
            if (nElems+1 < size) {                                          // Insert anywhere in Queue, no matter priority
                priorityQ[nElems++] = value;
                return true;

            } else {
                throw new ArrayIndexOutOfBoundsException();

            }

        } catch (ArrayIndexOutOfBoundsException e) {
            return false;

        }

    }   // boolean insert()

    public int remove() {

        /*
         * Remove highest priority item in array queue, smallest integer.
         * O(N) removal
         *
         */

        int value = 0;
        int index = 0;

        for (int i=nElems-1; i > 0; i--) {                                  // Check Priority of Items, remove highest priority
            if (priorityQ[i] < priorityQ[index]) {
                index = i;

            }

        }

        value = priorityQ[index];

        for (int i=index; i < nElems-1; i++) {                              // Shift Priority
            priorityQ[i] = priorityQ[i+1];
        }

        nElems--;

        return value;

    }   // int remove()

    public int getLargest() {

        int value = 0;
        int index = 0;

        for (int i = nElems-1; i > 0; i--) {
            if (priorityQ[i] > priorityQ[index]) {
                index = i;
            }
        }

        value = priorityQ[index];

        for (int i = index; i < nElems-1; i++) {
            priorityQ[i] = priorityQ[i+1];

        }

        nElems--;

        return value;

    }   // int getLargest()

    public int getSmallest() {

        /*
         * Remove and return smallest element
         */

        /*
         * Remove highest priority item in array queue, smallest integer.
         * O(N) removal
         *
         */

        int value = 0;
        int index = 0;

        for (int i=nElems-1; i > 0; i--) {                                  // Check Priority of Items, remove highest priority
            if (priorityQ[i] < priorityQ[index]) {
                index = i;

            }

        }

        value = priorityQ[index];

        for (int i=index; i < nElems-1; i++) {                              // Shift Priority
            priorityQ[i] = priorityQ[i+1];
        }

        nElems--;

        return value;

    }   // int getSmallest()

    public String curElems() {
        /*
         * Return a display string of elements in queue.
         * O(N) removals
         *
         */

        String displayString = "";

        try {
            if (nElems > 0) {                                   // No elements in array


                for (int i = 0; i < nElems; i++) {
                    displayString += priorityQ[i] + " ";        // Add elements to display string

                }

                return displayString;

            } else {
                throw new ArrayIndexOutOfBoundsException();     // Catch no elements in array exception
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return displayString;                               // Return empty string

        }

    }   // String curElems()

    public boolean isEmpty() {
        /*
         * Return true if queue array is empty
         */
        return (nElems == 0);

    }   // boolean isEmpty()

    public boolean isFull() {
        /*
         * Return true if queue array is full
         */

        return (nElems == size-1);

    }   // boolean isFull()

    public void zeroOut() {

        /*
         * Shows empty Priority Queue
         */
        String displayString = "[ ";

        for (int i = 0; i < size-1; i++) {
            displayString += priorityQ[i] + ", ";
        }

        displayString += " ]";

        System.out.println(displayString);

    }   // void zeroOut()

}   // Class PriorityQueue.java
