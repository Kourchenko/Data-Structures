#include "ArrayClass.h"
#include <assert.h>

int TEST_GET_SMALLEST() {
    ArrayClass array;
    array.addItem(2);
    array.addItem(5);
    array.addItem(6);
    array.addItem(1);
    array.addItem(3);
    array.addItem(4);

    assert(array.getSmallest == 1);

}
int main() {
    TEST_GET_SMALLEST();
}