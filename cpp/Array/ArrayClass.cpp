#include <iostream>
#include "ArrayClass.h"
using namespace std;

class ArrayClass {
    int[] array;
    ArrayClass() {
        array = new int[MAX_SIZE];
    }

    ArrayClass(int size) {
        array = new int[size];
    }

    void cleanup() {
        delete [] array;
    }
}