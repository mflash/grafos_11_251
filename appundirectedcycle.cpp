#include <iostream>
#include "graph.h"
#include "undirectedcycle.h"

using namespace std;

int main()
{
  // Graph g("exemplos/tinyG.txt");
  Graph g;
  g.addEdge("0", "1");
  g.addEdge("1", "3");
  g.addEdge("3", "4");
  g.addEdge("3", "2");
  // g.addEdge("2", "0");
  g.addEdge("5", "6");
  g.addEdge("6", "7");
  g.addEdge("7", "5");
  UndirectedCycle ucycle(g);

  cout << "Tem ciclo? " << ucycle.containsCycle() << endl;
}
