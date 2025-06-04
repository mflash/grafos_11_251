from edgeweighteddigraph import EdgeWeightedDigraph
from indexminheap import IndexMinHeap

class DijkstraSP:
    def __init__(self, g: EdgeWeightedDigraph, s: str):
        self.marked = {}
        self.edgeTo = {}
        self.distTo = {}
        self.pq = IndexMinHeap()

        for v in g.getVerts():
            self.distTo[v] = 1e7;

        self.edgeTo[s] = None
        self.distTo[s] = 0.0

        self.pq.add([s, 0.0])

        while not self.pq.isEmpty():
            v = self.pq.delMin()
            for e in g.getAdj(v[0]):
                self.relax(e)
        
    def relax(self, e):
        v = e[0]
        w = e[1]
        weight = self.distTo[v] + e[2]
        if self.distTo[w] > weight:
            self.distTo[w] = weight
            self.edgeTo[w] = e
            if not self.pq.contains(w):
                self.pq.add([w, weight])
            else:
                self.pq.decreaseValue(w, weight)

    def hasPathTo(self, v):
        return self.distTo[v] != 1e7

    def pathTo(self, v):
        path = []
        e = self.edgeTo[v]
        while e != None:
            path.insert(0, e)
            e = self.edgeTo[e[0]]
        return path

    def getDistTo(self, v):
        if not self.hasPathTo(v):
            return -1
        return self.distTo[v]


if __name__ == "__main__":

    g = EdgeWeightedDigraph("exemplos/tinyEWD.txt")

    dij = DijkstraSP(g, "0")

    for v in sorted(g.getVerts()):
        print(f"{v}: ", end="")
        if dij.hasPathTo(v):
            for w in dij.pathTo(v):
                print(f"{w} ", end="")
            print(f"{dij.getDistTo(v)}")
        else:
            print("Sem caminho para", v)
    print()
