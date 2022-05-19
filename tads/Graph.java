package tads;

import java.util.Scanner;

public interface Graph {
    void addEdge(int from, Pair<Integer, Integer> pair);

    List<Pair<Integer, Integer>> getEdges(int node);

    void deleteEdges(int node);

    int getSize();

    public static GraphWithList createGraphFromInput(boolean isDirected) {
        var in = new Scanner(System.in);
        int size = Integer.parseInt(in.nextLine());
        GraphWithList graph = new GraphWithList(size);
        int length = Integer.parseInt(in.nextLine());
        for (int i = 0; i < length; i++) {
            String line = in.nextLine();
            String[] arr = line.split(" ");
            int from = Integer.parseInt(arr[0]);
            int to = Integer.parseInt(arr[1]);
            int weight = arr.length == 3 ? Integer.parseInt(arr[2]) : 1;
            graph.addEdge(from - 1, new Pair<Integer, Integer>(to - 1, weight));
            if (!isDirected && from != to) {
                graph.addEdge(to - 1, new Pair<Integer, Integer>(from - 1, weight));
            }
        }
        in.close();
        return graph;
    }
}