package tads;

import java.util.Iterator;

public class ListIterator<T> implements Iterator<T> {
    private Node<T> root;

    @Override
    public boolean hasNext() {
      return root != null;
    }

    @Override
    public T next() {
      T elem = (T)root.data;
      root = root.next;
      return elem;
    }

    public ListIterator(Node<T> start) {
      root = start;
    }

  }