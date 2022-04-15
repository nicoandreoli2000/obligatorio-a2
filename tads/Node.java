package tads;

public class Node<T> {
    public T data;
    public Node<T> next;

    Node(T elem) {
        this.data = elem;
        this.next = null;
    }

    @Override
    public boolean equals(Object other) {
        return this.data.equals(((Node<T>) other).data);
    }
}
 