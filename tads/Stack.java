package tads;

public class Stack<T> {
    private List<T> root;
    private int size;

    public Stack() {
        root = new List<T>();
        size = 0;
    }

    public void push(T elem) {
        root.insert(elem);
        size++;
    }

    public T pop() throws Exception {
        T elem = root.first();
        root.delete(elem);
        size--;
        return elem;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
