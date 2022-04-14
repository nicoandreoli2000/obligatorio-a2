package tads;

public class Node<T> {
    public T data;
    public Node<T> next;

    Node(T elem) {
        this.data = elem;
        this.next = null;
    }
}
