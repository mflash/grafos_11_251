import java.util.ArrayList;
import java.util.List;

public class KruskalMST {
    private List<Edge> mst;
    private double custoTotal;

    public KruskalMST(EdgeWeightedGraph g) {
        mst = new ArrayList<>();
        custoTotal = 0;

        UnionFind uf = new UnionFind(g);
        MinHeap<Edge> pq = new MinHeap<>();

        for (Edge e : g.getEdges())
            pq.put(e);

        while (!pq.isEmpty()) {
            // System.out.println(pq.delMin());
            Edge e = pq.delMin();
            String v1 = e.getV();
            String v2 = e.getW();
            // Se v1 e v2 não fazem parte do mesmo
            // conjunto, adicionar a aresta NÃO VAI
            // criar um ciclo!
            if (!uf.find(v1).equals(uf.find(v2))) {
                mst.add(e);
                custoTotal += e.getWeight();
                uf.union(v1, v2);
                e.setColor("color=red penwidth=3");
            }
        }

    }

    public double getCustoTotal() {
        return custoTotal;
    }

    public Iterable<Edge> getMST() {
        return mst;
    }

    public static void main(String[] args) {
        EdgeWeightedGraph g = new EdgeWeightedGraph("exemplos/tinyEWG.txt");
        KruskalMST k = new KruskalMST(g);
        System.out.println("Árvore geradora:");
        for (Edge e : k.getMST())
            System.out.println(e);

        System.out.println(g.toDot());
    }
}