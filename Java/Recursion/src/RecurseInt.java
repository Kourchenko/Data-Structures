import java.util.Arrays;

/**
 * Created by diegok on 4/25/17.
 */
public class RecurseInt {

    int counter = 0;
    // Recursion takes more memory
    // Recursion takes less time

    public int recurseInt(int value) {
        if (value <= 1) {
            return 1;
        } else {

            return value * recurseInt(value - 1);
        }
    }

    public String display() {
        return "";
    }

    public void mergeSort() {
        // mergeSort requires 2 arrays to sort
    }

    public boolean recFind(int value, Link link) {
        if (link == null) {
            return false;
        }
        if (link.value == value) {
            return true;
        }
        return recFind(value, link.next);
    }

    public void merger(int result[], int  arr1[], int arr2[], int length1, int length2) {
        int index1 = 0, index2 = 0, indexRes = 0;

        while ((index1 < length1) && (index2 < length2)) {
            if (arr1[index1] < arr2[index2]) {
                result[indexRes++] = arr1[index1++];
            } else {
                result[indexRes++] = arr2[index2++];
            }
        }

        while (index1 < length1) {
            result[indexRes++] = arr1[index1++];
        }
        while (index2 < length2) {
            result[indexRes++] = arr2[index2++];
        }
    }

    public void mergeSort(int[] array, int length) {
        int sub1 = length / 2;
        int sub2 = length - sub1;

        if (length == 1) {
            return;
        }

        int[] arr1 = new int[sub1];
        int[] arr2 = new int[sub2];

        int index = 0;
        for (int i=0; i < sub2; i++) {




        }
    }

    public void solveTowers(char src, char dst, char mid, int n) {
        if (n==0) {
            return;
        }
        solveTowers(src, mid, dst, n-1);
        System.out.println("Move " + ++counter + ": disk" + " from " + src + " to " + dst);
        solveTowers(mid, dst, src, n-1);

    }
    public static void main(String[] args) {
        System.out.println();

        RecurseInt n = new RecurseInt();
        System.out.println(n.recurseInt(10));

        n.solveTowers('A', 'C', 'B', 4);

        myStructList myStructList = new myStructList();
        myStructList.addHead('3');
        myStructList.addHead('2');

        RecurseInt r = new RecurseInt();
        System.out.println(r.recFind('3', myStructList.head));
        System.out.println(r.recFind('2', myStructList.head));
        System.out.println(r.recFind('1', myStructList.head));


        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {8, 11, 15, 19};

        int arrSize1 = arr1.length;
        int arrSize2 = arr2.length;
        int result[] = new int[arrSize1+arrSize2];

        r.merger(result, arr1, arr2, arrSize1, arrSize2);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");

        }





    }

    // Stack
    // Stack(6)
    // - return int Stack(5)
    // Stack(5)
    // - return int Stack(4)
    // ..

}
