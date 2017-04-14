/**
 * ====================================================================================================================
 * Diego Kourchenko - Lab 1
 *
 * File: ArrayClass.java
 * Author: Diego Kourchenko
 * Create Data 2017.04.02
 *
 * Array - Data Type
 * Creates a class of an unordered array to automatically initialize an array
 *  to store 100 elements
 * User has the option to initialize an array of size (int n)
 *
 *
 * (OPTIONAL): int n - size of array
 * Initializes to 100 slots otherwise
 *
 * ====================================================================================================================
 *
 *  EDITS / Debug
 *
 * EDIT: 2017.04.10 SORTING
 *                  - Fixed Issue with Sorting not doing a reverse sort (Proper Sort: LARGEST -> SMALLEST)
 *                  - Issue: Sorting from SMALLEST -> LARGEST using addInFront() to add largest in the back and
 *                  - the rest in position n-1 ... 0
 * EDIT: 2017.04.10 GAPS IN PRINTING
 *                  - Fixed Issue with Console Printing in a more readable format
 *                  - Fixed Issue with printing empty string when empty array
 *
 * ====================================================================================================================
 */


public class ArrayClass {

    /*
            * Problem 1
            *
            * Create a class ArrayClass that demonstrates the following methods:
            * - ArrayClass() - constructor that initializes an array of 100 elements
            * - ArrayClass(int n) - constructor that initializes array of n elements
            * - bool addElem(int n) - adds the integer n to the array at the available location, else false
            * - bool delElem(int n) - deletes the last added element, else false if array is empty
            * - int howMany() - returns the number of elements in the array
            * - string curElems() - returns a string listing the current elements, ten per line
            * - int getLargest() - returns the largest integer and removes it from the array
            * - void deleteDups() - removes all duplicate entries in the array
            *
            * Abstract Data Type - Unordered Array
            * Initialize an array with default size 100
            *
            * Array must have
            *       - get(A,I)
            *       - set(A,I, V)
    */

    // FIELDS
    private int[] arr;
    private int nElements;                          // number of elements in array
    public int size;                                // size of array
    private int largest;                            // store the largest integer in array
    private int addAtEndIndex;

    // BEGIN: Polymorphism Example
    //

    // ArrayClass Constructor
    ArrayClass() {
        this.arr = new int[100];                    // Initialize with size 100
        this.size = 100;                            // arr[0] is the first element, arr[1],... arr[n-1]
        this.addAtEndIndex = 100-1;
    }   // void ArrayClass()

    // Array Class Constructor
    ArrayClass(int n) {
        this.arr = new int[n];                      // Initialize array with size (int n)
        this.size = n;
        this.addAtEndIndex = n-1;

    }   // void ArrayClass(int n)

    // END: Polymorphism Example

    public boolean addElem(int n) {

        /*
         * Add an element to the array size
         * if there is available spaces return true
         * else                         return false
         *
         */

        if (nElements == size) {                    // No Available slots
            return false;

        } else {                                    // Available slots
            set(n);                                 // Utilizes the set() function
            return true;

        }

    }   // boolean addElement(int n)

    public boolean delElem() {
        /*
         * Deletes the last element added,  return true;
         * If the array is empty,           return false.
         */

        if (nElements == 0) {                       // Array hss no elements
            return false;

        } else {                                    // Array has at least 1 element(s) to delete
            arr[nElements-1] = 0;                   // Delete last element
            nElements --;                           // Move nElements counter down

            return true;

        }

    }   // boolean delElem(int n)


    public int howMany() {

        /*
         * Function returns number of elements in array
         */

        return nElements;

    }   // int howMany()

