public class Stack {

    /*
     * Problem 2
     *
     * Utilizes Deque methods
     * - insertLeft()
     * - removeLeft()
     *
     * Creates a Stack Data Structure
     *
     * O(1) PUSH: Insertions
     * O(1) POP: Removals
     * O(1) Peek: peeks
     */



    // FIELDS
    private Deque mStack;
    private int size;
    private int nElems;


    Stack() {

        /*
         * Default Constructor initializes to 100 elements
         */

        size = 100;
        mStack = new Deque(size);
        nElems = 0;

    }   // Constructor Stack()

    Stack(int N) {

        /*
         * Overload Constructor initializes to n elements
         */

        size = N;
        mStack = new Deque(N);
        nElems = 0;

    }   // Constructor Stack(int N)

    public void push(int value) {

        /*
         * Use insertLeft() from Deque to push in a new value
         */

        try {
            mStack.insertLeft(value);
            nElems++;

        } catch (StackOverflowError e) {
            System.out.println("StackOverflowError push()...");

        }

    } // void push();

    public int pop() {

        /*
         * Use removeLeft() from Deque to remove the newest value
         */

        try {
            nElems--;
            return mStack.removeLeft();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBounds pop()...");
            return -1;

        }

    }   // int pop()

    public int peek() {

        /*
         * Use removeLeft() and insertLeft() to remove and immediately push newest value
         */

        try {
            int value = mStack.removeLeft();
            mStack.insertLeft(value);

            return value;

        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBounds peek()...");
            return -1;

        }

    }   // int peek()

}   // Class Stack.java
