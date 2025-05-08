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
}
