#include <map>
#include <string>
#include "edgeweightedgraph.h"

#ifndef UF_H
#define UF_H

class UnionFind
{
public:
    UnionFind(EdgeWeightedGraph* g);
    std::string find(std::string v);
    void do_union(std::string v, std::string w);
    int getTotalSets() const { return totalSets; }

private:
    std::map<std::string, std::string> uf;
    int totalSets;
};

#endif
