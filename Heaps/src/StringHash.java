public class StringHash {

    /**
     * String Hash Table
     * - implements a string hashFunction(String value)
     * - wherein it treats every string like a really large integer.
     */

    // Fields
    private static int SIZE = 10;           // Constant SIZE
    private DataItemString[] hashArray;     // Array of type DataItemString[]
    private double loadFactor;              // Check if array is half full
    private int arraySize;
    private int numItems;
    private DataItemString nonItem;         // Deleted Items are special case, nonItem
    private final static int R = 31;        // Hashing, smallest prime number

    // Constructor
    StringHash() {
        arraySize = SIZE;
        numItems = 0;
        loadFactor = 0.0;
        hashArray = new DataItemString[arraySize];
        nonItem = new DataItemString("");

        for (int i = 0; i < arraySize; i++) {
            hashArray[i] = null;

        }
    }   // StringHash(size)

    private int hashFunction(String str) {
        /*
            String hashing function.
            Treat every string like a
            really large integer.
         */
        int hash = 0;

        for (int i = 0; i < str.length(); i++) {
            hash = (R*hash + str.charAt(i)) % arraySize;
        }

        return hash;

    }   // int hashFunction(str)

    private void rehash() {
        DataItemString[] tempArray = new DataItemString[arraySize*2];
        for (int i = 0; i < numItems; i++) {
            // Do not add null pointers or items that are not present, such as non-items
            if (hashArray[i] != nonItem && hashArray[i] != null) {

                int index = hashFunction(hashArray[i].getValue());

                DataItemString tempItem = new DataItemString(hashArray[i].getValue());
                tempArray[index] = tempItem;

            }

        }

        hashArray = tempArray;
        arraySize *= 2;
        loadFactor = numItems/arraySize;

    }   // void rehash()

    public void addValue(String value) {

        /*
            Hash the String value,
            call function
            rehash()
            if array is half full.
         */

        // Load Factor rehashes when array is half full
        if (loadFactor > 0.5) {
            rehash();

            // not full, add new DataItem
            int index = hashFunction(value);
            DataItemString temp = new DataItemString(value);

            while (hashArray[index] != null && (hashArray[index] != nonItem)) {
                index++;
                index %= arraySize;
            }

            // insert data item and increment count
            // loadFactor increments by percent full array
            hashArray[index] = temp;
            numItems++;
            loadFactor += (numItems / arraySize);
        } else {
            // not full, add new DataItem
            int index = hashFunction(value);
            DataItemString temp = new DataItemString(value);

            while (hashArray[index] != null && (hashArray[index] != nonItem)) {
                index++;
                index %= arraySize;
            }

            // insert data item and increment count
            // loadFactor increments by percent full array
            hashArray[index] = temp;
            numItems++;
            loadFactor += (numItems / arraySize);

        }

    }   // void addValue(value)

    public boolean removeValue(String value) {

        // get a starting index
        int index = hashFunction(value);
        // Look at value in this group
        // continue looking until probing ends

        while (index != arraySize-1) {

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

    public boolean findValue(String value) {

        // get a starting index
        int index = hashFunction(value);

        while (index != arraySize-1) {
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

        /*
            Return a string containing all values in hash table.
         */

        String stringStream = "";

        // Set String width, for pretty print...
        int strWidth = 5;

        for (int i = 0; i < arraySize; i++) {
            if (strWidth < 1) {
                stringStream += '\n';
                strWidth = 5;
            }

            if (hashArray[i] == null) {
                stringStream += "\n*****\n";
                strWidth--;

            } else if (hashArray[i] == nonItem) {
                stringStream += "\"dele\" ";
                strWidth--;
            } else {
                stringStream += hashArray[i].getValue() + " ";
                strWidth--;
            }
        }

        return stringStream;
    }   // String displayTable()


}   // Class StringHash

