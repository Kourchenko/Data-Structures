#include <iostream>
#include "ArrayClass.h"
using namespace std;

ArrayClass::ArrayClass() {
    array = new int[DEFAULT_SIZE];
    maxSize = DEFAULT_SIZE;
    count = 0;
    smallest = INT_MAX;
    largest = INT_MAX;
}

ArrayClass::ArrayClass(int size) {
    array = new int[size];
    maxSize = size;
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
 * 0 if not successful
 * 1 if successful
 */
int ArrayClass::addItem(int v) {
    if (count < maxSize) {
        array[count++] = v;
                
        if (v < smallest) {
            smallest = v;
        }
        if (v > largest) {
            largest = v;
        }
        return 1;
    }
    return 0;
}

/**
 * Determine if value, int v, is in the array.
 * 0 if in array
 * 1 if not in array
 */
int ArrayClass::find(int v) {
    for (int i = 0; i < count; i++) {
        if (array[i] == v) return 1;
    }
    return 0;
}

void ArrayClass::printItems() {
    for (int i = 0; i < count; i++) {
        printf("%d", array[i]);
    }
}

void ArrayClass::removeItem(int v) {
    int fix_state = 0;
    for (int i = 0; i < count-1; i++) {
        if (array[i] == v) {
            fix_state = 1;
        }
        if (fix_state) {
            // shift items left
            array[i] = array[i+1];
        }
    }
}

void ArrayClass::removeItemAtIndex(int index) {
    // cannot remove item invalid index
    if (index < count) {
        for (int i = index; i < count-1; i++) {
            // shift items left
            array[index] = array[index+1];
        }
        count--;
    }
}

/**
 * Remove duplicate items.
 * O(n**3)
 */
void ArrayClass::deleteDuplicates() {
    for (int i = 0; i < count; i++) {
        for (int j = i + 1; j < count - 1; j++) {
            if (array[i] == array[j]) {
                removeItemAtIndex(j);
            }
        }
    }
}
