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
    Node<T> rec = this.root;
    while (rec != null) {
      if (rec.data.equals(elem)) {
        return true;
      }
      rec = rec.next;
    }
    return false;
  }

  public void delete(T elem) {
    if (root == null) {
      return;
    }
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
    Node<T> rec = this.root;
    while (rec != null) {
      if (rec.data.equals(elem)) {
        return rec.data;
      }
      rec = rec.next;
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
    // TODO Auto-generated method stub
    return null;
  }
}
