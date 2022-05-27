
import tads.DisjointSet;
import tads.MaxHeap;
import tads.Pair;
import tads.PriorityQueue;

public class Ejercicio7 {
    public static void main(String[] args) throws Exception {
        MaxHeap<Integer> h = new MaxHeap<Integer>(6);
        h.push(1, 3);
        h.push(2, 4);
        h.push(5, 1);
        h.push(3, 2);
        h.push(4, 3);
        h.push(6, 6);
        h.pop();
        h.pop();
        h.pop();
        h.pop();
        h.pop();
        h.pop();

        ejercicio7();
    }

    public static void ejercicio7() throws Exception {
        MaxHeap<Pair<Integer, Integer>> pq = PriorityQueue.createMaxHeapFromGraphInput();
        int costo = 0;
        DisjointSet ds = new DisjointSet(pq.size());
        while (!pq.isEmpty()) {
            Pair<Pair<Integer, Integer>, Integer> edge = (Pair<Pair<Integer, Integer>, Integer>) pq.top();
            pq.pop();
            if (ds.find(edge.key.key) != ds.find(edge.key.value)) {
                ds.union(edge.key.key, edge.key.value);
                costo += edge.value;
            }

        }
        System.out.print(costo);
    }
}