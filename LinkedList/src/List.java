public class List {

    /*
      Double Ended Linked List
      Access to Head and Tail
     */

    Link head, tail;

    List() {
        head = tail = null;

    }   // List()

    void addHead(int v) {
        /*
            Create new Link containing value, int v
            insert it at the head of the List
         */
        char x = (char) v;                  // convert: int -> char
        if (head == null) {
            head = tail = new Link(x);

        } else {
            head = new Link(x);
        }
    }   // void addHead(int v)

    boolean find(int v) {

        /*
            Remove true if the List contains
            a Link with value v

            O(1) search
         */

        // Empty List
        if (head == null) {
            return false;
        }

        // Not Empty List; walk down list to find
        Link ptr = head;

        while (ptr != null) {
            if (ptr.getValue() == v) {
                return true;                    // Found
            }

            ptr = ptr.getNext();
        }

        // Not Empty List
        return false;                           // Not found
    }   // boolean find(int v)

    int removeHead() {

        /*
            Remove Link at head of List
            return value it contains

            O(1) remove
         */

        try {

            // Emtpy List
            if (head == null) {
                throw new NullPointerException();
            }

            // Not Empty List; remove value at head
            int temp = head.getValue();         // Found
            Link ptr = head;

            // Head is now next value
            head = head.getNext();
            if (head == null) {                 // Only one element remained before removehead
                tail = null;                    // No elements
            }

            return temp;

        } catch (NullPointerException e) {
            System.out.println("!Error! removeHead()... " + e.getCause());
            return -1;
        }
    }   // int removeHead()

    boolean deleteItem(int v) {

        /*
            Look for link containing v
            if found, delete and return value
            else return false

            O(N) delete
         */

        // Empty List
        if (head == null) {
            return false;
        }

        // Not Empty List

        // Check if first link is the element
        if (head.getValue() == v) {                 // Found
            Link temp = head;
            head = head.getNext();
            if (head == null) {                     // Only one Link in list
                tail = null;
            }

        }

        // Not first element
        // Walk down list
        Link ptr = head.getNext();
        Link last = head;

        while (ptr != null) {                       // Begin search
            if (ptr.getValue() == v) {              // Found
                last.setNext(ptr.getNext());        // Point ptr.prev to link right of ptr link
                if (last.getNext() == null) {       // Was ptr the last link?
                    tail = last;                    // Move tail backward one
                }                                   // Not last element, do nothing to tail
                return true;                        // Found

            }                                       // Not found, still in while-do loop

            last = ptr;
            last = last.getNext();
        }

        // Not found
        return false;
    }   // boolean deleteItem(int v)

    void addTail(int v) {

        /*
            Create new Link containing value v
            insert tail
            special case empty list
         */
        char x = (char) v;
        if (head == null) {
            head = tail = new Link(x);
        }

        Link temp = new Link(x);
        tail.setNext(temp);
        tail = temp;

    }   // void addTail(int v)


    public boolean linearFind(int x) {

        int theArray[] = new int[10];
        int deleteIndex = 0;
        int nElems = 0;
        boolean ifFound = false;

        for (int i = 0; i<theArray.length; i++) {
            if (theArray[i] == x) {
                deleteIndex = theArray[i];
                ifFound = true;
            }
        }

        for (int i=deleteIndex; i<nElems; i++) {
            theArray[i] = theArray[i+1];
        }
        theArray[nElems--] = 0;
        return ifFound;
    }   // boolean linearFind(int x)
}
