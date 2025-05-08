#include <vector>
#include <map>
#include <set>
#include <string>
#include "graph.h"

#ifndef DFS_H
#define DFS_H

class DepthFirstSearch
{

public:
	DepthFirstSearch(Graph &g, std::string s);

private:
	std::string s;
	std::set<std::string> marked;
	void dfs(Graph &g, std::string v);
};

#endif
