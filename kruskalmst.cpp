#include "kruskalmst.h"
#include "unionfind.h"
#include <algorithm>

KruskalMST::KruskalMST(const EdgeWeightedGraph &g) {
    custoTotal = 0;

    UnionFind uf(g);

    for (const Edge& e : g.getEdges())
    {
        string v1 = e.v;
        string v2 = e.w;
        // Se v1 e v2 não fazem parte do mesmo
        // conjunto, adicionar a aresta NÃO VAI
        // criar um ciclo!
        if (uf.find(v1) != uf.find(v2)) {
            mst.push_back(e);
            custoTotal += e.weight;
            uf.do_union(v1, v2);
            //e.color = "color=red penwidth=3";
        }
    }
}

double KruskalMST::getCustoTotal() const {
    return custoTotal;
}

vector<Edge> KruskalMST::getMST() const {
    return mst;
}

