#include <iostream>
#include "unionfind.h"
#include "edgeweightedgraph.h"

using namespace std;

int main()
{
    EdgeWeightedGraph g("exemplos/tinyEWG.txt");
    UnionFind uf(&g);
    cout << "find 1: " << uf.find("1") << endl;
    cout << "find 3: " << uf.find("3") << endl;
    cout << "find 2: " << uf.find("2") << endl;
    cout << endl;
    uf.do_union("1", "3");
    cout << "find 3: " << uf.find("3") << endl;
}
