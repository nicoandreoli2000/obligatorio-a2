package tads;

public class Heap<E> implements PriorityQueue<E> {
    private Object[] arr;
    private int size;
    private int max;

    public Heap(int maxSize) {
        arr = new Object[maxSize];
        size = 0;
        max = maxSize;
    }

    @Override
    public void push(E elem, int prio) throws Exception {
        if (this.isFull()) {
            throw new Exception("El Heap esta lleno");
        }
        size++;
        arr[size] = new Pair<E, Integer>(elem, prio);
        doFloat(size);
    }

    @Override
    public void pop() {
        if (this.isEmpty()) {
            return;
        }
        arr[0] = arr[size];
        size--;
        doSink(0);
    }

    @Override
    public Pair<E, Integer> top() throws Exception {
        return (Pair<E, Integer>) arr[0];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == max;
    }

    @Override
    public int size() {
        return size;
    }

    private void doSink(int i) {
        Pair<E, Integer> actual = (Pair<E, Integer>) arr[i];
        Pair<E, Integer> rightSon = (Pair<E, Integer>) arr[i * 2 + 1];
        Pair<E, Integer> leftSon = (Pair<E, Integer>) arr[i * 2];
        if (rightSon == null && leftSon == null) {
            return;
        }
        if (leftSon == null && rightSon.value > actual.value) {
            arr[i] = rightSon;
            arr[i * 2 + 1] = actual;
            return;
        }
        if (rightSon == null && leftSon.value > actual.value) {
            arr[i] = leftSon;
            arr[i * 2] = actual;
            return;
        }
        if (actual.value < leftSon.value || actual.value < rightSon.value) {
            if (leftSon.value > rightSon.value) {
                arr[i] = leftSon;
                arr[i * 2] = actual;
                doSink(i * 2);
            } else {
                arr[i] = leftSon;
                arr[i * 2 + 1] = actual;
                doSink(i * 2 + 1);
            }
        }
    }

    private void doFloat(int i) {
        if (i == 0) {
            return;
        }
        Pair<E, Integer> parent = (Pair<E, Integer>) arr[i % 2];
        Pair<E, Integer> actual = (Pair<E, Integer>) arr[i];
        if (parent.value < actual.value) {
            arr[i % 2] = actual;
            arr[i] = parent;
            doFloat(i % 2);
        }
    }

}
