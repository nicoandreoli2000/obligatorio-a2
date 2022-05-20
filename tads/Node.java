package tads;

public class Node<T> {
    public T data;
    public Node<T> next;

    Node(T elem) {
        data = elem;
        next = null;
    }

    @Override
    public boolean equals(Object other) {
        return data.equals(((Node<T>) other).data);
    }
}
