import tads.Graph;
import tads.GraphWithMatrix;

public class Ejercicio6 {
    public static void main(String[] args) {
        GraphWithMatrix g = Graph.createGraphWithMatrixFromInput(true);
        ejercicio6(g);
    }

    public static void ejercicio6(GraphWithMatrix g) {

        Boolean[][] booleanMat = g.getWarshallMatrix();

        // Warshall
        for (int k = 0; k < g.getSize(); k++) {
            for (int i = 0; i < g.getSize(); i++) {
                for (int j = 0; j < g.getSize(); j++) {
                    booleanMat[i][j] = booleanMat[i][j] || booleanMat[i][k] && booleanMat[k][j];
                }
            }
        }
        // End Warshall

        int counter = 0;
        for (int i = 0; i < g.getSize(); i++) {
            boolean row = true;
            for (int j = 0; j < g.getSize(); j++) {
                if (!booleanMat[i][j]) {
                    row = false;
                    break;
                }
            }
            if (row) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}
