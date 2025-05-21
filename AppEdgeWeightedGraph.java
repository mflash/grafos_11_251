public class AppEdgeWeightedGraph {
  public static void main(String[] args) {
    /*
     * EdgeWeightedGraph g = new EdgeWeightedGraph();
     * g.addEdge("0", "1", 5);
     * g.addEdge("0", "2", 12);
     * g.addEdge("2", "1", 8);
     */
    EdgeWeightedGraph g = new EdgeWeightedGraph("exemplos/tinyEWG.txt");

    for (String v : g.getVerts()) {
      System.out.print(v + ": ");
      for (Edge e : g.getAdj(v))
        System.out.print(e + " ");
      System.out.println();
    }

    System.out.println();
    System.out.println(g.toDot());
  }
}
