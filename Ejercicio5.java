import tads.Graph;
import tads.GraphWithList;
import tads.List;
import tads.Pair;
import tads.Stack;

public class Ejercicio5 {
    public static void main(String[] args) throws Exception {
        GraphWithList g = Graph.createGraphWithListFromInput(false);
        ejercicio5(g);
    }

    public static void ejercicio5(GraphWithList g) throws Exception {
        for (int i = 0; i < g.getSize(); i++) {
            List<Pair<Integer, Integer>> list = g.getEdges(i);
            g.deleteEdges(i);
            if (!esConexoSinUnVertice(g, i)) {
                System.out.println(i + 1);
            }
            var it = list.iterator();
            while (it.hasNext()) {
                Pair<Integer, Integer> arista = it.next();
                g.addEdge(i, arista);
            }
        }
    }

    private static boolean esConexoSinUnVertice(GraphWithList g, int v) throws Exception {
        boolean[] visited = new boolean[g.getSize()];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        // DFS
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < visited.length; i++) {
            if (i != v) {
                stack.push(i);
                break;
            }
        }
        while (!stack.isEmpty()) {
            int elem = stack.pop();
            if (!visited[elem]) {
                visited[elem] = true;
                List<Pair<Integer, Integer>> adjs = g.getEdges(elem);
                var it = adjs.iterator();
                while (it.hasNext()) {
                    Pair<Integer, Integer> arista = it.next();
                    if (!visited[arista.key]) {
                        stack.push(arista.key);
                    }
                }
            }
        }
        // END DFS

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && i != v) {
                return false;
            }
        }
        return true;
    }
}