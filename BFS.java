import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BFS {

    private Graph g;
    private String inicial;
    private Set<String> marked;
    private Map<String, String> edgeTo;
    private Map<String, Integer> distTo;

    public BFS(Graph g, String inicial) {
        this.g = g;
        this.inicial = inicial;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
        distTo = new HashMap<>();
        bfs(inicial);
    }

    private void bfs(String v) {
        // criar uma fila
        List<String> fila = new LinkedList<>();
        fila.add(v);
        marked.add(v);
        distTo.put(v, 0);
        while (!fila.isEmpty()) {
            v = fila.removeFirst();
            System.out.println("Vértice: " + v);
            for (String w : g.getAdj(v)) {
                // Se não estiver marcado, visita
                if (!marked.contains(w)) {
                    marked.add(w);
                    fila.add(w);
                    edgeTo.put(w, v);
                    distTo.put(w, distTo.get(v) + 1);
                }
            }
        }
    }

    public boolean hashPathTo(String v) {
        // retorno true se tiver caminho para v
        return marked.contains(v);
        // if(marked.contains(v))
        // return true;
        // return false;
    }

    public List<String> pathTo(String v) {
        List<String> path = new ArrayList<>();
        if (!hashPathTo(v))
            return path;
        while (!v.equals(inicial)) {
            path.add(0, v);
            v = edgeTo.get(v);
        }
        path.add(0, inicial);
        return path;
    }

    public int distTo(String v) {
        return distTo.get(v);
    }

    public static void main(String[] args) {
        Graph g = new Graph("exemplos/tinyG.txt");
        BFS dfs = new BFS(g, "0");

        for (String v : g.getVerts()) {
            System.out.print(v + ": ");
            if (!dfs.hashPathTo(v))
                System.out.println("Não tem caminho");
            else {
                System.out.println(dfs.pathTo(v) + " (" + dfs.distTo(v) + ")");
            }
        }
    }
}
