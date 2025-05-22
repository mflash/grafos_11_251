import java.util.Iterator;
import java.util.NoSuchElementException;

public class MinHeap<Key> implements Iterable<Key> {
  private Key[] pq; // itens armazenados nas posic. 1 a n
  private int n; // qtd de itens

  /**
   * Inicializa uma heap vazia com determinada capacidade
   *
   * @param initCapacity a capacidade inicial deste heap
   */
  public MinHeap(int initCapacity) {
    pq = (Key[]) new Object[initCapacity + 1];
    n = 0;
  }

  /**
   * Inicializa um heap vazio
   */
  public MinHeap() {
    this(1);
  }

  /**
   * Inicializa um heap a partir do array de chaves
   * <p>
   * Tempo O(n) - n sendo o total de chaves
   *
   * @param keys o array de chaves
   */
  public MinHeap(Key[] keys) {
    n = keys.length;
    pq = (Key[]) new Object[keys.length + 1];
    for (int i = 0; i < n; i++)
      pq[i + 1] = keys[i];
    for (int k = n / 2; k >= 1; k--)
      sink(k);
  }

  /**
   * Retorna true se heap estiver vazio
   *
   * @return {@code true} se heap estiver vazio
   *         {@code false} caso contrário
   */
  public boolean isEmpty() {
    return n == 0;
  }

  /**
   * Retorna total de chaves neste heap
   *
   * @return o total de chaves neste heap
   */
  public int size() {
    return n;
  }

  /**
   * REtorna a menor chave neste heap
   *
   * @return menor chave neste heap
   * @throws NoSuchElementException se o heap estiver vazio
   */
  public Key min() {
    if (isEmpty())
      throw new NoSuchElementException("Heap vazio!");
    return pq[1];
  }

  // Método auxiliar para dobrar o tamanho do heap
  private void resize(int capacity) {
    assert capacity > n;
    Key[] temp = (Key[]) new Object[capacity];
    for (int i = 1; i <= n; i++) {
      temp[i] = pq[i];
    }
    pq = temp;
  }

  /**
   * Adiciona uma nova chave a este heap
   *
   * @param x a chave a ser adicionada ao heap
   */
  public void put(Key x) {
    // duplica o tamanho do array se necessário
    if (n == pq.length - 1)
      resize(2 * pq.length);

    // adiciona x e faz swim para manter propriedade de ordem parcial
    pq[++n] = x;
    swim(n);
  }

  /**
   * Remove e retorna a menor chave neste heap
   *
   * @return menor chave no heap
   * @throws NoSuchElementException se o heap estiver vazio
   */
  public Key delMin() {
    if (isEmpty())
      throw new NoSuchElementException("Heap vazio!");
    Key min = pq[1];
    exch(1, n--);
    sink(1);
    pq[n + 1] = null; // para ajudar a garbage collection
    if ((n > 0) && (n == (pq.length - 1) / 4))
      resize(pq.length / 2);
    return min;
  }

  /***************************************************************************
   * Métodos auxiliares
   ***************************************************************************/

  private void swim(int k) {
    while (k > 1 && greater(k / 2, k)) {
      exch(k, k / 2);
      k = k / 2;
    }
  }

  private void sink(int k) {
    while (2 * k <= n) {
      int j = 2 * k;
      if (j < n && greater(j, j + 1))
        j++;
      if (!greater(k, j))
        break;
      exch(k, j);
      k = j;
    }
  }

  /***************************************************************************
   * Métodos auxiliares para comparação e troca
   ***************************************************************************/
  private boolean greater(int i, int j) {
    return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
  }

  private void exch(int i, int j) {
    Key swap = pq[i];
    pq[i] = pq[j];
    pq[j] = swap;
  }

  /**
   * Retorna um iterador que passa pelas chaves em ordem crescente an iterator
   * that iterates over the keys on this priority queue
   * <p>
   * O iterador não implementa {@code remove()} uma vez que é opcional.
   *
   * @return um iterador que passa pelas chaves em ordem crescente
   */
  public Iterator<Key> iterator() {
    return new HeapIterator();
  }

  private class HeapIterator implements Iterator<Key> {
    // Cria um novo heap
    private MinHeap<Key> copy;

    // Adiciona todos os itens na cópia
    // O(n) uma vez que já está na ordem de heap
    public HeapIterator() {
      copy = new MinHeap<Key>(size());
      for (int i = 1; i <= n; i++)
        copy.put(pq[i]);
    }

    public boolean hasNext() {
      return !copy.isEmpty();
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }

    public Key next() {
      if (!hasNext())
        throw new NoSuchElementException();
      return copy.delMin();
    }
  }

  public static void main(String[] args) {
    MinHeap<String> h = new MinHeap<String>(10);
    h.put("A");
    h.put("X");
    h.put("G");
    h.put("O");
    h.put("F");
    h.put("L");

    while (h.size() > 0) {
      System.out.println(h.delMin());
    }
  }
}
