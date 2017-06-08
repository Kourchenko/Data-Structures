class Queue {


    /**
     * File: Queue.java
     * Author: Diego Kourchenko
     *
     * Queue - Data Structure
     */

    /* Instance Variables */
    private final int SIZE = 20;
    private int[] queArray;
    private int front;
    private int rear;

    /* Default Constructor */
    Queue() {
        queArray = new int[SIZE];
        front = 0;
        rear = -1;
    } // Default

    public void insert(int j) {
        if (rear == SIZE-1) {
            rear = -1;
        }

        queArray[++rear] = j;

    }   // push(int j)

    public int remove() {
        int temp = queArray[front++];
        if (front == SIZE) {
            front = 0;
        }
        return temp;
    }   // int remove()

    public boolean isEmpty() {
        return (rear+1==front || front+SIZE-1==rear);

    }   // boolean isEmpty()

} // Class Queue