    public int getLargest() {

        /*
         * Problem 2
         *
         * Returns the largest element in the array and removes it from the array
         *
         */

        if (size < 1) {                             // Check if array has elements
            return 0;                               // Array has zero elements

        } else {                                    // Array has at least one element
            largest = arr[0];
            for (int i = 0; i < size; i++) {        // Start a loop to find the biggest
                if (arr[i] > largest) {             // current pointer is larger
                    largest = arr[i];               // assign it as the largest
                }

            }                                       // end for-loop

            int deleteIndex = 0;

            for (int i=0; i<nElements; i++) {
                if (arr[i] == largest) {
                    deleteIndex = i;

                }

            }

            nElements --;                           // move nElements counter back one
            for (int j=deleteIndex; j<nElements; j++) {
                arr[j] = arr[j+1];

            }

            arr[nElements] = 0;
            addAtEndIndex --;

            return largest;                         // finally, return largest element after searching for it
        }

    }   // int getLargest()

    public void curElems() {

        /*
         * Prints all elements of the Integer Array (arr) to Console, 10 per line
         *
         */

        String displayString = "";                      // Display String

        if (nElements > 0) {
            displayString += arr[0] + " ";              // Add the first element first as an example
            for (int i = 1; i < nElements; i++) {
                if ((i + 1) % 10 == 0) {                // Add 10 numbers for 10 lines per print
                    displayString += arr[i] + " ";
                    System.out.println(displayString);  // Print when you get to ten lines
                    displayString = "";

                } else {
                    displayString += arr[i] + " ";      // Else, add to the display string

                }

            }

            System.out.println(displayString);          // Finally print displayString to console
            return;
        }

        System.out.println(displayString);              // empty ArrayClass = empty displayString

    }   // void curElems()

    public void deleteDups() {
        /*
         * Removes any duplicate entries
         *
         */

        for (int i=0; i<nElements; i++) {           // Only searches available nElements
            for (int j=i+1;j<size;j++) {
                if (arr[i] == arr[j]) {
                    arr[j] = 0;                     // Assign 0 to later position
                    nElements--;                    // Remove available nElements
                    continue;                       // Continue deleting elements

                }

            }                                       // end nested for-loop

        }                                           // end outer for-loop

    }   // void deleteDups()

    public boolean isListed(int n) {

        /*
         * Checks if (int n) is listed in the array:
         * return true,
         * return false
         *
         */

        if (size > 0) {                             // Array has elements
            for (int i=0;i<size;i++) {
                if (arr[i] == n) {
                    return true;                    // Element found
                }

            }                                       // end for-loop

        }

        return false;                               // Element not found

    }   // boolean isListed(int n)

    private void set(int n) {

        /*
         * Array by definition requires
         * - set(A,I, V)
         * - A: array
         * - I: position to place element
         * - V: element to add
         *
         */

        if (nElements < size) {                     // Have we reached our limit of available slots? Not yet.
            arr[nElements] = n;                     // No. Then, assign variable at next position
            nElements++;
            addAtEndIndex -= nElements;

            if (n > largest) {                      // set largest value; "do you lift more than me, bro?"
                largest = n;                        // oh, you do...

            }

        } else {                                    // Give the user some input on why errors
            if (nElements == size) {                // Reached limit of available slots
                System.out.format("Not Added... Utilized... (%d / %d) assigned elements, %d slots available... \n", nElements, size, size - nElements);

            } else {                                // Some error occurred
                System.out.println("Error with adding " + n + "at data["+nElements+"]...");

            }

        }

    }   // void set(int n)

    public void addInFront(int n) {

        /*
         * Helper function for getLargest() to add the largest element at the end of the array
         * Adds every other element in front of it
         *
        */

        // [2, 3, 4]
        // addAtEnd(1)
        // [2, 3, 4, 4]
        // [2, 3, 3, 4]
        // [2, 2, 3, 4]
        // 1, 2, 3, 4]

        if (nElements < 1) {
            arr[nElements] = n;
            nElements ++;

        } else {
            for (int i = nElements; i > 0; i--) {   // nElements is 1 less than size; won't overflow
                arr[i] = arr[i-1];                  // Shifts Elements to the next position

            }

            arr[0] = n;                             // new element added at front of list
            nElements++;                            // count for nElements increased

        }

    }   // void addAtEnd()

}

