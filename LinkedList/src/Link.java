
public class Link {

    /**
     * Double Ended Link
     */

    private Link next;
    private char value;
    private Link prev;


    Link(char n) {
        value = n;
        next = null;
        prev = null;
    }   // Constructor Link(char n)

    public boolean setNext(Link n) {
        next = n;
        return true;
    }   // boolean setNext(Link n)

    public boolean setPrev(Link n) {
        prev = n;
        return true;
    }   // boolean setPrev(Link n)
<<<<<<< HEAD
=======


>>>>>>> Sandbox
    public char getValue() {
        return value;
    }   // char getValue()

    public Link getNext() {
        return next;
    }   // Link getNext()

    public Link getPrev() {
        return prev;
    }   // Link getPrev()

}   // Class Link
