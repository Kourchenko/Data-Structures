
class Link<T> {


    /**
     * Link
     */

    private Link next;
    private int value;


    Link(int val) {
        value = val;
        next = null;
    }   // Constructor Link(char n)

    public void setNext(Link n) {
        next = n;
    }   // boolean setNext(Link n)

    public int getValue() {
        return value;
    }   // T getValue()

    public Link getNext() {
        return next;
    }   // Link<T> getNext()



}   // Class Link

