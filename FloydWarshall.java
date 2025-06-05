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

        int totVert = g2.getTotalVerts();
        dist = new double[totVert][totVert];
        next = new int[totVert][totVert];

        // Inicializar as matrizes
        for (int linha = 0; linha < totVert; linha++)
            for (int col = 0; col < totVert; col++) {
                if (linha != col) {
                    dist[linha][col] = Double.POSITIVE_INFINITY;
                }
                next[linha][col] = -1;
            }

        for (Edge e : g2.getEdges()) {
            String u = e.getV();
            String v = e.getW();
            double weight = e.getWeight();
            int ind_u = g.mapToArray(u);
            int ind_v = g.mapToArray(v);
            dist[ind_u][ind_v] = weight;
            next[ind_u][ind_v] = ind_u;
        }
        // Use g.mapToArray para converter um nome de vértice (string) para um índice
        // (linha ou coluna da matriz)

        // Executar o algoritmo!
        for (int k = 0; k < totVert; k++) {
            for (int j = 0; j < totVert; j++) {
                for (int i = 0; i < totVert; i++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[k][j];
                    }
                }
            }
        }
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
        // use g.mapToString passando um índice para obter o nome do vértice
        // correspondente (string)
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
