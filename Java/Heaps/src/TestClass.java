public class TestClass {
    private static int NUM_VALUES = 10;
    private static String dots = "....................................";

    // Load the Heap Pile
    public static void main(String[] args) {
        System.out.println('\n' + dots+dots);

        int values[] = {10, 5, 30, 15, 20, 40, 60, 25, 50, 35};
        String string_values[] = {"dog", "god", "cat", "act", "horse", "cow", "elephant", "otter", "seal", "ales"};

        System.out.println("Testing Heap");
        Heap pile = new Heap();
        for (int i = 0; i < NUM_VALUES; i++) {
            pile.addValue(values[i]);
        }

        System.out.println("Min val root heap s/b: 5 10 30 15 20 40 60 25 50 35");
        System.out.println("The heap actually is: " + pile.display());

        // Remove values
        System.out.println("In order s/b: 5 10 15 20 25 30 35 40 50 60");
        System.out.print("Actual order: ");
        for (int i = 0; i < NUM_VALUES; i++) {
            System.out.print(pile.removeValue() + " ");
        }

        System.out.println();
        System.out.println("\nDone with Heap Test.");
        System.out.println('\n' + dots+dots);


        System.out.println("Testing Priority Queue");

        PQueue theQueue = new PQueue(NUM_VALUES);
        for (int i = 0; i < NUM_VALUES; i++) {
            theQueue.addValue(values[i]);
        }

        System.out.println("In order should s/b: 5 10 15 20 25 30 35 40 50 60");
        System.out.print("Actual order: ");

        for (int i = 0; i < NUM_VALUES; i++) {
            System.out.print(theQueue.removeValue() + " ");
        }

        System.out.println();
        System.out.println("\nDone with Priority Queue Test");
        System.out.println('\n' + dots+dots);

        HashTable intHash = new HashTable(6);

        // place 10 items in a 6 item array, after rehashing
        // the array should expand and not throw an error
        try {
            for (int i = 0; i < NUM_VALUES; i++) {
                intHash.addValue(values[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Inserting failed with overflow: " + e.getMessage());
        }

        // Dump the array
        System.out.println("Display int the array before find and delete");
        System.out.println(intHash.displayTable());

        System.out.println("here...");

        // now see if find works
        System.out.println("Looking for 4, should not find -- " + (intHash.findValue(4)?" found":" not found"));
        System.out.println("Looking for 5, should find -- " + (intHash.findValue(5)?" found":" not found"));

        // now delete 5 and see if it works
        System.out.println("Deleting 5, should work -- " + (intHash.removeValue(5)?" found":" not found"));

        // now look again
        System.out.println("Looking for 5 again, should not find -- " + (intHash.findValue(5)?" found":" not found"));

        System.out.println("Display the array after deleting 5, s/b replaced with \"dele\"");
        System.out.println(intHash.displayTable());

        System.out.println("Done with Integer Hash Table");

        System.out.println('\n' +dots+dots);


        System.out.println("Testing String Hash");
        StringHash stringHash = new StringHash();

        // place 10 items in hash table
        try {
            for (int i = 0; i < NUM_VALUES; i++) {
                stringHash.addValue(string_values[i]);

            }

        } catch(StackOverflowError e) {
            System.out.println("Inserting failed with overflow: " + e);
        }

        // dump the array
        System.out.println(stringHash.displayTable());

        // now see if find works

        // now delete otter and see if still found
        System.out.println("Deleting pig, should not work -- " + (stringHash.removeValue("pig")?" found":" not found"));
        System.out.println("Deleting otter, should work -- " + (stringHash.removeValue("otter")?" found":" not found"));

        // now look again
        System.out.println("Deleting otter, should not work -- " + (stringHash.removeValue("otter")?" found":" not found"));

        System.out.println();
        System.out.println("Displaying the array after deleting otter, s/b replaced with \"dele\"");
        System.out.println(stringHash.displayTable());

        System.out.println("\n" + dots+dots);

        System.out.println("Testing Chain Hash Table");
        ChainHash chainHash = new ChainHash();

        try {
            for (int i=0; i < NUM_VALUES; i++) {
                chainHash.addValue(string_values[i]);
            }
        } catch (StackOverflowError e) {
            System.out.println("Inserting failed with overflow: " + e);
        }

        // Dump the array
        System.out.println("Displaying the array before find and delete");
        System.out.println(chainHash.displayTable());

        System.out.println("Looking for pig, should not find -- " + (chainHash.findValue("pig")?" found":" not found"));
        System.out.println("Looking for otter, should not find -- " + (chainHash.findValue("otter")?" found":" not found"));

        System.out.println("Deleting otter, should not work -- " + (chainHash.removeValue("otter")?" found":" not found"));

        System.out.println("Looking for otter, should not find -- " + (chainHash.findValue("otter")?" found":" not found"));

        System.out.println("Displaying the array after deleting otter, s/b replaced with \"dele\"");
        System.out.println(chainHash.displayTable());

    }
}   // TestClass()
