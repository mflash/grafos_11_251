import java.util.HashSet;
import java.util.Set;

public class DFS {

    private Graph g;
    private String inicial;
    private Set<String> marked;

    public DFS(Graph g, String inicial) {
        this.g = g;
        this.inicial = inicial;
        marked = new HashSet<>();
        dfs(inicial);
    }

    private void dfs(String v) {
        System.out.println("Entrando: " + v);

    }

    public static void main(String[] args) {
        Graph g = new Graph("exemplos/tinyG.txt");
        DFS dfs = new DFS(g, "0");
    }
}
