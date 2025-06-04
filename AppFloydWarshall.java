public class AppFloydWarshall {

    public static void main(String[] args) {
        EdgeWeightedDigraph g = new EdgeWeightedDigraph("exemplos/tinyEWD.txt");

        FloydWarshall fw = new FloydWarshall(g);

        System.out.println(fw);

        for (String v : g.getVerts()) {
            for (String w : g.getVerts()) {
                if (!v.equals(w)) {
                    System.out.print(v + " -> " + w + ": ");
                    if (!fw.hasPathTo(v, w)) {
                        System.out.println("SEM CAMINHO");
                    } else {
                        for (String u : fw.pathTo(v, w)) {
                            System.out.print(u + " ");
                        }
                        System.out.println("(" + fw.distTo(v, w) + ")");
                    }
                }
            }
        }
    }
}
