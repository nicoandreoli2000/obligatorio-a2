package tads;

public class GraphWithMatrix implements Graph {
    private Object[][] matrix;
    private int size;

    public GraphWithMatrix(int length) {
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

    public Boolean[][] getWarshallMatrix() {
        Boolean[][] booleanMatrix = new Boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Pair<Integer, Integer> elem = (Pair<Integer, Integer>) matrix[i][j];
                if (elem.key > 0) {
                    booleanMatrix[i][j] = true;
                }
            }
        }
        return booleanMatrix;
    }

}
