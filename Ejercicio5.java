
import java.util.Iterator;

import tads.GraphWithList;
import tads.List;
import tads.Stack;

public class Ejercicio5 {
    public static void main(String[] args) throws Exception {
        GraphWithList g = GraphWithList.createUndirectedGraphFromInput();
        ejercicio5(g);
    }

    public static void ejercicio5(GraphWithList g) throws Exception {
        boolean[] visited = new boolean[g.getSize()];
        for (int i = 0; i < visited.length; i++) {
            List<Integer> list = g.getEdges(i);
            g.deleteEdges(i);
            if (!esConexo(g)) {
                System.out.println(i + 1);
            }
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int to = it.next();
                g.addEdge(i, to);
            }
            visited[i] = true;
        }
    }

    private static boolean esConexo(GraphWithList g) throws Exception {
        boolean[] visited = new boolean[g.getSize()];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        // DFS
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < visited.length; i++) {
            if (g.containsEdge(i)) {
                stack.push(i);
                break;
            }
        }
        while (!stack.isEmpty()) {
            int elem = stack.pop();
            if (!visited[elem]) {
                visited[elem] = true;
                List<Integer> adjs = g.getEdges(elem);
                Iterator<Integer> it = adjs.iterator();
                while (it.hasNext()) {
                    int edge = it.next();
                    if (!visited[edge]) {
                        stack.push(edge);
                    }
                }
            }
        }
        // END DFS

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && g.containsEdge(i)) {
                return false;
            }
        }
        return true;
    }
}