#include "dfs.h"
#include <iostream>
#include <fstream>
#include <sstream>
#include <set>

using namespace std;

DepthFirstSearch::DepthFirstSearch(Graph &g, string s)
{
	this->s = s;
	dfs(g, s);
}

void DepthFirstSearch::dfs(Graph &g, string v)
{
	cout << "Entrando: " << v << endl;
	marked.insert(v); // marca v como visitado
	for (auto const &w : g.getAdj(v))
	{
		if (marked.find(w) == marked.end())
		{
			dfs(g, w);
		}
	}
	cout << "Saindo: " << v << endl;
}

bool DepthFirstSearch::hasPathTo(string s)
{
	return false;
}

vector<string> DepthFirstSearch::pathTo(string v)
{
	vector<string> path;
	return path;
}
