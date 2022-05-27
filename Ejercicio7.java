
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
        // Fijarse si es conexo y devolver -1
        Scanner in = new Scanner(System.in);
        int vertices = Integer.parseInt(in.nextLine());
        MaxHeap<Pair<Integer, Integer>> pq = PriorityQueue.createMaxHeapFromGraphInput(in);
        pq.printHeap();
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
        System.out.print(costo);
    }
}