import tads.Grafo;

public class Ejercicio5 {
    public static void main(String[] args) {
        Grafo<Integer> g = Grafo.convertFromText();
        ejercicio5(g);
    }

    public static void ejercicio5(Grafo<Integer> g) {
        Boolean[] visited = new Boolean[g.getSize()];
        int counter = 0;
        for (int i = 0; i < visited.length; i++) {
            // elimino vertice y adjacentes
            if (esConexo(g)) {
                counter++;
            }
            // agrego vertice y adjacentes
            visited[i] = true;
        }
        System.out.println(counter);
    }

    private static boolean esConexo(Grafo<Integer> g) {
        return true;
    }
}
