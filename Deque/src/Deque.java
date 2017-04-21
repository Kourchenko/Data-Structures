import java.lang.reflect.Array;
import java.util.EmptyStackException;


/*
 *  ===================================================================================================================
 *  Diego Kourchenko - Lab 2
 *
 * File: Deque.java
 * Author: Diego Kourchenko
 * Create Data: 2017.04.14
 *
 * Double-Ended Queue
 * Create a type of Queue:
 *  Access is possible from the left or right of the array
 *
 * Stack:
 * - insertLeft()
 * - removeLeft()
 *
 * Queue:
 * - insertLeft()
 * - removeRight()
 *  ===================================================================================================================
 *
 *  EDIT: 2017.19.17
 *  - insertLeft() - Wrote in O(1) time
 *  - insertRight() - Wrote in O(1) time
 *  - leftElems() - better written to deal with O(1) time on insertLeft()
 *  - rightElems() - better written to deal with O(1) time on insertRight()
 *
 *  ===================================================================================================================
 */

public class Deque {

    /*
     * Problem 1
     *
     * Double-ended Queue
     *  - Deque() - Initialize array of size 100
     *  - Deque(int N) - Initialize array of size N
     *  - insertLeft() - insert to left of all elements
     *  - insertRight() - insert to right of all elements
     *  - removeLeft() - remove left-most element
     *  - removeRight() - remove right-most element
     *  - isEmpty() - return true if Empty
     *  - isFull() - return true if Full
     *
     * Throwable Exceptions
     * Case 1: OverFlowError - throws error if array is full
     * Case 2: UnderFlowError - throws error if array is empty
     *
     */

    // FIELDS
    private int[] queArray;
    private static int SIZE = 100;                                          // Constant Variable
    private int nElems;
    private int left;
    private int right;
    private String[] errorsArray = new String[100];
    private int errors = 0;


    Deque() {

        /*
         * Default Constructor initialize to 100 elements
         */

        nElems = 0;
        left = SIZE-1;
        right = 0;

        queArray = new int[SIZE];

    }   // Constructor Deque()

    Deque(int N) {

        /*
         * Overloaded Constructor initialize to n elements
         */

        SIZE = N;
        nElems = 0;
        left = SIZE-1;
        right = 0;

        queArray = new int[SIZE];

    }   // Constructor Deque(int N)

    public void insertLeft(int value) {

        /*
         * Insert to left-most position in array.
         * Shift all elements right
         *
         * If isFull()
         * Then throw: StackOverFlowError()
         *
         */

        try {
            if (nElems + 1 <= SIZE) {                                   // New Element will fit in array

                queArray[left--] = value;                               // Move pointer to the left after inserting value
                nElems++;
                if (left == right) {                                    // tail meets head, we have serviced all elements
                    left = SIZE-1;                                      // Reset when left (TAIL) meets right (HEAD)
                }

            } else {                                                    // Dequeue SIZE is met
                throw new StackOverflowError();

            }

        } catch (StackOverflowError e) {
            System.out.println("Overflow Error insertLeft()... ");

        }

    }   // boolean insertLeft()

    public void insertRight(int value) {

        /*
         * Append element to right of all elements
         * O(1) insertion
         */

        try {
            if (nElems + 1 <= SIZE) {                                   // New element will fit in dequeue

                queArray[right++] = value;                              // Right (head) is set to new value, then pointer is moved
                if (right == left) {
                    right = 0;
                }
                nElems++;

            } else {                                                    // Dequeue SIZE is met
                throw new StackOverflowError();
            }

        } catch (StackOverflowError e) {
            System.out.println("Overflow Error insertRight()...");

        }

    } // boolean insertRight()


    public int removeLeft() {

        /*
         * Remove left most element - END of line
         * O(1) removals
         */

        try {
            if (nElems > 0) {                                           // Elements are available to remove

                nElems--;
                if (left == SIZE) {                                     // Left (rear) has ended
                    left = -1;                                          // Loop around
                }

                return queArray[++left];

            } else {                                                    // No Elements in queue array
                throw new ArrayIndexOutOfBoundsException();

            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Underflow Error removeLeft()... " + e);
            return -1;

        }

    }   // int removeLeft()

    public int removeRight() {

        /*
         * Remove right most element - HEAD of line
         * O(1) removals
         */

        try {
            if (nElems > 0) {                                           // Elements are available to remove

                nElems--;
                if (right == 0) {                                       // Right (HEAD) has changed
                    right = SIZE;                                       // Loop around to left (tail)
                }
                return queArray[--right];

            } else {                                                    // No elements in queue array
                throw new EmptyStackException();

            }

        } catch (EmptyStackException e) {
            System.out.print("Underflow Error removeRight()...");
            return -1;
        }

    } // int removeRight()

    public boolean isEmpty() {

        /*
         * Check if no elements in array
         * i.e. array is empty
         *
         */

        return (nElems == 0);

    } // boolean isEmpty()

    public boolean isFull() {

        /*
         * Check if number of elements equals size,
         * i.e. array is full
         *
         */

        return (nElems == SIZE - 1);

    } // boolean isFull()

    public String rightElems() {

        /*
         * Return a string containing elements from right to left
         */

        String displayString = "";
        int tmpnElems = nElems;                                         // Dummy variable holds number of elements
        int tmpRight = right - 1;                                       // Dummy variable holds position of right-most element

        while (tmpnElems > 0) {                                         // Print number of elements
            if (tmpRight < 0) {                                         // Reached start of array
                tmpRight = SIZE - 1;                                    // Check end of array, check TAIL

            }

            displayString += queArray[tmpRight] + " ";
            tmpnElems--;
            tmpRight--;
        }

        return displayString;                                           // sudo man help - No manual entry for bad comments

    }   // String rightElems()

    public String leftElems() {

        /*
         * Return a string containing elements from left to right
         */

        String displayString = "";


        int tmpnElems = nElems;                                         // Dummy variable holds number of elements
        int tmpLeft = left + 1;                                         // Dummy variable holds position of left-most element

        while (tmpnElems > 0) {                                         // Print number of elements
            if (tmpLeft == SIZE) {                                      // Reached end of array, still more elements
                tmpLeft = 0;                                            // Check start of array, check HEAD
            }
            displayString += queArray[tmpLeft] + " ";
            tmpLeft++;
            tmpnElems--;

        }

        return displayString;

    }   // String rightElems()

    public String curElems() {

        /*
         * List elements from array
         * the first element is at the removeLeft() position
         * the last element is at the removeRight() position
         * If the array is empty, return empty string
         *
         */

        String displayString = "";

        for (int i = 0; i < SIZE; i++) {
            displayString += queArray[i] + " ";
        }

        return displayString;

    } // String curElems()

}   // Class Deque.java

