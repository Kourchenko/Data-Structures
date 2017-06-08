class ArrayClass {

    /****************************************************
     * File: ArrayClass.java
     * Author: Diego Kourchenko
     * Created: 02.06.17
     *
     * Array Class
     *
     * Linear Search of items in a list
     * Ordered Arrays: O(log n)
     * Unordered Arrays: O(n)
     ****************************************************/


    /* Instance Variables */
    private static int SIZE = 10;
    private int[] theArray;
    private int nItems; // number of items
    private int smallest; // store the smallest integer
    private int largestIndex; // store the largest integer

    /* Constructor */
    ArrayClass() {
        theArray = new int[SIZE];
        nItems = 0;
    } // ArrayClass()

    /* Overload Constructor */
    ArrayClass(int size) {
        SIZE = size;
        theArray = new int[size];
        nItems = 0;
    } // ArrayClass(size)

    public void resize() {

        /*
         * Resize the array if full.
         */

        // Create empty array, double in SIZE
        int[] tempArray = new int[SIZE*2];

        // Copy all values into larger array
        for (int i = 0; i < nItems; i++) {
            tempArray[i] = theArray[i];
        }

        SIZE *= 2; // double the size of the array
        theArray = tempArray; // new re-sized array
    } // void resize()

    public void addElem(int value) {

        /*
         * Add integer value to array.
         * Re-sizes array if maxed out.
         */

        // next add will create a full array
        if (nItems+1 == SIZE) {
            // double array size
            resize();
            return;
        }

        // Store the largest value index
        if (value > theArray[largestIndex]) {
            largestIndex = nItems;
        }

        // add new value to array
        theArray[nItems++] = value;

    } // void addSorted(value)

    public boolean delElem(int value) {

        /*
         * Delete the last element added.
         */

        if (isEmpty()) // empty array
            return false;

        // Removing the largest value
        // Look for second largest value
        if (value == theArray[largestIndex]) {
            int tempLargest = theArray[0];
            for (int i=1; i<nItems;i++) {
                if (theArray[i] > tempLargest) {
                    largestIndex = theArray[i];
                }
            }
            largestIndex = tempLargest;
        }

        nItems--;
        return true;
    } // boolean delElem(int)

    public int howMany() {

        /*
         * Number of items in array.
         */

        return nItems;
    } // int howMany()

    public int getLargest() {

        /*
         * Remove the largest value.
         */

        int tempValue = theArray[largestIndex];

        // Get next largest;
        for (int i=largestIndex; i<SIZE-1; i++) {
            theArray[i] = theArray[i+1];
        }

        nItems--;
        int tempL = theArray[0]; // compare largest
        for (int i=1; i <nItems; i++) {
            if (theArray[i] > tempL) {
                tempL = i;
            }
        }

        largestIndex = tempL;
        return tempValue;

    } // int getLargest()

    public void deleteDups() {
        for (int i=0; i<nItems; i++) {
            for (int j=i+1;j<SIZE-2;j++) {
                if (theArray[i] == theArray[j]) {
                    System.out.println("Found duplicate: " + theArray[j]);
                    theArray[j] = theArray[j+1];
                }
            }
        }
    }

    public boolean find(int value) {

        /*
         * Linear Search.
         */

        for (int val: theArray)
            if (value == val)
                return true; // found
        return false; // not found

    } // boolean find(int)

    public void curElems() {

        /*
         * Display the current elements in array.
         */

        for (int val: theArray)
            System.out.print(val + " ");

    } // void curElems()

    public boolean isEmpty() {

        /*
         * Check if array is empty.
         */

        return (nItems == 0);
    } // boolean isEmpty()

    public static void main(String[] args) {

        ArrayClass theArray = new ArrayClass();
        theArray.addElem(3);
        theArray.addElem(4);
        theArray.addElem(2);
        theArray.addElem(5);
        theArray.addElem(3);

        theArray.curElems();
        theArray.deleteDups();

        theArray.curElems();

    } // void main(String[])

} // class ArrayClass
