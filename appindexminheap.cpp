#include <iostream>
#include "indexminheap.h"

using namespace std;

int main()
{
    IndexMinHeap<string, double> h;
    h.put("A", 5.0);
    h.put("X", 2.0);
    h.put("G", 12.0);
    h.put("O", 7.0);
    h.put("F", 1.0);
    h.put("L", 0.0);

    cout << "Original:" << endl;
    h.print();
    cout << endl;

    h.decreaseValue("G", -2.0);

    cout << "G valendo -2:" << endl;
    h.print();
    cout << endl << endl;

    while (h.size() > 0) {
        h.print();
        cout << h.delMin() << endl;
    }
}
