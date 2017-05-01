
/*
 * ====================================================================================================================
 * Lab 3
 *
 * File TextClass.java
 * Author: Diego Kourchenko
 * Author Date: 2017.04.17
 *
 * Create text processing class using Double Ended Linked List.
 *
 * ====================================================================================================================
 * Double Ended Linked List has access to:
 * - Link Head - Start of Linked List
 * - Link Tail - End of Linked List
 * - Link iter - Last found location of Linked List(N)
 * - int nElems - Integer value, number of elements in Linked List
 * ====================================================================================================================
 * O(1) Insertion from Head and/or Tail
 * O(1) Deletion from head and/or Tail
 *
 * O(N) Insertion into middle of Links
 * O(N) Deletion into middle of Links
 * O(N) Search for char(n)
 * ====================================================================================================================
 * Constructor: TextClass()
 * - Link head
 * - Link tail
 * - Link iter
 *
 * ====================================================================================================================
 * Implements the following methods:
 * - void insertHead(char val)
 * - void insertTail(char val)
 * - char deleteHead()
 * - char deleteTail()
 * - boolean findKey(char key)
 * - boolean insertKey(char key)
 * - boolean deleteIter()
 * - boolean deleteKey(char val)
 * - boolean isEmpty()
 * - String displayList()
 * - void appendList(TextClass list2)
 *
 * ====================================================================================================================
 */

import java.util.EmptyStackException;

public class TextClass {
    /**
     * Text processing Class
     * - Creates a Double Linked List of Chars
     * - void insertHead(char val)
     * - void insertTail(char val)
     * - char deleteHead()
     * - char deleteTail()
     * - boolean findKey(char key)
     * - boolean insertKey(char key)
     * - boolean deleteIter()
     * - boolean deleteKey(char val)
     * - boolean isEmpty()
     * - String displayList()
     * - void appendList(TextClass list2)
     */

    // FIELDS
    private Link head;
    private Link tail;
    private Link iter;
    private int nElems;

    TextClass() {
        head = null;
        tail = null;
        iter = null;
        nElems = 0;
    }   // Constructor TextClass()

    public void insertHead(char val) {
        /*
         * Insert a link containing val at head of list.
         * - head.prev = newLink
         * - newLink.next = head
         * - head = newLink
         * Simple.
         */

        Link newLink = new Link(val);
        if (head == null) {                             // No Link(s) exist
            head = newLink;                             // Head points to newLink
            tail = newLink;                             // Tail points to newLink
            nElems++;
        }
        else {                                          // Insertion is not at first link
            head.setPrev(newLink);
            newLink.setNext(head);                      // Point newLink.next -> head
            head = newLink;                             // newLink is now at the head (front of all Link(s))
            nElems++;
        }
    }   // void addHead(char val)

    public void insertTail(char val) {

        /*
         * Insert a link containing link val at end of the list
         * - newTail.prev = tail
         * - tail.next = newTail
         * - tail = newTail
         */

        Link newTail = new Link(val);

        if (tail == null) {                             // No Link(s) exist
            head = newTail;
            tail = newTail;
            nElems++;
        } else {                                        // At least one Link
            tail.setNext(newTail);
            newTail.setPrev(tail);
            tail = newTail;
            nElems++;
        }
    }   // void addTail(char val)

    public char deleteHead() {

        /*
         * Remove head of Linked List
         */

        try {
            if (head == null) {                         // No Link(s)
                throw new EmptyStackException();
            } else {
                Link temp = head;
                head = head.getNext();                  // Move head position right one place
                if (head == null) {                     // Deleted only Link in list, head.next = null
                    tail = null;                        // reset head, reset tail
                }
                return temp.getValue();
            }
        } catch (EmptyStackException e) {
            System.out.print("Caught error: " + e);
            return '\0';

        }
    }   // void deleteHead()

    public char deleteTail() {

        /*
         * Remove tail of Linked List
         */

        try {
            if (tail == null) {                         // No Link(s)
                throw new EmptyStackException();
            } else {
                Link temp = tail;
                tail = tail.getPrev();                  // Move tail position left one place
                if (tail == null) {                     // Deleted only Link in list, tail.prev = null
                    head = null;                        // reset tail, reset head
                }
                return temp.getValue();
            }
        } catch (EmptyStackException e) {
            System.out.print("Caught error: " + e);
            return '\0';
        }
    }   // void deleteTail()

