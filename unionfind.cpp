#include "unionfind.h"
#include <iostream>

using namespace std;

UnionFind::UnionFind(const EdgeWeightedGraph& g)
{
    set<string> verts = g.getVerts();
		this->totalSets = verts.size();
		for(const auto& v: verts) {
      uf[v] = v;
		}
}

string UnionFind::find(string v)
{
    string start_v = v;
    map<string, string>::iterator it = uf.find(v);
    while (it != uf.end())
    {
        v = it->second;
        if (v == it->first)
          break;
        it = uf.find(v);
    }
    return v;
}

void UnionFind::do_union(string v, string w)
{
    string s = find(v);
    string t = find(w);
    uf[t] = s;
}
