public class TemplateSList<T> {

    private TLink<T> head;
    private TLink<T> tail;
    private int nElems;

    TemplateSList() {
        head=null;
        tail=null;

    }   // TemplateSList()

    public void addHead(T value) {

         /*
            Add to head of list.
         */

        TLink<T> newLink = new TLink<>(value);
        if (head == null) {
            head = tail = newLink;
            nElems++;
        }
        else {
            newLink.setNext(head);
            head = newLink;
            nElems++;
        }

    }   // void addHead(value)


    public void addTail(T value) {

        /*
            Add to tail of list.
         */

        TLink<T> newLink = new TLink<>(value);
        if (head == null) {
            head = tail = newLink;
            nElems++;
        }
        else {
            tail.setNext(newLink);
            tail = newLink;
            nElems++;
        }
    }   // void addHead(value)

    public T removeHead() {

        /*
            Pop the head off list.
         */

        try {
            if (head == null) {
                throw new NullPointerException();
            }

            T temp = head.getValue();
            head = head.getNext();
            nElems--;

            if (head == null) {
                head = tail = null;
            }

            return temp;
        } catch (NullPointerException e) {
            System.out.print(":underflow_error: ");
            return null;
        }
    }   // T removeHead()

    public boolean findValue(T value) {

        /*
            Return true if found, else false.
         */

        TLink<T> ptr;

        if (head == null) {
            return false;
        }
        if (head.getValue() == value) {
            return true;
        }

        ptr = recFind(value, head.getNext());


        return (ptr != null) && (ptr.getValue() == value);
    }   // boolean findValue()

    private TLink<T> recFind(T value, TLink<T> ptr) {

        /*
            Recursive helper function,
            returns link of value found.
         */

        if (ptr == null) {                              // Base case, if not found
            return null;

        }

        if (ptr.getValue() == value){                   // Base case, if found
            return ptr;

        }

        return recFind(value, ptr.getNext());

    }   // TLink<T> recFind(value, ptr)

    private TLink<T> findPrev(T value, TLink link) {

        /*
            Recursive helper function to find
            the previous link
            before found link.

            Returns link if found,
            Returns null if not found.
         */

        if (link.getNext() != null) {
            if (link.getNext().getValue() == value) {
                return link;
            }

            return findPrev(value, link.getNext());
        }

        return null;

    }   // TLink<T> findPrev(T value, TLink link)


    public boolean findRemove(T value) {

        /*
         * Recursive Find of type T value.
         */

        try {
            TLink<T> link = head;
            // Check head first
            if (head == null) {
                return false;
            }
            if (head.getValue() == value) {
                head = head.getNext();
                if (head == null) {
                    head = tail = null;
                }
                nElems--;
                return true;
            }

            // Utilize helper functions to find Previous Link & Found Link
            TLink<T> prev = findPrev(value, link);
            TLink<T> found;

            if (link.getNext() != null) {
                found = recFind(value, link.getNext());                 // Look for value, returns null if not found
                if (prev != null) {
                    if (found != null) {
                        prev.setNext(found.getNext());                  // If value not found, found would be null
                        nElems--;
                        return true;
                    }
                    prev.setNext(null);
                    tail = prev;
                    nElems--;
                    return true;
                }
            }
            throw new NullPointerException();
        } catch (NullPointerException e) {
            System.out.println("underflow_error");
            return false;
        }
    }   // boolean findRemove(value)

    public boolean isEmpty() {
        /*
            Return true if empty, else false.
         */
        return (nElems==0);
    }   // boolean isEmpty()

    public String hasHead() {

        /*
            Peek at head value.
         */

        try {
            if (head != null) {
                return head.getValue() + "";

            }
            throw new NullPointerException();

        } catch (NullPointerException e) {
            return "underflow_error";

        }

    }   // String hasHead()

    public String display() {

        /*
            Returns a formatted String
            with width of 4 char(s) per line.
         */

        String displayS = "";

        if (head == null ){
            return displayS;
        }
        TLink<T> next = head;
        int formatCount = 4;

        while (next != null) {
            if (formatCount  == 0) {
                displayS += "\n";
                formatCount = 4;
            }
            displayS += next.getValue();
            formatCount --;
            next = next.getNext();
        }
        return displayS;
    }   // String display()

}   // Class TemplateSList

