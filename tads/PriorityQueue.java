package tads;

import java.util.Scanner;

public interface PriorityQueue<E> {
    public void push(E elem, int prio) throws Exception;

    public void pop();

    public Pair<E, Integer> top() throws Exception;

    public boolean isEmpty();

    public boolean isFull();

    public int size();

    public static MaxHeap<Pair<Integer, Integer>> createMaxHeapFromGraphInput(Scanner in) throws Exception {
        int length = Integer.parseInt(in.nextLine());
        MaxHeap<Pair<Integer, Integer>> heap = new MaxHeap<Pair<Integer, Integer>>(length);
        for (int i = 0; i < length; i++) {
            String line = in.nextLine();
            String[] arr = line.split(" ");
            int from = Integer.parseInt(arr[0]);
            int to = Integer.parseInt(arr[1]);
            int weight = Integer.parseInt(arr[2]);
            heap.push(new Pair<Integer, Integer>(from - 1, to - 1), weight);
        }
        in.close();
        return heap;
    }
}
