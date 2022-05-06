package tads;

import java.util.Iterator;

public class List<T> implements Iterable<T> {
  private Node<T> root;
  private int size;

  public List() {
    this.root = null;
    this.size = 0;
  }

  public void insert(T elem) {
    Node<T> newNode = new Node<T>(elem);
    newNode.next = root;
    root = newNode;
    size++;
  }

  public boolean contains(T elem) {
    var it = iterator();
    while(it.hasNext()){
      if(it.next().equals(elem)) return true;
    }

    return false;
  }

  public void delete(T elem) {
    if (root == null) {
      return;
    }
    this.size--;
    if (root.data.equals(elem)) {
      root = root.next;
      return;
    }
    Node<T> pre = root;
    Node<T> post = root.next;
    while (post != null) {
      if (post.data.equals(elem)) {
        pre.next = post.next;
        size--;
        return;
      }
      pre = pre.next;
      post = post.next;
    }
  }

  public T get(T elem) throws Exception {
    var it = iterator();
    while(it.hasNext()){
      var data = it.next();
      if(data.equals(elem)) return data;
    }
    throw new Exception("La lista no contiene el elemento: " + elem.toString());
  }

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  @Override
  public Iterator<T> iterator() {
    return new ListIterator(root, size);
  }

  private class ListIterator implements Iterator<T> {
    private Node<T> actual;
    private int sizeActual;


    @Override
    public boolean hasNext() {
        return actual != null;
    }

    @Override
    public T next() {
        T elem = actual.data;
        actual = actual.next;
        sizeActual--;
        return elem;
    }


    public ListIterator(Node<T> start, Integer startSize){
      actual = start;
      sizeActual = startSize;
    }
  }
}
