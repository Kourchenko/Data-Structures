public class LinkedList {

    /**
     * Singly-Linked Linked List
     */

    // FIELDS
    private Link head;
    private int nItems;

    // Constructor
    LinkedList() {
        head = null;
        nItems = 0;
    }   // Constructor LinkedList()

    public void addHead(String str) {
        /*
            Push new Link to the front.
         */

        Link newNode = new Link(str);

        // No Links in Linked List
        if (head == null) {
            head = newNode;
            nItems++;
        }

        // Push new node to front
        else {

            newNode.setNext(head);
            head = newNode;
            nItems++;
        }
    }   // void addHead(String)

    public Link removeHead() {

        /*
            Pop off head Link.
         */

        try {
            if (head == null) {
                throw new NullPointerException("Empty List");
            }

            Link temp = head;
            head = head.getNext();
            nItems--;

            return temp;
        } catch (NullPointerException e) {
            return null;
        }

    }   // Node removeHead()

    public boolean findValue(String str) {

        /*
            Find String, return true
            Else, return false.
         */

        if (head == null) {
            return false;
        }

        Link ptr = head;
        while (ptr != null) {
            if (ptr.getData().equals(str)) {
                // Found
                return true;
            }
            // Continue searching
            ptr = ptr.getNext();
        }

        // Not found;
        return false;
    }   // boolean findValue(String)

    public boolean findRemove(String str) {
        if (head == null) {
            return false;
        }
        if (head.getData() == str) {
            head = head.getNext();
            nItems--;
            return true;
        }

        Link ptr = head.getNext();
        // Check all Links
        while (ptr.getNext() != null) {
            if (ptr.getNext().getData() == str) {
                ptr.setNext(ptr.getNext().getNext());
                nItems--;
                return true;
            } else {
                ptr = ptr.getNext();
            }
        }

        return false;
    }

    public Link pop(String str ) {
        /*
            Find value and pop it off.
         */

        if (head == null) {
            return null;
        }

        Link ptr = head;
        if (head.getData().equals(str)) {

            head = null;
            nItems--;
            return ptr;
        }

        // Use Recursion
        return popRecursive(ptr, str);

    }   // void pop()

    private Link popRecursive(Link next_ptr, String str) {

        /*
            Recursive Helper function.
         */

        if (next_ptr.getNext() == null) {
            return null;
        }

        // Hold previous Node ptr
        Link prev_ptr = next_ptr;

        if (next_ptr.getNext().getData().equals(str)) {
            prev_ptr.setNext(next_ptr.getNext());               // Point previous Node->next.next Node
            return next_ptr;
        }
        return popRecursive(prev_ptr, str);                     // Track previous Node ptr

    } // Node popRecursive(Node, String)

    public Link peek() {
        try {

            if (head == null) {
                throw new NullPointerException("Empty List.");

            } else {

                return head;
            }

        } catch (NullPointerException e) {
            System.out.println(" :underflow_err");
            return null;
        }

    }   // Link peek()


    public boolean isEmpty() {
        return (nItems==0);
    } // boolean isEmpty()

    public String display() {
        /*
            Return a string containing all values in list.
         */
        String stringStream = "";

        if (head == null) {
            return stringStream;

        }

        Link ptr = head;

        while (ptr != null) {
            stringStream += ptr.getData() + " ";
            ptr = ptr.getNext();
        }

        return stringStream;

    }   // String display()

    public static void main(String[] args) {

        LinkedList LS = new LinkedList();
        LS.addHead("cat");
        LS.addHead("dog");
        LS.addHead("person");


        System.out.println("\nDisplaying list...");

        System.out.println(LS.display());

        LS.findRemove("dog");

        System.out.println(LS.display());
    }

}

class Link {

    /**
     * Node
     * - string: Holds String data type
     * - next: Holds Node data type
     */

    private String string;
    private Link next;

    // Constructor
    Link(String str) {
        string = str;
        next = null;
    }   // Link()

    public void setNext(Link node) {
        next = node;
    }
    public String getData() {
        return string;
    }

    public Link getNext() {
        return next;
    }

}   // Class Node
