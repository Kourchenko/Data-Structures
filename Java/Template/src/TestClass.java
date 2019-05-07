/**
 * ====================================================================================================================
 * Author: Diego Kourchenko
 * Lab 4 - Recursion
 * Date: 2017.05.07
 *
 * File: TestClass.java
 *
 * Implements Double-Ended Linked List TemplateSList<T> Class
 * Implements Double-Ended Linked List SList Class
 * Implements QuickSort Class
 * Implements power() method for finding exponents
 *
 * ====================================================================================================================
 */

public class TestClass {

    private static int SIZE = 10;
    // ==== SList theList; ====
    private SList theList = new SList();
    // ==== SList theList; ====

    // === TemplateSList intList ===
    private TemplateSList<Integer> intList = new TemplateSList<>();
    // === TemplateSList intList ===


    // === TemplateSList intList ===
    String[] values = new String[SIZE];
    private TemplateSList<String> stringList = new TemplateSList<>();
    // === TemplateSList intList ===


    // === Median ===
    private int[] array1 = new int[0];
    private int[] array2 = {1, 5, 2, 8, 0, 4, 7, 3, 6, 9};
    private int median;
    // === Median ===


    public static void main(String[] args) {

        TestClass TEST = new TestClass();

        System.out.println("===============================================================");
        System.out.println("===============================================================");
        System.out.println("Testing Double-Ended Singly-Linked List");
        System.out.println("===============================================================");
        TEST.linkedAddHeadTest();
        System.out.println("===============================================================");
        TEST.linkedAddTailTest();
        System.out.println("===============================================================");
        TEST.linkedFindValueTest();
        System.out.println("===============================================================");
        TEST.linkedFindRemoveTest();
        System.out.println("===============================================================");

        System.out.println("===============================================================");
        System.out.println("Testing integer template list ");
        System.out.println("===============================================================");
        TEST.templateIntAddHead();
        System.out.println("===============================================================");
        TEST.templateIntAddTail();
        System.out.println("===============================================================");
        TEST.templateIntFindValue();
        System.out.println("===============================================================");
        TEST.templateIntFindRemove();
        System.out.println("===============================================================");

        System.out.println("===============================================================");
        System.out.println("Testing string template list ");
        String[] values = {"alpha", "beta", "gamma", "delta", "epsilon", "zeta", "eta", "theta", "iota", "kappa"};
        System.out.println("===============================================================");
        TEST.templateStringAddHead(values);
        System.out.println("===============================================================");
        TEST.templateStringAddTail(values);
        System.out.println("===============================================================");
        TEST.templateStringFindValue();
        System.out.println("===============================================================");
        TEST.templateStringFindRemove();
        System.out.println("===============================================================");

        System.out.println("===============================================================");
        System.out.println("Testing exponent function");
        System.out.println("===============================================================");
        TEST.powerTest();
        System.out.println("===============================================================");

        TEST.findMedianTest();

    }   // void main(String[] args)

    /*
     * =============================== TEST ================================
     *                      Double-Ended Singly-Linked List
     * =============================== START ===============================
     */


    public void linkedAddHeadTest() {

        System.out.println("Testing Head addHead");
        System.out.println("output should be 9 8 7 6 5 4 3 2 1 0");
        System.out.print("followed by Caught Error ");

        for (int i=0; i<SIZE; i++) {
            theList.addHead(i);
        }


        String displayString = "";
        int setWidth = 4;

        while (!theList.isEmpty()) {
            try {
                if (setWidth == 0) {
                    displayString = "\n";
                    setWidth = 4;
                }
                displayString += theList.removeHead() + " ";
                setWidth--;

                if (theList.isEmpty()) {
                    System.out.println(displayString);
                    throw new NullPointerException();
                }
            } catch (NullPointerException e) {
                System.out.println("Caught Error: " + theList.hasHead());
                break;
            }
        }
    }   // void linkedAddHeadTest()

    public void linkedAddTailTest() {
        System.out.println("Adding to Tail");

        for (int i=0; i<SIZE;i++) {
            theList.addTail(i);
        }
    }   // void linkedAddTailTest();

