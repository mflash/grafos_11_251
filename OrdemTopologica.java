import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OrdemTopologica {

    private Graph g;
    private Set<String> marked;
    private List<String> ordemTopo;

    public OrdemTopologica(Graph g) {
        this.g = g;
        marked = new HashSet<>();
        ordemTopo = new LinkedList<>();
        for(String v: g.getVerts()) {
            if(!marked.contains(v))
                dfs(v);
        }        
    }

    private void dfs(String v) {
        // System.out.println("Entrando: " + v);
        marked.add(v);
        for (String w : g.getAdj(v)) {
            // Se não estiver marcado, visita
            if (!marked.contains(w)) {
                // indica que para chegar em w
                // viemos por v            
                dfs(w);
            }
        }
        // Insere no início da lista: pós-ordem
        // INVERTIDA
        ordemTopo.add(0, v);
        System.out.println("Saindo: " + v);
    }

    public List<String> getOrdemTopologica()
    {
        return ordemTopo;
    }

    public static void main(String[] args) {
        Digraph g = new Digraph("exemplos/tinyG.txt");
        OrdemTopologica ot = new OrdemTopologica(g);
        System.out.println("Ordem topológica:");
        for(String v: ot.getOrdemTopologica()) {
            System.out.print(v+", ");
        }
        System.out.println();
        System.out.println(g.toDot());
    }
}
