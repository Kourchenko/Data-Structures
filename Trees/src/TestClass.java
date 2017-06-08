import java.io.*;
import java.util.Scanner;

public class TestClass {

    private static WordTree wordTree = new WordTree();
    private static Tree234 tree234 = new Tree234();
    private static BinarySearchTree BST = new BinarySearchTree();
    private static final String file_name = "diamond_input.txt";
    private static int[] diamondsArr;
    private static int[] taxesArr;

    public static void main(String[] args) throws IOException {

        String dots = "...............................";

        System.out.println('\n' + dots + dots);         // Dotted line separator
        System.out.println("Testing Word Tree");

        String[] wordTreeValues = {"middle", "grape", "apple", "house", "pine", "tree", "never"};

        for (int i = 0; i < wordTreeValues.length; i++) {
            System.out.println("Inserting: " + wordTreeValues[i]);
            wordTree.addValue(wordTreeValues[i]);

        }

        System.out.println();
        System.out.println("In Order Traversal of Word Tree");
        System.out.print('\t');
        wordTree.inOrder();
        System.out.println();

        System.out.println();
        System.out.println("Pre Order Traversal of Word Tree");
        System.out.print('\t');
        wordTree.preOrder();
        System.out.println();

        System.out.println();
        System.out.println("Post Order Traversal of Word Tree");
        System.out.print('\t');
        wordTree.postOrder();
        System.out.println();

        System.out.println();
        System.out.println("Testing find()");
        System.out.println("Find: apple... should find: " + (wordTree.find("apple") ? " Found" : " not Found"));
        System.out.println("Find: middle... should not find: " + (wordTree.find("middle") ? " Found" : " not Found"));
        System.out.println("Find: banana... should not find: " + (wordTree.find("banana") ? " Found" : " not Found"));
        System.out.println("Find: banana... should not find: " + (wordTree.find("banana") ? " Found" : " not Found"));
        System.out.println("Find: banana... should not find: " + (wordTree.find("banana") ? " Found" : " not Found"));
        System.out.println("Find: orange... should find: " + (wordTree.find("orange")?" Found":" not Found... Orange you glad I didn't say banana?"));

        System.out.println('\n' + (dots + dots));         // Dotted line separator

        System.out.println("Testing 2-3-4 Tree");
        System.out.println("Inserting smaller -> larger integers");
        tree234.insert(50);
        tree234.insert(60);
        tree234.insert(70);
        tree234.insert(80);
        tree234.insert(90);
        System.out.println("In Order traversal, should be 50 60 70 80 90 -- is: ");
        tree234.traversalInOrder();

        System.out.println();
        System.out.println("Adding values less than the node, should add to the left.");

        tree234.insert(20);
        System.out.print("Added 20! \nIn Order traversal, should be 20 50 60 70 80 90 -- is: ");
        tree234.traversalInOrder();
        System.out.println();

        tree234.insert(10);
        System.out.print("Added 10! \nIn Order traversal, should be 10 20 50 60 70 80 90 -- is: ");
        tree234.traversalInOrder();
        System.out.println();

        tree234.insert(40);
        System.out.print("Added 40! \nIn Order traversal, should be 10 20 40 50 60 70 80 90 -- is: ");
        tree234.traversalInOrder();
        System.out.println();

        System.out.println('\n' + (dots + dots));         // Dotted line separator

        System.out.println("Testing Binary Tree - Integers");

        int[] values = {60, 30, 40, 50, 70, 90, 80};

        System.out.println("testing insert...");
        for (int i: values) {
            System.out.println("Inserting: " + i);
            BST.insertItem(i);

        }

        System.out.println();

        System.out.println("Finding 30... should find:" + (BST.findItem(30)?" found":" not found"));
        System.out.println("Finding 40... should find:" + (BST.findItem(40)?" found":" not found"));
        System.out.println("Finding 10... should not find:" + (BST.findItem(10)?" found":" not found"));


        System.out.println("Testing delete");
        System.out.println("Delete: 40" + (BST.findDelete(40)?" deleted":" not found"));
        System.out.println("Trying delete again: 40" + (BST.findDelete(40)?" deleted":" not found"));

        System.out.println("findNext after deleting 40: should be 50 -- is: " + BST.findNext(40));
        System.out.println("Delete 60:" + (BST.findDelete(60)? " deleted":" not found"));

        System.out.println("Trying delete again: 60" + (BST.findDelete(60)?" deleted":" not found"));
        System.out.println("findNext after deleting 60: should be 70 -- is: " + BST.findNext(60));


        System.out.println('\n' + dots+dots);
        System.out.println("Testing Dwarf Tax");

        // Read File
        BufferedReader reader = new BufferedReader(new FileReader(file_name));

        // Read and find File
        Scanner scanner = new Scanner(new File(file_name));

        while ((reader.readLine()) != null) {
            BinarySearchTree bstTax = new BinarySearchTree();

            System.out.println(dots + dots);
            System.out.println();
            int nDiamonds = scanner.nextInt();

            if (nDiamonds < 1) {
                System.out.println("\n\n<FAIL> Cannot pay taxes with: " + nDiamonds + " diamonds...");
                break;
            }
            diamondsArr = new int[nDiamonds];

            for (int i = 0; i < nDiamonds; i++) {
                diamondsArr[i] = scanner.nextInt();

            }

            System.out.println("First Diamonds Mined: ");
            for (int e : diamondsArr) {
                System.out.print(e + " ");

            }

            System.out.println();
            int nTaxes = scanner.nextInt();
            taxesArr = new int[nTaxes];

            for (int i = 0; i < nTaxes; i++) {
                taxesArr[i] = scanner.nextInt();

            }

            System.out.println("Current taxes: ");
            for (int e : taxesArr) {
                System.out.print(e + " ");
            }

            System.out.println('\n');

            for (int d: diamondsArr) {
                bstTax.insertItem(d);

            }

            // Keep track of payment
            boolean paid = pay(taxesArr, bstTax);

            if (paid) {
                System.out.println("<PASS> Paid all taxes!");
            } else {
                System.out.println("<FAIL> Could not pay...");
            }

        }

    }   // main()

    public static boolean pay(int[] taxes, BinarySearchTree bst) {

        /**
         * Helper function for paying taxes.
         */

        // Check tax forms and check your bag for a diamond big enough to pay said tax.
        // Uncle Sam is a greedy bitch.
        for (int i : taxes) {

            int found = bst.findNext(i);


            if (found != -1) {
                return bst.findDelete(found);
            } else {
                return false;
            }
        }

        return false;
    }

}   // TestClass()
