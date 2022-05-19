package tads;

public interface Graph {
    void addEdge(int from, int to);

    List<Integer> getEdges(int node);

    void deleteEdges(int node);

    int getSize();
}