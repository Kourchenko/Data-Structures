#include <iostream>
#include "ArrayClass.h"
using namespace std;

ArrayClass::ArrayClass() {
    array[100];
    maxSize = 100;
    count = 0;
    smallest = INT_MAX;
    largest = INT_MAX;
}

ArrayClass::ArrayClass(int size) {
    array[size];
    maxSize = 100;
    count = 0;
    smallest = INT_MAX;
    largest = INT_MAX;
}

int ArrayClass::getSize() {
    return maxSize;
}

int ArrayClass::getCount() {
    return count;
}

int ArrayClass::getSmallest() {
    return smallest;
}

int ArrayClass::getLargest() {
    return largest;
}

/**
 * Add an item if count < maxSize,
 * else first double size of array, then add.
 */
int ArrayClass::addItem(int v) {
    if (count < maxSize) {
        *array[count++] = v;
    } else {
        // Resize
        int *resized_array[maxSize*2];
        maxSize = maxSize * 2;
        for (int i = 0; i < count; i++) {
            resized_array[i] = array[i]; // copy items
        }
        // Add new item
        *resized_array[count++] = v;
        *array = *resized_array;
    }
    if (v < smallest) {
        smallest = v;
    }
    if (v > largest) {
        largest = v;
    }
}