#include <vector>
#include "edgeweightedgraph.h"
#include "edge.h"

using namespace std;

class KruskalMST {

  public:

    KruskalMST(const EdgeWeightedGraph& g);
    double getCustoTotal() const;
    vector<Edge> getMST() const;
    
  private:
    vector<Edge> mst;
    double custoTotal;
};

