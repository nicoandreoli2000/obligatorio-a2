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
    Iterator<T> it = this.iterator();
    while (it.hasNext()) {
      if (it.next().equals(elem)) {
        return true;
      }
    }
    return false;
  }

  public void delete(T elem) {
    Iterator<T> it = this.iterator();
    while (it.hasNext()) {
      if (it.next().equals(elem)) {
        it.remove();
        size--;
        return;
      }
    }
  }

  public T get(T elem) throws Exception {
    Iterator<T> it = this.iterator();
    while (it.hasNext()) {
      T next = it.next();
      if (next.equals(elem)) {
        return next;
      }
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
    return new ListIterator<T>(root);
  }

}
