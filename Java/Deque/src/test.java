/**
 * Created by diegok on 5/21/17.
 */
public class test {


    int theArray[];
    int size = 20;
    int counter;

    test() {
        theArray = new int[size];
        counter = 0;
    }

    public void add(int value) {
        if (counter != size) {
            theArray[counter++] = value;

        } else {

            // overflow array
            int[] temp = new int[size*2];
            theArray = temp;
            for (int i = 0; i < counter; i++) {
                temp[i] = theArray[i];
            }

            theArray = temp;
            theArray[counter++] = value;
            size *= 2;
            System.out.println("Cannot do it... " + counter + " == " + size);
        }
    }   // void add(value)


    public void swap(int a, int b) {
        // Swap positions
        int temp = theArray[a];
        theArray[a] = theArray[b];
        theArray[b] = temp;
    }

    public static void main(String[] args) {
        test t = new test();
        for (int i = 0; i < 10; i++) {
            t.add(i);
        }
        for (int i: t.theArray) {
            System.out.print(i + " ");
        }

        t.swap(2, 3);

        System.out.println();
        for (int i: t.theArray) {
            System.out.print(i + " ");
        }
    }


}
