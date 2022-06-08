package tads;

public class MinHeap<E> implements PriorityQueue<E> {
    private Object[] arr;
    private int size;

    public MinHeap(int maxSize) {
        arr = new Object[maxSize + 1];
        size = 0;
    }

    @Override
    public void push(E elem, int prio) throws Exception {
        if (isFull()) {
            throw new Exception("El Heap está lleno");
        }
        arr[size++] = new Pair<E, Integer>(elem, prio);
        doFloat(size - 1);
    }

    @Override
    public void pop() {
        if (isEmpty()) {
            return;
        }
        arr[0] = arr[size - 1];
        size--;
        doSink(0);
    }

    @Override
    public Pair<E, Integer> top() throws Exception {
        if (isEmpty()) {
            throw new Exception("El Heap está vacío");
        }
        return (Pair<E, Integer>) arr[0];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == arr.length;
    }

    @Override
    public int size() {
        return size;
    }

    private void doSink(int i) {
        Pair<E, Integer> temp = (Pair<E, Integer>) arr[i];
        while (kthChild(i, 1) < size) {
            int c = minChild(i);
            Pair<E, Integer> child = (Pair<E, Integer>) arr[c];
            if (temp.value > child.value) {
                arr[i] = child;
            } else {
                break;
            }
            i = c;
        }
        arr[i] = temp;
    }

    private void doFloat(int i) {
        Pair<E, Integer> temp = (Pair<E, Integer>) arr[i];
        while (i > 0 && temp.value > ((Pair<E, Integer>) arr[parent(i)]).value) {
            arr[i] = arr[parent(i)];
            i = parent(i);
        }
        arr[i] = temp;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int kthChild(int i, int k) {
        return 2 * i + k;
    }

    private int minChild(int i) {
        int leftChild = kthChild(i, 1);
        int rightChild = kthChild(i, 2);
        return ((Pair<E, Integer>) arr[leftChild]).value < ((Pair<E, Integer>) arr[rightChild]).value ? leftChild
                : rightChild;
    }
}
