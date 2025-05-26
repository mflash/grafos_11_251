#include <iostream>
#include "kruskalmst.h"

int main()
{
    EdgeWeightedGraph g("exemplos/tinyEWG.txt");
    cout << g.toDot() << endl;
    KruskalMST k(g);
    cout << "Árvore geradora mínima (MST) usando Kruskal:\n";
    for (Edge e: k.getMST())
       cout << e << endl;

    cout << g.toDot() << endl;
}
