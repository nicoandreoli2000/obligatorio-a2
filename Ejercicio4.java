
import java.util.Iterator;

import tads.*;

public class Ejercicio4 {

    public static void main(String[] args) throws Exception {

        // GraphWithList g = new GraphWithList(10);
        // g.addEdge(3, 6);
        // g.addEdge(7, 5);
        // g.addEdge(3, 5);
        // g.addEdge(6, 2);
        // g.addEdge(9, 1);
        // g.addEdge(6, 3);
        // g.addEdge(5, 7);
        // g.addEdge(5, 3);
        // g.addEdge(2, 6);
        // g.addEdge(1, 9);

        GraphWithList g = GraphWithList.createUndirectedGraphFromInput();
        g.printGraph(g);
        ejercicio4(g);
    }

    public static void ejercicio4(GraphWithList g) throws Exception {
        boolean[] visited = new boolean[g.getSize()];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int amountVisited = 0;
        stack.push(0);
        int counter = 1;
        while (amountVisited < visited.length) {
            if (stack.isEmpty()) {
                counter++;
                for (int i = 0; i < visited.length; i++) {
                    if (!visited[i]) {
                        stack.push(i);
                        break;
                    }
                }
            } else {
                int elem = stack.pop();
                visited[elem] = true;
                amountVisited++;
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
        System.out.println(counter);
    }
}
