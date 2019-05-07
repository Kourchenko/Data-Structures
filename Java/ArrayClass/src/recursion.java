/**
 * Created by diegok on 5/3/17.
 */
public class QuickSort {


    public void quickSort(int[] arr, int length) {
        recQuickSort(arr, 0, length-1);

    }   // void quickSort(arr, length)

    public int recQuickSort(int[] a, int first, int last) {
        if (first >= last) {
            System.out.println("Error!");
            return a.length;
        }
        int index = partition(a, first, last);


        System.out.println("Partitioning around... " + (index-1));
        return index;

    }   // int recQuiciSort(a, first, last)

    void swap(int[]arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }   // void swap(arr, a, b)

    public int partition(int[] a, int first, int last) {
        int p = first;
        int pivotElement = a[first];

        for (int i = 0; i < last; i++) {
            if (a[i] <= pivotElement) {
                p++;
                swap(a, i, p);
            }
        }

        swap(a, p, first);
        return p;
    }   // int partition(a, first, last)

}   // class recursion
