class DataItemList {

    /******************************************************************************
     * File: DataItemList.java
     * Author: Diego Kourchenko
     * Created: 05.21.2017
     *
     * DataItemList
     * Defines a DataItem for a Linked List.
     * Use with a Hash Table.
     *
     ******************************************************************************/

    /* Instance Varibles */
    private LinkedList linkedList;

    // Default Constructor
    DataItemList(LinkedList list) {
        linkedList = list;
    }   // DataItemList()

    public LinkedList getLinkedList() {
        return linkedList;
    }

}   // Class DataItemList()
