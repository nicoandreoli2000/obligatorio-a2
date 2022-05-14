package tads;

public class GraphWithList implements Graph {

    private Object[] list;

    public GraphWithList(int expectedSize) {
        list = new Object[expectedSize];
        for (int i = 0; i < expectedSize; i++) {
            list[i] = new List<Integer>();
        }
    }

    @Override
    public void addEdge(Integer from, Integer to) {
        List<Integer> node = (List<Integer>) list[from];
        node.insert(to);
    }

    @Override
    public List<Integer> getEdges(Integer node) {
        List<Integer> edges = (List<Integer>) list[node];
        return edges;
    }

    @Override
    public void deleteEdges(Integer node) {
        list[node] = null;
    }

}
