#include "undirectedcycle.h"
#include <iostream>
#include <fstream>
#include <sstream>
#include <set>

using namespace std;

UndirectedCycle::UndirectedCycle(Graph &g)
{
	hasCycle = false;
	for (auto const &w : g.getVerts())
	{
		if (marked.find(w) == marked.end())
		{
			hasCycle = containsCycle(g, w);
			if (hasCycle)
				break;
		}
	}
}

bool UndirectedCycle::containsCycle()
{
	return hasCycle;
}

bool UndirectedCycle::containsCycle(Graph &g, string v)
{
	// cout << "Estou em " << v << endl;
	marked.insert(v);
	for (auto const &u : g.getAdj(v))
	{
		string e = u + "-" + v;
		if (marked.find(u) == marked.end())
		{
			edges.insert(e);
			bool res = containsCycle(g, u);
			if (res)
				return res;
		}
		else if (edges.find(v + "-" + u) == edges.end())
			return true;
	}
	return false;
}
