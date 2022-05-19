package tads;

public class GraphWithMat implements Graph {
    private Object[][] matrix;
    private int size;

    public GraphWithMat(int length) {
        matrix = new Object[length][length];
        size = length;
    }

    @Override
    public void addEdge(int from, Pair<Integer, Integer> pair) {
        matrix[from][pair.key] = pair.value;
    }

    @Override
    public List<Pair<Integer, Integer>> getEdges(int node) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteEdges(int node) {
        // TODO Auto-generated method stub

    }

    @Override
    public int getSize() {
        return size;
    }

}
