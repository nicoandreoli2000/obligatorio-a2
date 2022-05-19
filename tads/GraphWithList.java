package tads;

import java.util.Iterator;
import java.util.Scanner;

public class GraphWithList implements Graph {

    private Object[] list;
    private int size;

    public GraphWithList(int length) {
        list = new Object[length];
        size = length;
    }

    @Override
    public void addEdge(int from, Pair<Integer, Integer> pair) {
        if (list[from] == null) {
            list[from] = new List<Pair<Integer, Integer>>();
        }
        List<Pair<Integer, Integer>> node = (List<Pair<Integer, Integer>>) list[from];
        node.insert(pair);
    }

    @Override
    public List<Pair<Integer, Integer>> getEdges(int node) {
        List<Pair<Integer, Integer>> edges = (List<Pair<Integer, Integer>>) list[node];
        return edges == null ? new List<Pair<Integer, Integer>>() : edges;
    }

    @Override
    public void deleteEdges(int node) {
        list[node] = null;
    }

    @Override
    public int getSize() {
        return size;
    }

    public static GraphWithList createUndirectedAndUnweightedGraphFromInput() {
        var in = new Scanner(System.in);
        int size = Integer.parseInt(in.nextLine());
        GraphWithList graph = new GraphWithList(size);
        int length = Integer.parseInt(in.nextLine());
        for (int i = 0; i < length; i++) {
            String line = in.nextLine();
            String[] arr = line.split(" ");
            int from = Integer.parseInt(arr[0]);
            int to = Integer.parseInt(arr[1]);
            graph.addEdge(from - 1, new Pair<Integer, Integer>(to - 1, 1));
            if (from != to) {
                graph.addEdge(to - 1, new Pair<Integer, Integer>(from - 1, 1));
            }
        }
        in.close();
        return graph;
    }

    public void printGraph(GraphWithList g) {
        for (int i = 0; i < g.getSize(); i++) {
            List<Pair<Integer, Integer>> list = g.getEdges(i);
            if (list != null) {
                System.out.print("Vertice " + (i + 1) + ": ");
            }
            Iterator<Pair<Integer, Integer>> it = list.iterator();
            while (it.hasNext()) {
                int arista = it.next().key;
                System.out.print((arista + 1) + " -> ");
            }
            System.out.println("NULL");
        }
    }

}