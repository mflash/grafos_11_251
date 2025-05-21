public class Edge implements Comparable<Edge> {
  private String v;
  private String w;
  private double weight;
  private String color;

  public Edge(String v, String w, double weight) {
    this.v = v;
    this.w = w;
    this.weight = weight;
    this.color = "";
  }

  public String getV() {
    return v;
  }

  public String getW() {
    return w;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getColor() {
    return color;
  }

  @Override
  public int compareTo(Edge other) {
    return Double.compare(this.weight, other.weight);
  }

  @Override
  public String toString() {
    return v + "-" + w + " (" + weight + ") " + color;
  }
}
