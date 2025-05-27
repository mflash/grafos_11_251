import java.util.ArrayList;
import java.util.Collections;

public class AppMapaMST {

    private static class Ponto implements Comparable<Ponto> {
        public double x, y;
        public int indice;
        public double dist;

        public Ponto(int indice, double x, double y) {
            this.indice = indice;
            this.x = x;
            this.y = y;
            this.dist = 0;
        }

        @Override
        public int compareTo(AppMapaMST.Ponto o) {
            if (dist < o.dist)
                return -1;
            else if (dist > o.dist)
                return 1;
            return 0;
        }

        @Override
        public String toString() {
            return indice + ": (" + x + ", " + y + ") " + dist;
        }
    }

    public static void main(String[] args) {
        In arq = new In("exemplos/dados.csv");
        ArrayList<Ponto> pontos = new ArrayList<>();
        int totalPontos = 0;
        while (arq.hasNextLine()) {
            String linha = arq.readLine();
            String[] dados = linha.split(";");
            double y = Double.parseDouble(dados[0]);
            double x = Double.parseDouble(dados[1]);
            pontos.add(new Ponto(totalPontos, x, y));
            totalPontos++;
        }
        // for (Ponto p : pontos)
        // System.out.println(p.indice + ": " + p.x + ", " + p.y);

        EdgeWeightedGraph g = new EdgeWeightedGraph();

        for (int i = 0; i < totalPontos; i++) {
            Ponto p1 = pontos.get(i);
            ArrayList<Ponto> pontosAux = new ArrayList<>(pontos);
            for (int j = 0; j < totalPontos; j++) {
                if (i == j)
                    continue;
                Ponto p2 = pontos.get(j);
                p2.dist = Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
            }
            Collections.sort(pontosAux);
            // for (Ponto p : pontosAux) {
            // System.out.println(p);
            // }
            for (int pos = 1; pos <= 3; pos++) {
                Ponto p = pontosAux.get(pos);
                g.addEdge("" + p1.indice, "" + p.indice, p.dist);
            }
            // break;
        }
        KruskalMST k = new KruskalMST(g);
        // System.out.println(g.toDot());
        Out saida = new Out("exemplos/saida.txt");
        for (Edge e : g.getEdges()) {
            int dentro = 0;
            if (e.getColor() != "")
                dentro = 1;
            saida.println(e.getV() + " " + e.getW() + " " + dentro);
        }
        saida.close();
    }
}
