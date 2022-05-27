
import java.util.Scanner;

import tads.DisjointSet;
import tads.MaxHeap;
import tads.Pair;
import tads.PriorityQueue;

public class Ejercicio7 {
    public static void main(String[] args) throws Exception {
        ejercicio7();
    }

    public static void ejercicio7() throws Exception {
        Scanner in = new Scanner(System.in);
        int vertices = Integer.parseInt(in.nextLine());
        MaxHeap<Pair<Integer, Integer>> pq = PriorityQueue.createMaxHeapFromGraphInput(in);
        int costo = 0;
        int count = 0;
        DisjointSet ds = new DisjointSet(pq.size());
        while (!pq.isEmpty() && count < vertices) {
            Pair<Pair<Integer, Integer>, Integer> edge = (Pair<Pair<Integer, Integer>, Integer>) pq.top();
            pq.pop();
            if (ds.find(edge.key.key) != ds.find(edge.key.value)) {
                ds.union(edge.key.key, edge.key.value);
                costo += edge.value;
                count++;
            }

        }
        System.out.print(count == vertices - 1 ? costo : -1);
    }
}