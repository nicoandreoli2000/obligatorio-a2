package tads;

public interface PriorityQueue<E> {
    public void push(E elem, int prio) throws Exception;

    public void pop();

    public Pair<E, Integer> top() throws Exception;

    public boolean isEmpty();

    public boolean isFull();

    public int size();
}