    public boolean findKey(char key) {

        /*
         * Return true if Key(val) is in LinkedList
         * Keeps a reference to last found char val and finds the next one, if it exists
         * Return false if either of these don't happen
         *
         * O(N) Search
         */

        boolean hasBeenFound = false;

        if (head == null) {                                                  // No Link(s), you'll find nothing here...
            return false;
        }

        Link next = head;                                                   // Start search at head

        if ((iter != null) && (iter.getValue() == key)) {                   // iter has been found and currently pointing to it
            hasBeenFound = true;
            next = iter.getNext();                                          // start search after iter
        }

        while ((hasBeenFound) || (next != null)) {                          // We have found it or we start at the head
            if (next == null) {
                next = head;
            }
            if (next.getValue() == key) {                                   // Found
                iter = next;
                return true;
            }
            next = next.getNext();                                          // Not found, shift to next Link
        }

        if (iter.getValue() != key) {                                       // Reset iter, set to null
            iter = null;
        }

        return false;
    }   // boolean findKey(char key)

    public boolean insertKey(char val) {

        /**
         * Insert key just before iter
         * If iter doesn't exist, return false
         * If iter exists, create a link and insert just before iter
         *
         * O(1) insertion
         */


        if (head == null) {                                                 // No Link(s)
            return false;
        }

        if (iter != null) {
            Link newLink = new Link(val);
            if (iter.getPrev() != null) {
                iter.getPrev().setNext(newLink);
                newLink.setNext(iter);
                newLink.setPrev(iter.getPrev());
                iter.setPrev(newLink);
                return true;
            }
        }
        return false;

    }   // boolean insertKey(char val)

    public boolean deleteIter() {

        /*
         * Delete the first link that contains the key
         * Return true if value
         * Else return false
         *
         * O(N) delete
         */

        Link next = head;

        if (next == null) {                                                 // No Link(s)
            return false;
        }

        if (iter != null) {
            next = iter;
        }

        while ((iter != null) && (next != null)) {
            if (next.getValue() == iter.getValue()) {                       // Found iter to delete
                Link tmpPrev = next.getPrev();
                Link tmpNext = next.getNext();

                if (tmpPrev == null) {                                      // HEAD
                    head = tmpNext;                                         // move head forward on delete iter
                    next.getNext().setPrev(null);
                    return true;
                } else if (tmpNext == null) {                               // TAIL
                    tail = tmpPrev;                                         // move tail backward on delete iter
                    next.getPrev().setNext(null);
                    iter = null;
                    return true;
                } else {                                                    // elsewhere
                    next.getPrev().setNext(next.getNext());                 // next.prev.next = next.next
                    next.getNext().setPrev(next.getPrev());                 // next.next.prev = next.prev
                    iter= null;                                             // reset iter, set null
                    return true;
                }
            } else {                                                        // Not found
                next = next.getNext();
            }
        }
        return false;
    }   // boolean deleteKey()

    public boolean deleteKey(char key) {

        Link next = head;

        while (next != null) {
            if (next.getValue() == key) {
                Link tmpPrev = next.getPrev();
                Link tmpNext = next.getNext();

                if (tmpPrev == null) {              // HEAD
                    head = tmpNext;
                    next.getNext().setPrev(null);
                    return true;
                } else if (tmpNext == null) {       // TAIL
                    tail = tmpPrev;
                    next.getPrev().setNext(null);
                    iter = null;
                    return true;
                } else {
                    next.getPrev().setNext(next.getNext());
                    next.getNext().setPrev(next.getPrev());
                    iter= null;
                    return true;
                }
            } else {
                next = next.getNext();
            }
        }
        return false;
    } // boolean deleteKey()

    public boolean isEmpty() {
        /*
         *   Return if List is Empty.
         */

        return (nElems==0);

    }   // boolean isEmpty()

    public String displayList() {

        /*
         * Return a string containing the values in the list,
         * Head -> Tail
         */

        String displayString = "";
        Link next = head;

        if (head == null) {
            return displayString;
        }

        while (next != null) {
            displayString += "" + next.getValue();
            next = next.getNext();
        }

        return displayString;
    }   // String displayString()

    public void appendList(TextClass list2) {

        /*
         * Join two TextClass lists together
         */

        Link next = list2.head;

        while (next != null) {
            insertTail(next.getValue());
            next = next.getNext();
        }
    }   // void appendList(TextClass list2)

}   // Class TextClass


