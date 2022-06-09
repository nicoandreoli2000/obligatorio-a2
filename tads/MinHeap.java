package tads;

public class MinHeap<E> implements PriorityQueue<E> {
    private MaxHeap<E> heap;

    public MinHeap(int maxSize) {
        heap = new MaxHeap<E>(maxSize);
    }

    @Override
    public void push(E elem, int prio) throws Exception {
        heap.push(elem, -prio);
    }

    @Override
    public void pop() {
        heap.pop();
    }

    @Override
    public Pair<E, Integer> top() throws Exception {
        Pair<E, Integer> res = heap.top();
        return new Pair<E, Integer>(res.key, -res.value);
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public boolean isFull() {
        return heap.isFull();
    }

    @Override
    public int size() {
        return heap.size();
    }

}
