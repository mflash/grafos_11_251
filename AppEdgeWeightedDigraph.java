public class AppEdgeWeightedDigraph {
  public static void main(String[] args) {
    /*
     * EdgeWeightedDigraph g = new EdgeWeightedDigraph();
     * g.addEdge("0", "1", 5);
     * g.addEdge("0", "2", 12);
     * g.addEdge("2", "1", 8);
     */
    EdgeWeightedDigraph g = new EdgeWeightedDigraph("exemplos/tinyEWD.txt");

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
