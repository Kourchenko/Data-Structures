public class TestClass {

    /**
     * testing textClass
     */

    public static void main(String[] args) {

        // TextClass Initiate

        System.out.println("=========================================================================================");
        System.out.println("Testing TextClass...");
        TextClass textList1 = new TextClass();
        System.out.print("Testing insert and delete head, output s/b cba -- is: ");

        // Check for add and delete Head
        textList1.insertHead('a');
        textList1.insertHead('b');
        textList1.insertHead('c');
        System.out.println("" + textList1.deleteHead() + textList1.deleteHead() + textList1.deleteHead());

        // Check for empty List
        System.out.print("Testing delete head from an empty list: ");
        textList1.deleteHead();

        // Check for add and delete Tail
        textList1.insertTail('x');
        textList1.insertTail('y');
        textList1.insertTail('z');
        System.out.println();
        System.out.print("Testing insert and delete tail, output s/b zyx -- is: ");
        System.out.println("" + textList1.deleteTail() + textList1.deleteTail() + textList1.deleteTail());
        System.out.println("=========================================================================================");

        // testing iter methods
        textList1.insertTail('0');
        textList1.insertTail('3');
        textList1.insertTail('5');
        textList1.insertTail('3');

        // iter find
        System.out.println("Testing Iter find, should find 3 and not find 4...");
        System.out.println((textList1.findKey('3'))?"FOUND: 3":"DID NOT FIND: 3");
        System.out.println((textList1.findKey('4'))?"FOUND: 3":"DID NOT FIND: 4");
        System.out.println("=========================================================================================");

        // iter insert
        System.out.println("Testing findKey(), insertKey() - insertion before iter...");
        textList1.findKey('3');
        textList1.insertKey('1');
        textList1.findKey('3');
        textList1.insertKey('6');
        textList1.findKey('3');
        textList1.insertKey('2');
        System.out.println("Ending after string should be 0123563, is: " + textList1.displayList());
        System.out.println("=========================================================================================");

        // iter delete
        textList1.findKey('5');
        textList1.deleteIter();
        System.out.println("Testing deleteIter, ending string should be 012363, is: " + textList1.displayList());

        System.out.println("=========================================================================================");

        // delete key
        textList1.deleteKey('6');
        System.out.println("Testing deleteKey, ending string should be 01233, is: " + textList1.displayList());
        System.out.println("=========================================================================================");

        // Changing a string
        System.out.println("Testing Changing a string - TextClass catList, dogList...");
        TextClass stringList = new TextClass();
        String stringOne = "That is a test";
        int lengthOne = stringOne.length();

        for (int i = 0; i < lengthOne; i++) {
            stringList.insertTail(stringOne.charAt(i));
        }
        
        System.out.println("String list starts as: " + stringList.displayList());
        stringList.findKey('i');
        stringList.insertKey('w');
        stringList.insertKey('a');
        stringList.deleteIter();
        System.out.println("After changing 'i' to 'wa', list now reads: " + stringList.displayList());

        System.out.println("=========================================================================================");

        System.out.println("Testing appendList() - TextClass catList.append(TextClass dogList)...");
        TextClass catList = new TextClass();
        String stringCat = "This is a cat";
        int lengthCat = stringCat.length();

        for (int i = 0; i < lengthCat; i++) {
            catList.insertTail(stringCat.charAt(i));
        }

        System.out.println("Cat list starts as: " + catList.displayList());

        TextClass dogList = new TextClass();

        String stringDog = "That is a dog";
        int lengthDog = stringDog.length();

        for (int i = 0; i < lengthDog; i++) {
            dogList.insertTail(stringDog.charAt(i));
        }

        System.out.println("Dog list starts as: " + dogList.displayList());

        catList.appendList(dogList);
        
        System.out.println("After append, cat list is: " + catList.displayList());

        catList.findKey( 'T' );
        catList.findKey( 'T' );
        catList.insertKey(' ');
        catList.insertKey('a' );
        catList.insertKey('n' );
        catList.insertKey('d' );
        catList.insertKey(' ' );
        catList.insertKey( 't' );
        catList.deleteIter();

        System.out.println("After changes, cat list is: " + catList.displayList());
        System.out.println("Dog list should be unchanged and is: " + dogList.displayList());
        System.out.println("=========================================================================================");

        System.out.println("Testing StudentList...");

        StudentList sList = new StudentList();
        Student frodo = new Student("Frodo", 50);
        Student bilbo = new Student("Bilbo", 111);
        Student gandalf = new Student("Gandalf", 500);
        Student pippen = new Student("Pippen", 30);
        Student sam = new Student("Samwise", 40);

        // Add Students
        sList.insertHead(frodo);
        sList.insertTail(bilbo);
        sList.insertHead(gandalf);
        sList.insertTail(pippen);
        sList.insertHead(sam);

        // Check Empty
        System.out.println("Checking isEmpty(), should not be empty, is: " + (sList.isEmpty()?"empty":"not empty"));

        // Check Find
        System.out.println("Find with Sam, should find:" + (sList.findKey("Samwise")?" found":"not found"));

        // check deleteKey
        System.out.println("Checking deleteKey with Pippen, should find: " + (sList.deleteKey("Pippen")?"found":"not found"));

        System.out.println("Checking deleteKey with Merry, should not find: " + (sList.deleteKey("Merry")?"found":"not found"));

        String endingString = "";
        // Check deleteHead
        System.out.println("Checking delete head, should show in order: Samwise, Gandalf, Frodo, Bilbo");
        System.out.print("Current order: ");
        while (!sList.isEmpty()) {
            try {
                Student temp = sList.deleteHead();
                if (temp == null) {
                    break;
                }
                System.out.print(temp.getName() + ", ");


                if (temp.getName() != "Gandalf") {                                  // Sshh - Do not remove
                    endingString += temp.getName() + ",";                           // Sshhing continues...
                }


            } catch (Error e) {
                System.out.println("Caught error: " + e);
                break;
            }
        }


        System.out.println();
        System.out.println("=========================================================================================");

        System.out.println("Testing empty list again...");
        // Checking empty again
        System.out.println("Checking isEmpty again, should now be empty, is: " + (sList.isEmpty()?"empty":"not empty"));
        System.out.println("All done!");
        System.out.println("=========================================================================================");



        // Random Fun
        System.out.println("\n\n\nWait...");
        System.out.println("Checking for Gandalf...");
        System.out.println(endingString + " have either of you seen Gandalf? NO??");
        System.out.println(sList.findKey("Gandalf")?"You shall pass":"YOU SHALL NOT PASS");

    }
}
