public class PQueue {

    /**********************************************************************
     * Priority Queue
     *
     * Implemented utilizing a Heap.
     *
     * If the array reaches max capacity,
     * it copies all values over to an array doubled in size.
     *
     *********************************************************************/

    // FIELDS
    private Heap pQueueHeap;

    // Default Constructor
    PQueue(int size) {
        pQueueHeap = new Heap(size);

    }   // PQueue(size)

    public void addValue(int value) {
        /*
            Add value to Heap
         */

        pQueueHeap.addValue(value);
    }   // void addValue(value)

    public int removeValue() {
        return pQueueHeap.removeValue();

    }   // int removeValue()

    public String display() {
        return pQueueHeap.display();
    }   // String display()

}   // Class PQueue
