#include <iostream>
#include "digraph.h"
#include "directedcycle.h"

using namespace std;

int main()
{
  // Digraph g("tinyDAG.txt");
  Digraph g;
  g.addEdge("0", "1");
  g.addEdge("1", "3");
  g.addEdge("3", "4");
  g.addEdge("3", "2");
  // g.addEdge("2", "0");
  g.addEdge("5", "6");
  g.addEdge("6", "7");
  g.addEdge("7", "5");
  DirectedCycle dcycle(g);

  cout << g.toDot() << endl;

  cout << "Tem ciclo? " << dcycle.containsCycle() << endl;
}
