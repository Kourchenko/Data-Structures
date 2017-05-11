public class QuickSort {

    /************************************************************************************************************
        Quick Sort utilizes the partition method, to break an array into smaller portions.
        Partition ensures all elements around a pivot are either less than or greater than the pivot.
     ************************************************************************************************************
     */

    public int findMedian(int theArray[], int length, int median) {

        /*
            Return the value at k-th index.
            The input for this Lab will always be length/2 -- the central point in the list.

            Median can be any k-th index you want.
         */

        median = recFindMedian(theArray, 0, length-1, length/2);

        return median;

    }   // void findMedian(theArray, length, median)

    private int recFindMedian(int theArray[], int first, int last, int kth) {

        /*
            Recursively Find the k-th element in theArray, from first to last.
         */

        int p = partition(theArray, first, last);

        if (p == kth) {                                             // found
            return theArray[p];
        } else if (p < kth) {                                       // undershot our partition guess
            return recFindMedian(theArray, p+1, last, kth);
        } else {                                                    // overshot our partition guess
            return recFindMedian(theArray, first, p-1, kth);
        }

    }   // int recFindMedian(theArray first, last, kth)

    public void quickSort(int[] a, int length) {

        /*
            Helper function.
            Perform recursive quick sort on an array.
         */

        recQuickSort(a, 0, length-1);

    }   // void quickSort(a, length)


    private void recQuickSort(int[] a, int first, int last) {

        /*
            Recursively find the partition of the first and last index.
         */

        if (first < last) {
            int pos = partition(a, first, last);

            recQuickSort(a, first, pos-1);
            recQuickSort(a, pos+1, last);
        }

    }   // void recQuickSort(a, first, last)

    public static void swap(int[] theArray, int a, int b) {


        int temp = theArray[a];
        theArray[a] = theArray[b];
        theArray[b] = temp;

    }   // void swap(a, b)

    public int partition(int[] a, int first, int last) {

        /*
            Partition the array, a,
            until all values larger than the pivot are to the right
            until all values less than the pivot are to the left.
         */

        try {
            int p = first;
            int pivotElement = a[first];
            for (int i = first + 1; i <= last; i++) {

                if (a[i] <= pivotElement) {
                    p++;
                    swap(a, i, p);

                }

            }

            swap(a, p, first);
            return p;

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(" :underflow_error");
            return 0;
        }

    }   // int partition(a, first, last)

}   // QuickSort()
