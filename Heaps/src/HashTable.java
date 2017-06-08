public class HashTable {

    /***************************************************************************************
     *
     * Lab 6
     * Author: Diego Kourchenko
     * File: HashTable.java
     * Date: 21.05.2017
     *
     *
     *
     *
     * Implements an associative array to map keys to values, including
     *      a hash function to compute an index where the element will be inserted
     *      in an array.
     *
     ****************************************************************************************/

    /*
        Instance Variables
     */
    private DataItemInt[] hashArray;
    private double loadFactor;      // scales with number of items in array
    private int arraySize;           // Size of array
    private int numItems;            // items in array
    private DataItemInt nonItem;        // for removed items

    /* Constructor */
    HashTable(int size) {
        arraySize = size;
        numItems = 0;
        loadFactor = 0.0;
        hashArray = new DataItemInt[arraySize];
        nonItem = new DataItemInt(-1);

        // Initialize all locations to null
        for (int i = 0; i < arraySize; i++) {
            hashArray[i] = null;
        }

    }   // Constructor HashTable

    private int hashFunction(int value) {
        /**
         * Hash function for integers.
         * Hashes to an index position inside
         * the boundaries, 0-arraySize.
         *
         * Return integer hashed.
         */
        return value % arraySize;
    }   // int hashFunction(int value)

    private void rehash() {

        /**
         * Create a new Hash Table
         * when table reaches half capacity.
         *
         * Copy all values to new, larger Hash Table.
         */

        // Create an array double the size
        DataItemInt[] tempArray = new DataItemInt[arraySize*2];

        // Copy all elements
        for (int i = 0; i < numItems; i++) {
            // Do not add null pointers or items that are not present, such as non-items
            if (hashArray[i] != nonItem && hashArray[i] != null) {

                // Hash the index
                int index = hashFunction(hashArray[i].getValue());

                // Create DataItem
                DataItemInt tempItem = new DataItemInt(hashArray[i].getValue());

                // Store the DataItem in hashed index position
                tempArray[index] = tempItem;
            }

        }

        // Assign hashArray to point to new location
        // Double size of array
        hashArray = tempArray;
        arraySize *= 2;

        // Reset load factor
        loadFactor = numItems/arraySize;

    }   // void rehash()

    public void addValue(int value) {

        /**
            Hash the integer value,
            call function
            rehash()
            if array is half full.
         */

        // Load Factor rehashes when array is half full
        if (loadFactor > 0.5) {
            rehash();

            // not full, add new DataItem
            int index = hashFunction(value);
            DataItemInt temp = new DataItemInt(value);

            while (hashArray[index] != null && (hashArray[index] != nonItem)) {
                index++;
                index %= arraySize;
            }

            // insert data item and increment count
            // loadFactor increments by percent full array
            loadFactor += (numItems / arraySize);
            hashArray[index] = temp;
            numItems++;
        }

        // not full, add new DataItem
        int index = hashFunction(value);
        DataItemInt temp = new DataItemInt(value);

        while (hashArray[index] != null && (hashArray[index] != nonItem)) {
            index++;
            index %= arraySize;
        }

        // Insert data item and increment count
        // loadFactor increments by percent full array
        hashArray[index] = temp;
        numItems++;
        loadFactor += (numItems / arraySize);


    }   // void addValue(value)

    public boolean removeValue(int value) {

        /**
         * Remove the integer value.
         * Hashes to where the value should appear,
         *
         * Sets index to a deleted, nonItem,
         * else returns false.
         */

        // get a starting index
        int index = hashFunction(value);
        // Look at value in this group
        // continue looking until probing ends

        while (hashArray[index] != null) {

            if (hashArray[index].getValue() == value) {
                // mark that location as not there
                // decrement the count and return found
                hashArray[index] = nonItem;
                numItems--;
                return true;
            }
            // hash again and look again there
            // run through the same hashing code from hashFunction
            index++;
            index %= arraySize;
        }

        return false;    // if not removed
    }   // boolean removeValue(value)

    public boolean findValue(int value) {
        /**
         * Find the value in the Hash Table array.
         *
         * Hashes value and looks for it within that range.
         * Return true if found,
         * else false.
         */

        // get a starting index
        int index = hashFunction(value);

        while (hashArray[index] != null) {
            if (hashArray[index].getValue() == value) {
                return true;        // if found
            }

            // run through hashFunction again
            index++;
            index %= arraySize;
        }

        return false;    // if not found
    }   // boolean findValue(value)

    public String displayTable() {
        /**
         * Find all values in the HashTable,
         * and return a string containing all values.
         */

        // Hold String values
        String stringStream = "";

        // Set String width, for pretty print...
        int strWidth = 5;

        System.out.println();

        for (int i = 0; i < arraySize; i++) {

            if (strWidth < 1) {
                stringStream += '\n';
                strWidth = 5;
            }

            if (hashArray[i] == null) {
                stringStream += "\n*****\n";
                strWidth--;
            }

            else if (hashArray[i] == nonItem) {
                stringStream += " \"dele\" " ;
                strWidth--;

            } else {
                stringStream += hashArray[i].getValue() + " ";
                strWidth--;

            }

        }

        return stringStream;
    }   // String displayTable()

} // Class HashTable()
