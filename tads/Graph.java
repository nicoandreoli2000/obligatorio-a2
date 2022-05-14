package tads;

public interface Graph {
    void addEdge(Integer from, Integer to);

    boolean containsEdge(Integer node);

    List<Integer> getEdges(Integer node);

    void deleteEdges(Integer node);

    int getSize();
}
