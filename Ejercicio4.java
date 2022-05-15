
import java.util.Iterator;

import tads.*;

public class Ejercicio4 {

    public static void main(String[] args) throws Exception {
        GraphWithList g = GraphWithList.createUndirectedGraphFromInput();
        ejercicio4(g);
    }

    public static void ejercicio4(GraphWithList g) throws Exception {
        boolean[] visited = new boolean[g.getSize()];
        boolean[] stacked = new boolean[g.getSize()];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
            stacked[i] = false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int amountVisited = 0;
        int counter = 0;
        while (amountVisited < visited.length) {
            if (stack.isEmpty()) {
                counter++;
                for (int i = 0; i < visited.length; i++) {
                    if (!stacked[i] && !visited[i]) {
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
                    if (!visited[edge] && !stacked[edge]) {
                        stack.push(edge);
                        stacked[edge] = true;
                    }
                }
            }
        }

        System.out.println(counter);
    }
}
