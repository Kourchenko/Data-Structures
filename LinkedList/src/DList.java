/**
 * Created by diegok on 5/7/17.
 */
public class DList {

    List list = new List();


    public void addTail(int value) {

        list.addTail(value);
    }   // void addTail(value)


    public boolean removeHead() {
        /*
            Remove head if head is not null,
            Else return false;
         */

        try {
            if (list.head == null) {                // Not going to return anything
                throw new NullPointerException();
            }

            list.removeHead();                      // Return head
            return true;

        } catch (NullPointerException e) {
            System.out.println("underflow_error");
            return false;
        }

    }   // boolean removeHead()

}
