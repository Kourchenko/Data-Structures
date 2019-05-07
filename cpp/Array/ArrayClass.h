#ifndef ArrayClass_H
#define ArrayClass_H

const int MAX_SIZE=100;

class ArrayClass {
    int[] array;
    int count;
    int smallest;
    int largest;

    public:
        ArrayClass();
        ArrayClass(int size);
        int getSize();
        int getCount();
        int getSmallest();
        int getLargest();
        int addItem(int v);
        int find(int v);
        void resize();
        void printItems();
        void removeItem(int v);
        void removeItemAtIndex(int index);
        void deleteDuplicates();
        void cleanup();
        int isEmpty();

}

#endif