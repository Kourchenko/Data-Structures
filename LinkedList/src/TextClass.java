
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


import javax.xml.soap.Text;
import java.util.EmptyStackException;

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
    public Link head;
    public Link tail;
    private Link iter;
    private int nElems;

    TextClass() {
        head = null;
        tail = null;
        iter = null;
        nElems = 0;
    }   // Constructor TextClass()

    public void insertHead(char val) {

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

    public void insertTail(char val) {

        /**
         * Insert a link containing link val at end of the list
         * - newTail.prev = tail
         * - tail.next = newTail
         * - tail = newTail
         *
         */

        Link newTail = new Link(val);

        if (tail == null) {                         // No link(s) exist; create a new Link
            head = newTail;
            tail = newTail;
            nElems++;
        } else {
            tail.setNext(newTail);
            newTail.setPrev(tail);                      // tail <- newLink -> null
            tail = newTail;
            nElems++;
        }
    }   // void addTail(char val)

    public char deleteHead() {

        /**
         * Remove head of Linked List
         */

        try {
            if (head == null) {
                throw new EmptyStackException();
            } else {
                Link temp = head;
                head = head.getNext();
                if (head == null) {
                    tail = null;
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
            if (tail == null) {
                throw new EmptyStackException();
            } else {
                Link temp = tail;
                tail = tail.getPrev();
                if (tail == null) {
                    head = null;
                }
                return temp.getValue();
            }
        } catch (EmptyStackException e) {
            System.out.print("Caught error: " + e);
            return '\0';
        }
    }   // void deleteTail()

    public boolean findKey(char key) {

        /**
         * Return true if Key(val) is in LinkedList
         * Keeps a reference to last found char val and finds the next one, if it exists
         * Return false if either of these don't happen
         */

        boolean hasBeenFound = false;

        // 0 3 5 3
        if (head == null) {                                                  // No Link(s), you'll find nothing here...
            return false;
        }

        Link next = head;

        if ((iter != null) && (iter.getValue() == key)) {
            hasBeenFound = true;
            next = iter.getNext();
        }

        // 0 3 5 3
        while ((hasBeenFound) || (next != null)) {
            if (next == null) {
                next = head;
            }
            if (next.getValue() == key) {
                iter = next;
                return true;
            }
            next = next.getNext();
        }

        if (iter.getValue() != key) {
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
         */


        if (head == null) {                                                 // No Link(s)
            return false;
        }

        // 0 3 5 3
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

        if (iter != null) {
            next = iter;
        }

        while ((iter != null) && (next != null)) {
            if (next.getValue() == iter.getValue()) {
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
    }

    public boolean isEmpty() {
        /**
         * Check if list is empty.
         *
         */

        return (nElems==0);
    }   // boolean isEmpty()

    public String displayList() {

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
            displayString += "" + next.getValue();
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
            insertTail(next.getValue());
            next = next.getNext();
        }
    }   // void appendList(TextClass list2)


    public static void main(String[] args) {


    }

}   // Class TextClass


