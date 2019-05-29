#ifndef ArrayClass_H
#define ArrayClass_H


class ArrayClass {
    private: 
        const int DEFAULT_SIZE = 100;
        int * array;
        int maxSize;
        int count;
        int smallest;
        int largest;
        void resize();

    public:
    
        ArrayClass();
        ArrayClass(int size);
        int getSize();
        int getCount();
        int getSmallest();
        int getLargest();
        int addItem(int v);
        int find(int v);
        void printItems();
        void removeItem(int v);
        void removeItemAtIndex(int index);
        void deleteDuplicates();
        void cleanup();
        int isEmpty();

};

#endif // ArrayClass_H