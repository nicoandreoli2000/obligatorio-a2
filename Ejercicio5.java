
import java.util.Iterator;

import tads.GraphWithList;
import tads.List;
import tads.Stack;

public class Ejercicio5 {
    public static void main(String[] args) throws Exception {
        // GraphWithList g = new GraphWithList(5);
        // g.addEdge(3, 2);
        // g.addEdge(4, 3);
        // g.addEdge(0, 0);
        // g.addEdge(1, 2);
        // g.addEdge(2, 2);
        // g.addEdge(3, 3);
        // g.addEdge(2, 0);
        // g.addEdge(4, 4);
        GraphWithList g = GraphWithList.createGraphFromInput();
        ejercicio5(g);
    }

    public static void ejercicio5(GraphWithList g) throws Exception {
        // printGraph(g);
        boolean[] visited = new boolean[g.getSize()];
        for (int i = 0; i < visited.length; i++) {
            List<Integer> list = g.getEdges(i);
            g.deleteEdges(i);
            // printGraph(g);
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
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < visited.length; i++) {
            if (g.containsEdge(i)) {
                stack.push(i);
                break;
            }
        }
        while (!stack.isEmpty()) {
            int elem = stack.pop();
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

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && g.containsEdge(i)) {
                return false;
            }
        }
        return true;
    }

    public static void printGraph(GraphWithList g) {
        for (int i = 0; i < g.getSize(); i++) {
            List<Integer> list = g.getEdges(i);
            if (list != null) {
                System.out.print("Vertice " + (i + 1) + ": ");
            }
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                Integer arista = it.next();
                System.out.print((arista + 1) + " -> ");
            }
            System.out.println("NULL");
        }
    }
}