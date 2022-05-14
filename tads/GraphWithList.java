package tads;

import java.util.Iterator;
import java.util.Scanner;

public class GraphWithList implements Graph {

    private Object[] list;
    private int size;

    public GraphWithList(int expectedSize) {
        list = new Object[expectedSize];
        for (int i = 0; i < expectedSize; i++) {
            list[i] = null;
        }
        size = expectedSize;
    }

    @Override
    public void addEdge(Integer from, Integer to) {
        if (list[from] == null) {
            list[from] = new List<Integer>();
        }
        List<Integer> node = (List<Integer>) list[from];
        node.insert(to);
    }

    @Override
    public Boolean containsEdge(Integer node) {
        return list[node] != null;
    }

    @Override
    public List<Integer> getEdges(Integer node) {
        List<Integer> edges = (List<Integer>) list[node];
        return edges == null ? new List<Integer>() : edges;
    }

    @Override
    public void deleteEdges(Integer node) {
        list[node] = null;
    }

    @Override
    public int getSize() {
        return size;
    }

    public static GraphWithList createGraphFromInput() {
        var in = new Scanner(System.in);
        Integer size = Integer.parseInt(in.nextLine());
        GraphWithList graph = new GraphWithList(size);
        Integer length = Integer.parseInt(in.nextLine());
        for (int i = 0; i < length; i++) {
            String line = in.nextLine();
            String[] arr = line.split(" ");
            Integer from = Integer.parseInt(arr[0]);
            Integer to = Integer.parseInt(arr[1]);
            graph.addEdge(from - 1, to - 1);
            graph.addEdge(to - 1, from - 1);
        }
        in.close();
        return graph;
    }

    public void printGraph(GraphWithList g) {
        for (int i = 0; i < g.getSize(); i++) {
            List<Integer> list = g.getEdges(i);
            if (list != null) {
                System.out.print("Vertice " + (i + 1) + ": ");
            }
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                Integer arista = it.next();
                System.out.print((arista + 1) + " -> ");
            }
            System.out.println("NULL");
        }
    }

}
