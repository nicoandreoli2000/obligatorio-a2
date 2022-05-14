package tads;

public interface Graph {
    void addEdge(Integer from, Integer to);

    List<Integer> getEdges(Integer node);

    void deleteEdges(Integer node);

}
