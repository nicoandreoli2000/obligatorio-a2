
import java.util.Iterator;
import tads.GraphWithList;
import tads.List;

public class Ejercicio5 {
    public static void main(String[] args) {
        GraphWithList g = GraphWithList.createGraphFromInput();
        ejercicio5(g);
    }

    public static void ejercicio5(GraphWithList g) {
        Boolean[] visited = new Boolean[g.getSize()];
        for (int i = 0; i < visited.length; i++) {
            List<Integer> list = g.getEdges(i);
            if (list != null) {
                g.deleteEdges(i);
                if (!esConexo(g)) {
                    System.out.println(i + 1);
                }
                Iterator<Integer> it = list.iterator();
                while (it.hasNext()) {
                    int to = it.next();
                    g.addEdge(i, to);
                }
            }
            visited[i] = true;
        }
    }

    private static boolean esConexo(GraphWithList g) {
        Boolean[] visited = new Boolean[g.getSize()];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        for (int i = 0; i < visited.length; i++) {
            List<Integer> list = g.getEdges(i);
            if (list != null) {
                Iterator<Integer> it = list.iterator();
                while (it.hasNext()) {
                    Integer edge = it.next();
                    visited[edge] = true;
                }
            }
        }
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
}