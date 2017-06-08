public class ChainHash {

    /********************************************************************************
     * File: ChainHash.java
     * Author: Diego Kourchenko
     * Created: 05.21.2017
     *
     * Hash Table ChainHash uses "chaining" to resolve collisions.
     *
     *******************************************************************************/

    /*
        Instance Variables
    */

    private static int SIZE = 10;
    private DataItemList[] linkedHashArray;         // Data Item is Linked List
    private double loadFactor;
    private int arraySize;
    private int nItems;
    private DataItemList nonItem;
    private final static int R = 31;                // For Hashing strings

    // Default Constructor
    ChainHash() {
        arraySize = SIZE;
        nItems = 0;
        loadFactor = 0.0;
        linkedHashArray = new DataItemList[arraySize];          // Create new Hash Table of size, arraySize
        nonItem = new DataItemList(new LinkedList());           // Deleted items. Initializes to empty linked list.

        // Initialize an empty Hash Table
        for (int i=0; i<arraySize; i++) {
            linkedHashArray[i] = null;
        }

    }   // Constructor ChainHash()

    private int hashFunction(String str) {
        /**
         * Hash function for Strings.
         */

        int hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = (R*hash + str.charAt(i)) % arraySize;
        }

        return hash;
    }   // int hashFunction(String)

    private void rehash() {
        /**
         * Load Factor reaches > 0.5, array is half full,
         * Create new array of doubled size,
         * copy everything over, not including deleted items or null.
         */

        DataItemList[] tempArray = new DataItemList[arraySize*2];

        // Copy all non-null and non-empty items in hash table
        for (int i = 0; i<arraySize; i++) {
            if (linkedHashArray[i] != null && linkedHashArray[i] != nonItem) {

                // Hold the linked list at hashed index
                LinkedList tempList = linkedHashArray[i].getLinkedList();

                // All items in the linked list hashed to the same hash
                // So, get the top value and hash it into new, larger array

                int index = hashFunction(linkedHashArray[i].getLinkedList().peek().getData());

                DataItemList tempItem = new DataItemList(tempList);
                tempArray[index] = tempItem;
            }

        }

        // Point hashArray to new, larger, array
        // Double the array
        linkedHashArray = tempArray;
        arraySize*=2;
        loadFactor = nItems/arraySize;

    }   // void rehash()

    public void addValue(String str) {
        /**
         * Hash the String value
         * rehash if needed.
         */

        // Array is half full
        if (loadFactor > 0.5) {
            // Hash all values and copy into larger array
            rehash();

            // Insert String at index
            int index = hashFunction(str);

            // Linked List does not exist
            // Initialize new linked list at index
            if (linkedHashArray[index] == null) {
                LinkedList linkedList = new LinkedList();
                linkedList.addHead(str);
                linkedHashArray[index] = new DataItemList(linkedList);
            } else {

                linkedHashArray[index].getLinkedList().addHead(str);
            }

            nItems++;
            loadFactor = (nItems / arraySize);

        } else {
            int index = hashFunction(str);

            // Linked List does not exist
            // Initialize new linked list at index
            if (linkedHashArray[index] == null) {
                LinkedList linkedList = new LinkedList();
                linkedList.addHead(str);
                linkedHashArray[index] = new DataItemList(linkedList);
            } else {
                // Linked List exists, add to it
                linkedHashArray[index].getLinkedList().addHead(str);
            }

            nItems++;
            loadFactor = (nItems / arraySize);
        }

    }   // void addValue(String)

    public boolean removeValue(String str) {

        /**
         * Remove the String value.
         * Hashes to where the value should appear,
         *
         * Sets index to a deleted, nonItem,
         * else returns false.
         */

        // Get a starting index
        int index = hashFunction(str);

        if (linkedHashArray[index] != null && linkedHashArray[index] != nonItem) {
            LinkedList linkedList = linkedHashArray[index].getLinkedList();
            // Check for empty Linked List
            if (!linkedList.isEmpty()) {
                boolean found = linkedList.findRemove(str);

                if (found) {
                    nItems--;
                    // Did we remove all values in linked list?
                    if (linkedList.isEmpty()) {
                        linkedHashArray[index] = nonItem;

                    }
                }
                return found;
            }
        }

        // Not removed, not found
        return false;

    }   // boolean removeValue(String)

    public boolean findValue(String str){
        /**
         * Search for String in hash Table.
         */

        // Find a starting index point.
        int index = hashFunction(str);

        if (linkedHashArray[index] != null && linkedHashArray[index] != nonItem) {
            return linkedHashArray[index].getLinkedList().findValue(str);
        }

        return false;
    }   // boolean findValue(String)

    public String displayTable() {
        /**
         *  Return a string containing all hash table values.
         */

        String stringStream = "";

        if (nItems == 0) {
            return "";
        }

        for (int i=0; i<arraySize; i++) {

            if (linkedHashArray[i] == nonItem) {
                stringStream += "\"dele\"";
            }

            if (linkedHashArray[i] == null) {
                stringStream += "*****\n";
            } else {
                stringStream += linkedHashArray[i].getLinkedList().display();
                stringStream += "\n";
            }
        }

        return stringStream;
    }   // String displayTable()

}   // ChainHash()
