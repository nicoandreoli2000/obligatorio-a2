package tads;

public interface Graph {
    void addEdge(int from, Pair<Integer, Integer> pair);

    List<Pair<Integer, Integer>> getEdges(int node);

    void deleteEdges(int node);

    int getSize();
}