    public void linkedFindValueTest() {
        System.out.println("Testing findValue");

        System.out.println("Looking for 20, shoud not find: " + (theList.findValue(20)?"found":"not found"));
        System.out.println("Looking for 8, should find: " + (theList.findValue(8)?"found":"not found"));

    }   // void linkedFindValueTest()

    public void linkedFindRemoveTest() {
        System.out.println("Testing findRemove");

        System.out.println("Removing 15, should not find: " + (theList.findRemove(15)?"found":"not found"));
        System.out.println("Removing 6, should find: " + (theList.findRemove(6)?"found":"not found"));

        System.out.println("===============================================================");
        System.out.println("Now displaying rest of list");
        System.out.println("output should be 0 1 2 3 4 5 7 8 9");
        System.out.println("followed by Caught Error: ");

        String displayString = "";
        int setWidth = 4;

        while (!theList.isEmpty()) {
            try {
                if (setWidth == 0) {
                    displayString += "\n";
                    setWidth = 4;
                }
                displayString += theList.removeHead() + " ";
                setWidth--;

                if (theList.isEmpty()) {
                    System.out.println(displayString);
                    throw new NullPointerException();
                }
            } catch (NullPointerException e) {
                System.out.println("Caught Error: " + theList.hasHead());
                break;
            }
        }
    }   // void linkedFindRemoveTest()

    /*
     * =============================== END ================================
     *                      Double-Ended Singly-Linked List
     * =============================== TEST ===============================
     */


    /*
     * =============================== TEST ================================
     *                               Template - Integer
     * =============================== START ===============================
     */


    public void templateIntAddHead() {

        System.out.println("Testing addHead");
        System.out.println("output should be 9 8 7 6 5 4 3 2 1 0");
        System.out.println("followed by Caught Error: " );

        for (int i=0; i<SIZE; i++) {
            intList.addHead(i);
        }

        String displayString = "";
        int setWidth = 4;

        while (!intList.isEmpty()) {
            try {
                if (setWidth == 0) {
                    displayString += "\n";
                    setWidth = 4;
                }
                displayString += intList.removeHead() + " ";
                setWidth--;

                if (intList.isEmpty()) {
                    System.out.println(displayString);
                    throw new NullPointerException();
                }
            } catch (NullPointerException e) {
                System.out.println("Caught Error: " + intList.hasHead());
                break;
            }
        }
    }   // void templateIntAddHead()

    public void templateIntAddTail() {
        System.out.println("Adding to tail");

        for (int i=0; i<SIZE;i++) {
            intList.addTail(i);
        }
    }   // void templateIntAddTail()

    public void templateIntFindValue() {
        System.out.println("Testing findValue");
        System.out.println("Looking for 20, should not find: " + (intList.findValue(20)?"found":"not found"));
        System.out.println("Looking for 8, should find: " + (intList.findValue(8)?"found":"not found"));

    }   // void templateIntFindValue()

    public void templateIntFindRemove() {
        System.out.println("Testing findRemove");
        System.out.println("Remove 15, should not find: " + (intList.findValue(15)?"found":"not found"));
        System.out.println("Remove 8, should find: " + (intList.findValue(8)?"found":"not found"));

        System.out.println("Now displaying the rest of the list");
        System.out.println("output should be 0 1 2 3 4 5 7 8 9");
        System.out.println("followed by Caught Error: ");

        String displayString = "";
        int setWidth = 4;

        while (!intList.isEmpty()) {
            try {
                if (setWidth == 0) {
                    displayString += "\n";
                    setWidth = 4;
                }
                displayString += intList.removeHead() + " ";
                setWidth--;

                if (intList.isEmpty()) {
                    System.out.println(displayString);
                    throw new NullPointerException();
                }
            } catch (NullPointerException e) {
                System.out.println("Caught Error: " + intList.hasHead());
                break;
            }
        }

    }   // void templateIntFindRemove()

    /*
     * =============================== END  ================================
     *                               Template - Integer
     * =============================== TEST  ===============================
     */

    /*
     * =============================== TEST ================================
     *                               Template - String
     * =============================== START ===============================
     */

