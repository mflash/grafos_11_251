from edgeweightedgraph import EdgeWeightedGraph
from uf import UnionFind

class Kruskal:

    def __init__(self, g: EdgeWeightedGraph):
        self.g = g
        self.mst = []
        self.custoTotal = 0

        edges = set()

        # Monta a lista de arestas
        for v in g.getVerts():
            for w in g.getAdj(v):
               e = tuple(w)
               if e not in edges:
                   edges.add(e)

        # print(edges)
        uf = UnionFind(g)

        # Percorre as arestas em ordem de distância
        for e in sorted(edges, key=lambda k: k[2]):
            v = e[0]
            w = e[1]
            dist = e[2]
            if uf.find(v) != uf.find(w):
                self.mst.append(e)
                self.custoTotal += dist
                uf.union(v, w)
            # print(e)

        # print(self.mst)


if __name__ == "__main__":

    g = EdgeWeightedGraph("exemplos/tinyEWG.txt")
    k = Kruskal(g)
    for e in k.mst:
        print(e)