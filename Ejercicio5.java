
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
        int counter = 0;
        for (int i = 0; i < visited.length; i++) {
            List<Integer> list = g.getEdges(i);
            g.deleteEdges(i);
            if (esConexo(g)) {
                counter++;
            }
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int to = it.next();
                g.addEdge(i, to);
            }
            visited[i] = true;
        }
        System.out.println(counter);
    }

    private static boolean esConexo(GraphWithList g) {
        Boolean[] visited = new Boolean[g.getSize()];
        dfs(0, visited, g);
        for (int i = 0; i < g.getSize(); i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    private static void dfs(int origin, Boolean[] visited, GraphWithList g) {
        visited[origin] = true;
        List<Integer> list = g.getEdges(origin);
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            Integer curr = it.next();
            if (!visited[curr]) {
                dfs(curr, visited, g);
            }
        }
    }
}