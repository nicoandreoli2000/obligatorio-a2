import java.util.Iterator;

import tads.DisjointSet;
import tads.Graph;
import tads.GraphWithList;
import tads.Heap;
import tads.List;
import tads.Pair;

public class Ejercicio7 {
    public static void main(String[] args) throws Exception {
        GraphWithList g = Graph.createGraphWithListFromInput(false);
        ejercicio7(g);
    }

    public static void ejercicio7(GraphWithList g) throws Exception {
        Heap<Pair<Integer, Integer>> pq = new Heap<Pair<Integer, Integer>>(g.getSize());
        for (int i = 0; i < g.getSize(); i++) {
            List<Pair<Integer, Integer>> adys = g.getEdges(i);
            Iterator<Pair<Integer, Integer>> it = adys.iterator();
            while (it.hasNext()) {
                Pair<Integer, Integer> pair = it.next();
                pq.push(new Pair<Integer, Integer>(i, pair.key), pair.value);
            }
        }
        int costo = 0;
        DisjointSet ds = new DisjointSet(g.getSize());
        while (!pq.isEmpty()) {
            Pair<Pair<Integer, Integer>, Integer> edge = (Pair<Pair<Integer, Integer>, Integer>) pq.top();
            pq.pop();
            if (ds.find(edge.key.key) != ds.find(edge.key.value)) {
                ds.union(edge.key.key, edge.key.value);
                costo += edge.value;
            }

        }
        System.out.println(costo);
    }
}