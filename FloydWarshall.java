import java.util.LinkedList;

public class FloydWarshall {

    private static final String NEWLINE = System.getProperty("line.separator");
    private double[][] dist;
    private int[][] next;
    private boolean temCicloNegativo;
    private AdjMatrixEdgeWeightedDigraph g;

    public FloydWarshall(EdgeWeightedDigraph g2) {
        this.g = new AdjMatrixEdgeWeightedDigraph(g2);

        temCicloNegativo = false;

        int v = g2.getTotalVerts();
        dist = new double[v][v];
        next = new int[v][v];

        // Inicializar as matrizes
        // Use g.mapToArray para converter um nome de vértice (string) para um índice (linha ou coluna da matriz)

        // Executar o algoritmo!
    }

    public boolean hasPathTo(String u, String v) {
        int u1 = g.mapToArray(u);
        int v1 = g.mapToArray(v);
        return next[u1][v1] != -1;
    }

    public double distTo(String u, String v) {
        int u1 = g.mapToArray(u);
        int v1 = g.mapToArray(v);
        return dist[u1][v1];
    }

    public Iterable<String> pathTo(String u, String v) {
        LinkedList<String> path = new LinkedList<>();
        // Reconstrua o caminho e retorne na lista
        // use g.mapToString passando um índice para obter o nome do vértice correspondente (string)
        return path;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Distâncias:" + NEWLINE);
        sb.append("  ");
        for (int i = 0; i < dist.length; i++) {
            String v = g.mapToString(i);
            sb.append(String.format("%-5s ", v));
        }
        sb.append(NEWLINE);
        for (int i = 0; i < dist.length; i++) {
            String v = g.mapToString(i);
            sb.append(v + " ");
            for (int j = 0; j < dist[i].length; j++) {
                if (next[i][j] != -1)
                    sb.append(String.format("%5.2f ", dist[i][j]));
                else
                    sb.append("----- ");
            }
            sb.append(NEWLINE);
        }
        // Caminhos
        sb.append(NEWLINE + "Caminhos:" + NEWLINE);
        sb.append("  ");
        for (int i = 0; i < next.length; i++) {
            String v = g.mapToString(i);
            sb.append(String.format("%-5s ", v));
        }
        sb.append(NEWLINE);
        for (int i = 0; i < next.length; i++) {
            String v = g.mapToString(i);
            sb.append(v + " ");
            for (int j = 0; j < next[i].length; j++) {
                if (next[i][j] != -1) {
                    String w = g.mapToString(next[i][j]);
                    sb.append(String.format("%-5s ", w));
                } else
                    sb.append("----- ");
            }
            sb.append(NEWLINE);
        }
        return sb.toString();
    }
}
