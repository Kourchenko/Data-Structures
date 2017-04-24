
/*
 * ====================================================================================================================
 * Lab 3
 *
 * Author: Diego Kourchenko
 * Author Date: 2017.04.17
 *
 * Create text processing class
 * Allows input of single character at a time
 *
 * input: char value
 * ====================================================================================================================
 */


public class TextClass {
    /**
     * Text processing Class
     * - Creates a Double Linked List of Chars
     *
     * Double Linked List:
     * - char deleteHead()
     * - char deleteTail()
     * - boolean isEmpty()
     * - boolean findKey(char key)
     * - boolean insertKey(char value)
     * - boolean deleteIter()
     * - boolean deleteKey(char key)
     * - string displayList()
     */

    // FIELDS
    private Link head;
    private Link tail;
    private Link iter;
    private int iterPos;
    private int nElems;

    TextClass() {
        head = null;
        tail = null;
        iter = null;
        nElems = 0;
    }   // Constructor TextClass()

    public void addHead(char val) {

        /**
         * Insert a link containing val at head of list.
         * - head.prev = newLink
         * - newLink.next = head
         * - head = newLink
         *
         * Simple.
         */

        Link newLink = new Link(val);               // Create new Link
        if (head == null) {                         // No Link(s) exist
            head = newLink;                         // Head points to newLink
            tail = newLink;                         // Tail points to newLink
            nElems++;
        }

        else {
            head.setPrev(newLink);
            newLink.setNext(head);                  // Point newLink.next -> head
            head = newLink;                         // newLink is now at the head (front of all Link(s))
            nElems++;
        }
    }   // void addHead(char val)

    public void addTail(char val) {

        /**
         * Insert a link containint link val at end of the list
         * - newTail.prev = tail
         * - tail.next = newTail
         * - tail = newTail
         *
         */

        Link newTail = new Link(val);

        if (head == null) {                         // No link(s) exist; create a new Link
            head = newTail;
            tail = newTail;
            nElems++;
        }
        newTail.setPrev(tail);                      // tail <- newLink -> null
        tail.setNext(newTail);                      // tail -> newLink -> null
        tail = newTail;
        nElems++;
    }   // void addTail(char val)

    public boolean findKey(char key) {

        /**
         * Return true if Key(val) is in LinkedList
         * Keeps a reference to last found char val and finds the next one, if it exists
         * Return false if either of these don't happen
         */

        Link next = head;                                                       // Begin search at head Link
        boolean hasFoundBefore = false;                                         // True if iter != null
        if (head == null) {                                                     // Don't begin search, no links
            return false;
        }

        if ((iter != null) && (iter.getValue() == key)) {                       // Key has been found before
            next = iter.getNext();                                              // Perhaps there's another one
            hasFoundBefore = true;                                              // value has been found before
        }

        while ((hasFoundBefore) || (next != null)) {                            // End if hasBeenFound or if reaches end
            if (next == null) {                                                 // If you reach the end, but hasFoundBefore...
                next = head;                                                    // Start search at head
                iterPos = 0;
            }
            if (next.getValue() == key) {                                       // Value found
                iter = next;
                System.out.println("Found at position: " + iterPos);
                iterPos++;
                return true;
            } else {                                                            // Not found, keep going
                next = next.getNext();
                iterPos++;
            }
        }
        iterPos = 0;
        return false;
    }   // boolean findKey(char key)

    public boolean insertKey(char val) {

        /**
         * Insert key just before iter
         * If iter doesn't exist, return false
         * If iter exists, create a link and insert just before iter
         *
         */

        if (head == null) {                         // No Link(s)
            return false;
        }
        Link next = iter;
        boolean hasFoundBefore = false;

        if (iter.getValue() != val) {               // Wait, have we found the key
            hasFoundBefore = findKey(val);          // make sure it points to right place iter -> position of val
        }
        if ((hasFoundBefore) || iter != null)  {                       // it hasFoundBefore
            Link newLink = new Link(val);           // Create new link
            iter.getPrev().setNext(newLink);        // set previous as the next one
            newLink.setNext(iter);                  // set newLink, insertion behind iter, to point to iter
            return true;
        } else {
            return false;
        }
    }   // boolean insertKey(char val)

    public boolean deleteIter() {

        /**
         * Delete iter if it exists.
         *
         */
        
        if (iter != null) {
            iter = null;
            return true;
        }
        return false;
    }   // boolean deleteIter()

    public boolean deleteKey(char val) {

        /**
         * Delete the first link that contains the key
         * Return true if value
         * Else return false
         *
         */

        Link next = head;

        if (next == null) {                         // No Link(s)
            return false;
        }

        int pos = -1;
        while (next != null) {
            pos++;
            if (next.getValue() == val) {
                Link prev = next.getPrev();
                Link tmp = next.getNext();

                if (prev == null) {                 // at head of list
                    head = tmp;
                    tmp.setPrev(null);
                    nElems--;
                    return true;
                } else if (tmp == null) {           // at tail of list
                    tail = prev;
                    prev.setNext(null);
                    nElems--;
                    return true;

                } else {                            // somewhere in the middle
                    prev.setNext(tmp);
                    tmp.setPrev(prev);
                    nElems--;
                    return true;
                }
            } else {
                next = next.getNext();
            }
        }
        return true;
    }   // boolean deleteKey()

    public boolean isEmpty() {
        /**
         * Check if list is empty.
         *
         */

        return (nElems==0);
    }   // boolean isEmpty()

    public String listLinks() {

        /**
         * Return a string containing the values in the list,
         * Head -> Tail
         *
         */

        String displayString = "";
        Link next = head;

        if (head == null) {
            return displayString;
        }

        while (next != null) {
            displayString += next.getValue() + "";
            next = next.getNext();
        }

        return displayString;
    }   // String displayString()

    public void appendList(TextClass list2) {

        /**
         * Join two TextClass lists together
         *
         */

        Link next = list2.head;

        while (next != null) {
            addTail(next.getValue());
            next = next.getNext();
        }
    }   // void appendList(TextClass list2)
}   // Class TextClass
