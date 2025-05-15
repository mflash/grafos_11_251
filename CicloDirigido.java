import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CicloDirigido {

    private enum Status {
        WHITE, GREY, BLACK
    }

    private Graph g;
    private Map<String, Status> marked;
    private boolean cycle;

    public CicloDirigido(Graph g) {
        this.g = g;
        marked = new HashMap<>();
        for (String v : g.getVerts())
            marked.put(v, Status.WHITE);

        for (String v : g.getVerts()) {
            if (marked.get(v) == Status.WHITE) {
                System.out.println("Verificando a partir de: " + v);
                cycle = dfs(v);
            }
            if (cycle) // == true
                break;
        }
    }

    private boolean dfs(String v) {
        marked.put(v, Status.GREY);
        for (String w : g.getAdj(v)) {
            // Se for WHITE, visita
            if (marked.get(w) == Status.WHITE) {
                if (dfs(w))
                    return true;
            } else if (marked.get(w) == Status.GREY) {
                // Cheguei em um vert. já visitado
                // por outro caminho?
                System.out.println("Ciclo encontrado na aresta " + v + "-" + w);
                return true;
            }
        }
        marked.put(v, Status.BLACK);
        return false; // Não encontrei um ciclo
        // System.out.println("Saindo: " + v);
    }

    public boolean hasCycle() {
        return cycle;
    }

    public static void main(String[] args) {
        // Graph g = new Graph("exemplos/tinyG.txt");
        Digraph g = new Digraph();
        g.addEdge("0", "1");
        g.addEdge("1", "3");
        g.addEdge("3", "4");
        g.addEdge("3", "2");
        // g.addEdge("2", "0");
        g.addEdge("5", "6");
        g.addEdge("6", "7");
        g.addEdge("7", "5");
        // g = new Digraph("exemplos/mediumG.txt");

        CicloDirigido c = new CicloDirigido(g);

        if (c.hasCycle()) {
            System.out.println("Tem ciclo!");
        } else {
            System.out.println("Não tem ciclo...");
        }

        // System.out.println(c.edgeName("0", "1"));
        // System.out.println(c.edgeName("1", "0"));
    }
}
