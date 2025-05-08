import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DFS {

    private Graph g;
    private String inicial;
    private Set<String> marked;
    private Map<String, String> edgeTo;

    public DFS(Graph g, String inicial) {
        this.g = g;
        this.inicial = inicial;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
        dfs(inicial);
    }

    private void dfs(String v) {
        System.out.println("Entrando: " + v);
        marked.add(v);
        for (String w : g.getAdj(v)) {
            // Se não estiver marcado, visita
            if (!marked.contains(w))
                dfs(w);
        }
        System.out.println("Saindo: " + v);
    }

    public boolean hashPathTo(String v) {
        // retorno true se tiver caminho para v
        return false;
    }

    public List<String> pathTo(String v) {
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        Graph g = new Graph("exemplos/tinyG.txt");
        DFS dfs = new DFS(g, "0");
    }
}
