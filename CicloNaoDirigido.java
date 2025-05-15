import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CicloNaoDirigido {

    private Graph g;
    private Set<String> marked;
    private Set<String> edgeSet;
    private boolean cycle;

    public CicloNaoDirigido(Graph g) {
        this.g = g;
        marked = new HashSet<>();
        edgeSet = new HashSet<>();
        for (String v : g.getVerts()) {
            if (!marked.contains(v)) {
                System.out.println("Verificando a partir de: " + v);
                cycle = dfs(v);
            }
            if (cycle) // == true
                break;
        }
    }

    private boolean dfs(String v) {
        marked.add(v);
        for (String w : g.getAdj(v)) {
            // Se não estiver marcado, visita
            if (!marked.contains(w)) {
                // Adiciona a aresta ao conj. arestas
                edgeSet.add(edgeName(v, w));
                if (dfs(w))
                    return true;
            } else {
                // Cheguei em um vert. já visitado
                // por outro caminho?
                if (!edgeSet.contains(edgeName(v, w))) {
                    // Sim! Achamos um ciclo
                    System.out.println("Ciclo encontrado na aresta " + v + "-" + w);
                    return true;
                }

            }
        }
        return false; // Não encontrei um ciclo
        // System.out.println("Saindo: " + v);
    }

    public boolean hasCycle() {
        return cycle;
    }

    private String edgeName(String v1, String v2) {
        if (v1.compareTo(v2) > 0)
            return v2 + "-" + v1;
        return v1 + "-" + v2;
    }

    public static void main(String[] args) {
        // Graph g = new Graph("exemplos/tinyG.txt");
        Graph g = new Graph();
        g.addEdge("0", "1");
        g.addEdge("1", "3");
        g.addEdge("3", "4");
        g.addEdge("3", "2");
        // g.addEdge("2", "0");
        g.addEdge("5", "6");
        g.addEdge("6", "7");
        g.addEdge("7", "5");
        g = new Graph("exemplos/mediumG.txt");

        CicloNaoDirigido c = new CicloNaoDirigido(g);

        if (c.hasCycle()) {
            System.out.println("Tem ciclo!");
        } else {
            System.out.println("Não tem ciclo...");
        }

        // System.out.println(c.edgeName("0", "1"));
        // System.out.println(c.edgeName("1", "0"));
    }
}
