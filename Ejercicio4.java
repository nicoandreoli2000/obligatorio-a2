
import tads.*;

public class Ejercicio4 {

    public static void main(String[] args) {
        GraphWithList g = GraphWithList.createUndirectedGraphFromInput();
        ejercicio4(g);
    }

    public static void ejercicio4(GraphWithList g) {
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
        int counter = 0;
        while (!stack.isEmpty()) {

        }
        System.out.println(counter);
    }
}
