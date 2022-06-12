
import java.util.Scanner;

import tads.DisjointSet;
import tads.Pair;
import tads.PriorityQueue;
import tads.MinHeap;

public class Ejercicio7 {
    public static void main(String[] args) throws Exception {
        ejercicio7();
    }

    public static void ejercicio7() throws Exception {
        Scanner in = new Scanner(System.in);
        int vertices = Integer.parseInt(in.nextLine());
        MinHeap<Pair<Integer, Integer>> pq = PriorityQueue.createMinHeapFromGraphInput(in);
        int costo = 0;
        int cont = 0;
        DisjointSet ds = new DisjointSet(vertices);
        while (!pq.isEmpty() && cont < vertices) {
            Pair<Pair<Integer, Integer>, Integer> edge = (Pair<Pair<Integer, Integer>, Integer>) pq.top();
            pq.pop();
            if (ds.find(edge.key.key) != ds.find(edge.key.value)) {
                ds.union(edge.key.key, edge.key.value);
                costo += edge.value;
                cont++;
            }

        }
        if (cont == vertices - 1) {
            System.out.print(costo);
        } else {
            System.out.print(-1);
        }
    }

}