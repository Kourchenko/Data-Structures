public class TLink<T> {

    /**
     * Template Link.
     * Imput  can be any type T.
     */

    private TLink<T> next;
    private T value;


    TLink(T val) {
        value = val;
        next = null;
    }   // Constructor Link(char n)

    public void setNext(TLink<T> n) {
        next = n;
    }   // boolean setNext(Link n)

    public T getValue() {
        return value;
    }   // T getValue()

    public TLink<T> getNext() {
        return next;
    }   // Link<T> getNext()

}   // Class TLink<T>
