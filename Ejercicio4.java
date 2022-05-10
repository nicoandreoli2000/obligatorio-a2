import java.util.Arrays;

import tads.*;

public class Ejercicio4 {

    public static void main(String[] args) {
        Grafo<Integer> g = Grafo.convertFromText();
        ejercicio4(g, 1);
    }

    public static void ejercicio4(Grafo<Integer> g, Integer vertice) {
        Boolean[] visitados = new Boolean[g.getSize()];
        Boolean[] pase = new Boolean[g.getSize()];
        Arrays.fill(visitados, false);
        Arrays.fill(pase, false);
        visitados[vertice - 1] = true;
        boolean entro2 = false;
        boolean termino = false;
        Integer conexos = 1;
        Integer aux = -1;
        for (int h = 0; h < visitados.length && !termino; h++) {
            if (entro2) {
                h = aux;
                entro2 = false;
                visitados[h] = true;
            }
            Boolean entro = false;
            for (int i = 0; i < visitados.length && !entro; i++) {
                Boolean[] copiaV = Grafo.createCopy(visitados);
                for (int j = 0; j < visitados.length; j++) {
                    // verifico que sea un vertice adyacente a uno ya utilizado y que el mismo
                    // no le haya agregado sus adyacentes
                    if (visitados[j] && !pase[j]) {
                        Object[] adys = g.getAdys(j + 1);
                        pase[j] = true;
                        if (adys != null) {
                            for (int k = 0; k < adys.length && adys[k] != null; k++) {
                                // añado los vertices adyacentes a visitados
                                Pair<Integer, Integer> pair = (Pair<Integer, Integer>) adys[k];
                                visitados[pair.fst() - 1] = true;
                            }
                        }

                    }
                }
                if (Arrays.equals(visitados, copiaV)) {
                    entro = true;
                    // lo uso para saber si el array fue modificado,
                    // sirve para ver si empezaria a repetir vertices
                }
            }
            for (int u = 0; u < visitados.length && !entro2; u++) {
                if (visitados[u] == false) {
                    aux = u;
                    conexos++;
                    entro2 = true;
                    // lo uso para ver si entro en este for, si es asi guardo
                    // con que valor entro para usarlo luego
                }
            }
            if (Grafo.allTrue(visitados)) {
                termino = true;
            }
        }

        System.out.println(conexos);
    }
}
