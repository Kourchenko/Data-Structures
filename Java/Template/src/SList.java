public class SList {

    private Link head;
    private Link tail;
    private int nElems;

    SList() {
        head=null;
        tail=null;

    }   // SList()

    public void addHead(int value) {

        /*
            Add to head of list.
         */

        Link newLink = new Link(value);
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


    public void addTail(int value) {

        /*
            Add to tail of list.
         */

        Link newLink = new Link(value);

        if (head == null) {
            head = tail = newLink;
            nElems++;
        }
        else {
            tail.setNext(newLink);
            tail = newLink;
            nElems++;
        }
    }   // void addTail(value)

    public int removeHead() {

        /*
            Pop the head off list.
         */

        try {
            if (head == null) {
                throw new NullPointerException();
            }

            int temp = head.getValue();
            head = head.getNext();
            nElems--;

            if (head == null) {
                head = tail = null;
            }
            return temp;
        } catch (NullPointerException e) {
            System.out.print("underflow_error");
            return -1;
        }
    }   // int removeHead()

    public boolean findValue(int value) {

        /*
            Return true if found, else false.
         */

        Link ptr;

        if (head == null) {                                     // Base case, if not found
            return false;
        }

        if (head.getValue() == value) {                         // Base case, if found
            return true;
        }

        ptr = recFind(value, head.getNext());                   // Recursive call to helper function, recFind()

        return (ptr != null) && (ptr.getValue() == value);

    }   // boolean findValue()

    public Link recFind(int value, Link ptr) {

        /*
            Recursive helper function,
            returns link of value found.
         */

        if (ptr == null) {                                      // Base case, if not found
            return null;

        }

        if (ptr.getValue() == value) {                          // Base case, if found
            return ptr;

        }

        return recFind(value, ptr.getNext());                   // Recursive find of value

    }   // boolean recFind(value, Link)

    public Link findPrev(int value, Link link) {
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
    }   // Link findPrev(value, link)

    public boolean findRemove(int value) {

        /*
            Recursive Find and Remove of value.
         */

        try {
            Link link = head;
            // Check head first
            if (head == null) {
               return false;
            }
            if (head.getValue() == value) {
                head = head.getNext();
                if (head == null) {
                    head = tail = null;
                }
                nElems --;
                return true;
            }

            // Utilize helper functions to find Previous Link & Found Link
            Link prev = findPrev(value, link);
            Link found;

            if (link.getNext() != null) {
                found = recFind(value, link.getNext());             // Look for value, returns null if not found
                if (prev != null) {
                    if (found != null) {                            // If value not found, found would be null
                        prev.setNext(found.getNext());

                        nElems--;
                        return true;
                    }
                    prev.setNext(null);
                    tail = prev;
                    nElems--;
                    return true;
                }
            }

            throw new NullPointerException();                       // Not found

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
                return Integer.toString(head.getValue());
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
        Link next = head;
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

} // Class SList()
