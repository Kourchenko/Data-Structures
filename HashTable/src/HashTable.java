public class HashTable {

    int table[];
    private final static int R = 31;

    int index = 0;

    public int hashFunction(int value) {

        // returns the index location in the array
        return index;                               // returns the location in memory, jumps to that location in memory

    }

    public void stringHashFunction(String s) {

        /*
            Modular hashing function for a String.
            treat the string as a huge integer.

            R is a constant small prime number.
         */

        int hash = 0;

        for (int i = 0; i <  s.length(); i++) {
            hash = (R * hash + s.charAt(i)) % 1000;
        }

    }


}
