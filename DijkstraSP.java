import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class DijkstraSP {

    private Map<String, Edge> edgeTo;
    private Map<String, Double> distTo;
    private IndexMinHeap<String, Double> pq;

    public DijkstraSP(EdgeWeightedDigraph g, String s) {
        edgeTo = new HashMap<>();
        distTo = new HashMap<>();
        pq = new IndexMinHeap<>();

        for (String v : g.getVerts())
            distTo.put(v, Double.POSITIVE_INFINITY);
        distTo.put(s, 0.0);

        pq.insert(s, 0.0);
        while (!pq.isEmpty()) {
            String v = pq.delMin();
            // System.out.println("Processando: " + v);
            for (Edge e : g.getAdj(v)) {
                relax(e);
            }
        }
    }

    public boolean hasPathTo(String v) {
        return distTo.get(v) != Double.POSITIVE_INFINITY;

    }

    public double distTo(String v) {
        if (!hasPathTo(v))
            throw new UnsupportedOperationException("Sem caminho para " + v + "!");
        return distTo.get(v);
    }

    public Iterable<Edge> pathTo(String v) {
        LinkedList<Edge> path = new LinkedList<>();
        if (!hasPathTo(v))
            return path;
        Edge e = edgeTo.get(v);
        // Enquanto não chegar na primeira aresta
        while (e != null) {
            path.addFirst(e);
            // Próxima aresta começa no V da atual!
            e = edgeTo.get(e.getV());
        }
        return path;
    }

    private void relax(Edge e) {
        String v = e.getV();
        String w = e.getW();
        double edgeWeight = distTo.get(v) + e.getWeight();
        if (distTo.get(w) > edgeWeight) {
            // Achei um caminho melhor!
            distTo.put(w, edgeWeight);
            edgeTo.put(w, e);
            if (!pq.contains(w))
                // Não existe, insere na fila
                pq.insert(w, edgeWeight);
            else
                // Já existe, reduz a prioridade (valor)
                pq.decreaseValue(w, edgeWeight);
        }
    }

    public static void main(String[] args) {
        EdgeWeightedDigraph g = new EdgeWeightedDigraph("exemplos/tinyEWD.txt");
        DijkstraSP dij = new DijkstraSP(g, "2");

        for (String v : g.getVerts()) {
            System.out.print(v + ": ");
            if (!dij.hasPathTo(v))
                System.out.println("Sem caminho!");
            else {
                for (Edge e : dij.pathTo(v)) {
                    System.out.print(e + " ");
                }
                System.out.println("- " + dij.distTo(v));
            }
        }
    }
}
