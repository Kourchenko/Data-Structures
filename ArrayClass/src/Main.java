
import sun.rmi.runtime.Log;

import java.util.Random;

public class Main {

    public int SIZE;
    public static final int MAX = 100;
    private static ArrayClass arrayTwo;

    public static void main(String[] args) {

        try {


            ArrayClass data_hundred = new ArrayClass();
            System.out.format("Size of array data_hundred is: %d \n\n", data_hundred.howMany());


            // Lets prove all methods work on a smaller data set
            /*
             * START: ArrayClass data_n
             */

            ArrayClass data_n = new ArrayClass(10);
            System.out.format("Size of array data_n is: %d\n", data_n.howMany());


            // addElem(int n)
            int add_element = 12;
            System.out.format("Adding %d to data_n at position %d... \n", add_element, data_n.howMany());
            data_n.addElem(add_element);


            /*
             * Use isListed() method to check that the element was added AFTER addElem()
             */

            if (data_n.isListed(add_element)) {
                System.out.println("Element is in the array!\n");
                System.out.println("Next available position will be at index: " + data_n.howMany());

            } else {
                System.out.println("Element is not found... Check addElem() to ensure it adds \n");
                System.out.println("\n");
                System.out.println("Here is what is in the array...");
                data_n.curElems();
            }

            // END: ArrayClass data_n testing add element


            // START: testing for creating ArrayClass, Delete all, getLargest, deleteDups, and sorting

            TEST_CONSTRUCTOR();
            TEST_DELETE_ALL();
            TEST_GET_LARGEST();
            TEST_DELETE_DUPS();
            TEST_SORTING();



        } catch (ArrayIndexOutOfBoundsException err) {                  // Broad catch exception (EX: input = -1)
            System.out.println("!!Error... " + err);

        }

    }   // void main()


    public static void TEST_CONSTRUCTOR() {

        /*
         * Test Default Constructor
         *
         */

        ArrayClass arrayOne = new ArrayClass();
        System.out.println("\ntesting default Constructor");
        arrayOne = new ArrayClass();

        fillAndShow(arrayOne);

        System.out.println("testing overflow Constructor");                 // test overloaded constructor
        arrayTwo = new ArrayClass(42);
        fillAndShow(arrayTwo);

    }   // TEST_CONSTRUCTOR()

    public static void TEST_DELETE_ALL() {

        /*
         * Delete All elements in the array
         *
         */

        System.out.println("\ntesting deleting all elements");
        int numDeleted = 0;

        while (arrayTwo.delElem()) {
            numDeleted ++;
        }

        System.out.format("deleted %d and now there are %d \n", numDeleted, arrayTwo.howMany());
        System.out.println("they are:");
        arrayTwo.curElems();

    }   // void TEST_DELETE_ALL()

    public static void TEST_GET_LARGEST() {

        /*
         * Test and show that delete largest works
         * fill array with random numbers
         *
         */

        ArrayClass arrayThree = new ArrayClass(42);
        System.out.println("\ntesting removing largest elements");
        fillAndShow(arrayThree);

        for (int i = 0; i < 5; i++) {
            System.out.format("removed %d\n", arrayThree.getLargest());

        }

        System.out.format("now there are %d elements\n", arrayThree.howMany());
        System.out.println("they are:");
        arrayThree.curElems();

    }   // void TEST_GET_LARGEST()

    public static void TEST_DELETE_DUPS() {

        /*
         * Problem 3
         *
         * Show that remove deleteDups() works
         * Start with new array with known values
         */

        System.out.println("\ntesting remove duplicates");
        ArrayClass arrayThree = new ArrayClass(15);
        arrayThree.addElem(10);
        arrayThree.addElem(12);
        arrayThree.addElem(22);
        arrayThree.addElem(10);
        arrayThree.addElem(22);
        arrayThree.addElem(22);
        arrayThree.addElem(23);
        arrayThree.addElem(45);
        arrayThree.addElem(47);
        arrayThree.addElem(5);
        arrayThree.addElem(22);
        arrayThree.addElem(21);
        arrayThree.addElem(37);
        arrayThree.addElem(33);
        arrayThree.addElem(6);

        System.out.print("starts with ");
        arrayThree.curElems();

        arrayThree.deleteDups();

        System.out.print("\nends with ");
        arrayThree.curElems();

    }   // void TEST_DELETE_DUPS()

    public static void TEST_SORTING() {

        /*
         * Problem 4
         *
         * Utilizing the getLargest() method and calling it on an array
         * - create a new array containing the numbers from the first array
         * - in sorted order
         *
         */

        ArrayClass arrayFour = new ArrayClass(55);
        ArrayClass arrayFourSorted = new ArrayClass(arrayFour.size);

        System.out.println("\nNow testing sorting in main");
        fillAndShow(arrayFour);

        int count = arrayFour.howMany();

        for (int i=0;i<count;i++) {
            arrayFourSorted.addElem(arrayFour.getLargest());
        }

        System.out.println("results for sorted elements: ");
        arrayFourSorted.curElems();

    }   // void TEST_SORTING()

    public static void fillAndShow(ArrayClass arrayClass) {

        /*
         * Fills arrayClass with random integers
         * Displays elements in array
         */

        int value;
        Random random = new Random();

        System.out.format("starts with %d ", arrayClass.howMany());


        value = random.nextInt(1000);

        while (arrayClass.addElem(value)) {
            value = random.nextInt(1000);
        }

        System.out.format("\nends with %d\n", arrayClass.howMany());
        System.out.println("they are:");
        arrayClass.curElems();

    }   // void fillAndShow()

}



