
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
        int lastIndexNotStacked = 0;
        int counter = 0;
        while (lastIndexNotStacked != -1) {
            if (stack.isEmpty()) {
                counter++;
                for (int i = 0; i < visited.length; i++) {
                    if (!stacked[i] && !visited[i]) {
                        stack.push(i);
                        lastIndexNotStacked = updateLastIndexNotStacked(lastIndexNotStacked, i, stacked);
                        break;
                    }
                }
            } else {
                int elem = stack.pop();
                visited[elem] = true;
                List<Integer> adjs = g.getEdges(elem);
                Iterator<Integer> it = adjs.iterator();
                while (it.hasNext()) {
                    int edge = it.next();
                    if (!visited[edge] && !stacked[edge]) {
                        stack.push(edge);
                        stacked[edge] = true;
                        lastIndexNotStacked = updateLastIndexNotStacked(lastIndexNotStacked, edge, stacked);
                    }
                }
            }
        }

        System.out.println(counter);
    }

    private static int updateLastIndexNotStacked(int prev, int update, boolean[] stacked) {
        if (update != prev) {
            return prev;
        }
        for (int i = prev + 1; i < stacked.length; i++) {
            if (!stacked[i]) {
                return i;
            }
        }
        return -1;
    }
}
