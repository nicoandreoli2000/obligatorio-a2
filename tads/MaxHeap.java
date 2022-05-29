package tads;

public class MaxHeap<E> implements PriorityQueue<E> {
    private Object[] arr;
    private int size;
    private int max;

    public MaxHeap(int maxSize) {
        arr = new Object[maxSize + 1];
        size = 0;
        max = maxSize;
    }

    @Override
    public void push(E elem, int prio) throws Exception {
        if (this.isFull()) {
            throw new Exception("El Heap está lleno");
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
        arr[1] = arr[size];
        size--;
        doSink(1);
    }

    @Override
    public Pair<E, Integer> top() throws Exception {
        if (isEmpty()) {
            throw new Exception("El Heap está vacío");
        }
        return (Pair<E, Integer>) arr[1];
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
        if (i >= size / 2) {
            return;
        }

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
        if (i == 1) {
            return;
        }
        Pair<E, Integer> parent = (Pair<E, Integer>) arr[i / 2];
        Pair<E, Integer> actual = (Pair<E, Integer>) arr[i];
        if (parent.value < actual.value) {
            arr[i / 2] = actual;
            arr[i] = parent;
            doFloat(i / 2);
        }
    }

    public void printHeap() {
        for (int i = 1; i < max; i++) {
            Pair<Pair<Integer, Integer>, Integer> pair = (Pair<Pair<Integer, Integer>, Integer>) arr[i];
            System.out.println((pair.key.key + 1) + " -> " + (pair.key.value + 1) + " - " + pair.value);
        }
    }

}