    public void templateStringAddHead(String[] values) {


        System.out.println("Testing addHead");
        System.out.println("output should be kappa iota theta eta zeta epsilon delta gamma beta alpha");
        System.out.println("followed by Caught Error: " );

        for (int i=0; i<SIZE; i++) {
            stringList.addHead(values[i]);
        }

        String displayString = "";
        int setWidth = 4;

        while (!stringList.isEmpty()) {
            try {
                if (setWidth == 0) {
                    displayString += "\n";
                    setWidth = 4;
                }
                displayString += stringList.removeHead() + " ";
                setWidth--;

                if (stringList.isEmpty()) {
                    System.out.println(displayString);
                    throw new NullPointerException();
                }
            } catch (NullPointerException e) {
                System.out.println("Caught Error: " + stringList.hasHead());
                break;

            }
        }

    }   // void templateStringAddHead()

    public void templateStringAddTail(String[] values) {
        System.out.println("Adding to tail ");

        for (int i=0; i<SIZE;i++) {
            stringList.addTail(values[i]);
        }
    }   // void templateStringAddTail()

    public void templateStringFindValue() {
        System.out.println("Testing findValue");
        System.out.println("Looking for psi, should not find: " + (stringList.findValue("psi")?"found":"not found"));
        System.out.println("Looking for gamma, should find: " + (stringList.findValue("gamma")?"found":"not found"));

    }   // void templateStringFindValue()

    public void templateStringFindRemove() {
        System.out.println("Testing findRemove");
        System.out.println("Remove tau, should not find: " + (stringList.findValue("tau")?"found":"not found"));
        System.out.println("Remove epsilon, should find: " + (stringList.findValue("gamma")?"found":"not found"));

        System.out.println("===============================================================");
        System.out.println("Now displaying the rest of the list");
        System.out.println("output should be alpha beta gamma delta zeta eta theta iota kappa");
        System.out.println("followed by Caught Error: ");

        String displayString = "";
        int setWidth = 4;

        while (!stringList.isEmpty()) {
            try {
                if (setWidth == 0) {
                    displayString += "\n";
                    setWidth = 4;
                }
                displayString += stringList.removeHead() + " ";
                setWidth--;

                if (stringList.isEmpty()) {
                    System.out.println(displayString);
                    throw new NullPointerException();
                }

            } catch (NullPointerException e) {
                System.out.println("Caught Error: " + stringList.hasHead());
                break;

            }

        }

    }   // void templateStringFindRemove()

    /*
     * =============================== END  ================================
     *                               Template - String
     * =============================== TEST ================================
     */

    /*
    * =============================== TEST ================================
    *                                 Power
    * =============================== START ===============================
    */

    public int power(int base, int exp) {
        // Define Recursively

        if (exp % 2 == 1) {                             // exp is odd, multiply by base to include base^1
            return power(base*base, exp/2)*base;
        }

        if (exp < 1) {
            return 1;
        }

        return power(base*base, exp/2);

    }   // int power(base, exp)


    public void powerTest() {
        System.out.println("2 ^ 0 should be 1 -- is " + power(2, 0));
        System.out.println("3 ^ 5 should be 243 -- is " + power(3, 5));
        System.out.println("2 ^ 10 should be 1024 -- is " + power(2, 10));
        System.out.println("2 ^ 8 should be 256 -- is " + power(2, 8));
    }

    /*
     * =============================== END ================================
     *                                 Power
     * =============================== TEST ===============================
     */

    /*
     * =============================== START ===============================
     *                                 Median
     * =============================== TEST ================================
     */


    public void findMedianTest() {
        try {
            QuickSort qSort = new QuickSort();

            System.out.println("Testing an array of length 0, should throw underflow exception ");
            median = qSort.findMedian(array1, 0, median);
            System.out.println("The median was " + median);
            System.out.println("Testing an array of the first 10 ints, median should be 5 ");
            median = qSort.findMedian(array2, SIZE, median);
            System.out.println("The median was " + median);
            System.out.println("Testing an array of first 9 ints, median should be 4 ");
            median = qSort.findMedian(array2, SIZE-1, median);
            System.out.println("The median was " + median);

        } catch(NullPointerException e) {
            System.out.println("Caught error: " + e.toString());
        }

    }   // int findMedian(array, size, median)

    /*
     * =============================== END =================================
     *                                 Median
     * =============================== TEST ================================
     */

}
